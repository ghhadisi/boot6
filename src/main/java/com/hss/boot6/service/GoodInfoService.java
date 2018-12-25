package com.hss.boot6.service;

import com.hss.boot6.bean.GoodInfoEntity;
import com.hss.boot6.jpa.GoodInfoRepository;
import com.hss.boot6.task.GoodAddTimer;
import com.hss.boot6.task.GoodSecKillRemindTimer;
import com.hss.boot6.task.GoodStockCheckTimer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional(rollbackFor = Exception.class)
public class GoodInfoService {
    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;
    /**
     * 商品数据接口
     */
    @Autowired
    private GoodInfoRepository goodInfoRepository;

//    /**
//     * 保存商品基本信息
//     * @param good 商品实例
//     * @return
//     */
//    public Long saveGood(GoodInfoEntity good) throws Exception
//    {
//        goodInfoRepository.save(good);
//        return good.getId();
//    }


    /**
     * 构建创建商品定时任务
     */
    public void buildCreateGoodTimer() throws Exception
    {
        //设置开始时间为1分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodAddTimer.class.getName();
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodAddTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).startAt(new Date(startAtTime)).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
/*    在上面方法中我们定义的GoodAddTimer实例只运行一次，在商品添加完成后延迟1分钟进行调用任务主体逻辑。

    其中任务的名称以及任务的分组是为了区分任务做的限制，在同一个分组下如果加入同样名称的任务，则会提示任务已经存在，添加失败的提示。

    我们通过JobDetail来构建一个任务实例，设置GoodAddTimer类作为任务运行目标对象，当任务被触发时就会执行GoodAddTimer内的executeInternal方法。

    一个任务需要设置对应的触发器，触发器也分为很多种，该任务中我们并没有采用cron表达式来设置触发器，而是调用startAt方法设置任务开始执行时间。

    最后将任务以及任务的触发器共同交付给任务调度器，这样就完成了一个任务的设置。*/



    /**
     * 构建商品库存定时任务
     * @throws Exception
     */
    public void buildGoodStockTimer() throws Exception
    {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodStockCheckTimer.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodStockCheckTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
    //该任务的触发器我们采用了cron表达式来设置，每隔30秒执行一次任务主体逻辑。

    /**
     * 保存商品基本信息
     * @param good 商品实例
     * @return
     */
    public Long saveGood(GoodInfoEntity good) throws Exception
    {
        goodInfoRepository.save(good);
        //构建创建商品定时任务
        buildCreateGoodTimer();
        //构建商品库存定时任务
        buildGoodStockTimer();
        //构建商品描述提醒定时任务
        buildGoodSecKillRemindTimer(good.getId());
        return good.getId();
    }

    /**
     * 构建商品秒杀提醒定时任务
     * 设置五分钟后执行
     * @throws Exception
     */
    public void buildGoodSecKillRemindTimer(Long goodId) throws Exception
    {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodSecKillRemindTimer.class.getName();
        //秒杀开始时间
        long startTime = System.currentTimeMillis() + 1000 * 5 * 60;
        JobDetail jobDetail = JobBuilder
                .newJob(GoodSecKillRemindTimer.class)
                .withIdentity(name,group)
                .build();

        //设置任务传递商品编号参数
        jobDetail.getJobDataMap().put("goodId",goodId);

        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).startAt(new Date(startTime)).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail,trigger);
    }

}

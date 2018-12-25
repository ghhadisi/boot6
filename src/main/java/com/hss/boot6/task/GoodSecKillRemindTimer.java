package com.hss.boot6.task;

import lombok.extern.java.Log;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Log
public class GoodSecKillRemindTimer extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取任务详情内的数据集合
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        //获取商品编号
        Long goodId = dataMap.getLong("goodId");
        log.info("分布式节点quartz-cluster-node-first，开始处理秒杀商品：{"+goodId+"}，关注用户推送消息.");
    }
}

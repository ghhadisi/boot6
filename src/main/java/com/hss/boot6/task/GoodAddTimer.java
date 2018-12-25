package com.hss.boot6.task;

import lombok.extern.java.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 商品添加定时任务实现类
 */
@Log
public class GoodAddTimer extends QuartzJobBean {
    /**
     * 定时任务逻辑实现方法
     * 每当触发器触发时会执行该方法逻辑
     * @param jobExecutionContext 任务执行上下文
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("商品添加完成后执行任务，任务时间：{"+new Date()+"}");
    }
}

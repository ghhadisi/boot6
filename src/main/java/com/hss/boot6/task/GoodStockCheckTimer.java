package com.hss.boot6.task;

import lombok.extern.java.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 商品库存检查定时任务
 */
@Log
public class GoodStockCheckTimer  extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行库存检查定时任务，执行时间：{"+new Date()+"}");

    }
}

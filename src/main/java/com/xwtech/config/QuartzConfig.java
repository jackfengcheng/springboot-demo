package com.xwtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.xwtech.quartz.QuartzDemo;

//@Configuration
public class QuartzConfig {
	
	/**
	 * job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(QuartzDemo.class);
		return jobDetailFactoryBean;
	}

	/**
	 * Trigger对象
	 */
//	@Bean
//	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
//		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//		//关联jobdetail对象
//		simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//		//该i参数表述执行的毫秒数
//		simpleTriggerFactoryBean.setRepeatInterval(3000);
//		//重复的次数
//		simpleTriggerFactoryBean.setRepeatCount(10);
//		return simpleTriggerFactoryBean;
//	}
	

	/**
	 * cron Trigger对象
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
		cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
		return cronTriggerFactoryBean;
	}
	
	/**
	 * Scheduler对象
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
		schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
		return schedulerFactoryBean;
	}
}

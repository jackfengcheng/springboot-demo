package com.xwtech.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xwtech.service.UserService;


public class QuartzDemo implements Job {
	
	@Autowired
	private UserService UsersService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("jack--------->" + new Date());
	}

}

package com.rafpereira.scheduler.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.rafpereira.accesscontrol.data.util.AccessControlSessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rafpereira"})
public class ScheduleRunnerRestApplication {

	public static void main(String[] args) {
		new AccessControlSessionFactoryUtil();
		new SchedulerSessionFactoryUtil();
		SpringApplication.run(ScheduleRunnerRestApplication.class, args);
	}

}

package com.rafpereira.scheduler.test;

import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.business.util.ScheduleUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.Schedule;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class TestCreateRunClear {

	public static void main(String[] args) {
		
		SessionFactoryUtil schedSessionFactory = new SchedulerSessionFactoryUtil();

		ScheduleUtil sUtil = new ScheduleUtil();
		
		Schedule sched = new Schedule();
		sched.setName("Agenda 1");
		sched.setDescription("Agenda 1 (for test).");
		sched.setOwnership(ScheduleOwnership.PRIVATE);
		
		sUtil.save(sched);
		System.out.println("Id schedule: " + sched.getId());
		
		
		sUtil.remove(sched);
		
		System.out.println("quant schedules: " + sUtil.list().size());
		
		schedSessionFactory.close();
	}

}

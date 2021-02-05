package com.rafpereira.scheduler.test;

import com.rafpereira.accesscontrol.business.util.EventTypeUtil;
import com.rafpereira.accesscontrol.business.util.FeatureTypeUtil;
import com.rafpereira.accesscontrol.data.util.AccessControlSessionFactoryUtil;
import com.rafpereira.accesscontrol.model.EventType;
import com.rafpereira.accesscontrol.model.FeatureType;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.business.util.DayOfWeekUtil;
import com.rafpereira.scheduler.business.util.ProcessTypeUtil;
import com.rafpereira.scheduler.business.util.ScheduleOwnershipUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.DayOfWeek;
import com.rafpereira.scheduler.model.ProcessType;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class TestDBConnectivity {

	public static void main(String[] args) {
		SessionFactoryUtil schedSessionFactory = new SchedulerSessionFactoryUtil();
		SessionFactoryUtil accessControlSessionFactory = new AccessControlSessionFactoryUtil();

		ScheduleOwnershipUtil soUtil = new ScheduleOwnershipUtil();
		for (ScheduleOwnership so : soUtil.list()) {
			System.out.println(so.getId() + " " + so.getDescription());
		}

		ProcessTypeUtil ptUtil = new ProcessTypeUtil();
		for (ProcessType pt : ptUtil.list()) {
			System.out.println(pt.getId() + " " + pt.getDescription());
		}

		DayOfWeekUtil dowUtil = new DayOfWeekUtil();
		for (DayOfWeek dow : dowUtil.list()) {
			System.out.println(dow.getId() + " " + dow.getDescription());
		}
		

		
		
		
		FeatureTypeUtil ftUtil = new FeatureTypeUtil();
		for (FeatureType ft : ftUtil.list()) {
			System.out.println(ft.getId() + " " + ft.getDescription());
		}

		EventTypeUtil etUtil = new EventTypeUtil();
		for (EventType et : etUtil.list()) {
			System.out.println(et.getId() + " " + et.getDescription());
		}

		schedSessionFactory.close();
		accessControlSessionFactory.close();
	}

}

package com.rafpereira.scheduler.test;

import com.rafpereira.accesscontrol.business.util.FeatureTypeUtil;
import com.rafpereira.accesscontrol.data.util.AccessControlSessionFactoryUtil;
import com.rafpereira.accesscontrol.model.FeatureType;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.business.util.ProcessTypeUtil;
import com.rafpereira.scheduler.business.util.ScheduleOwnershipUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ProcessType;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class Test {

	public static void main(String[] args) {
		SessionFactoryUtil schedSessionFactory = new SchedulerSessionFactoryUtil();
		SessionFactoryUtil accessControlSessionFactory = new AccessControlSessionFactoryUtil();

		ScheduleOwnershipUtil soUtil = new ScheduleOwnershipUtil();
		for (ScheduleOwnership so : soUtil.listByFilter(null)) {
			System.out.println(so.getId() + " " + so.getDescription());
		}

		ProcessTypeUtil ptUtil = new ProcessTypeUtil();
		for (ProcessType pt : ptUtil.listByFilter(null)) {
			System.out.println(pt.getId() + " " + pt.getDescription());
		}

		
		FeatureTypeUtil ftUtil = new FeatureTypeUtil();
		for (FeatureType ft : ftUtil.listByFilter(null)) {
			System.out.println(ft.getId() + " " + ft.getDescription());
		}
		
		schedSessionFactory.close();
		accessControlSessionFactory.close();
	}

}

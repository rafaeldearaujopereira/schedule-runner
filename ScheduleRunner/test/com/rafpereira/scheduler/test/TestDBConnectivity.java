package com.rafpereira.scheduler.test;

import com.rafpereira.accesscontrol.business.util.FeatureTypeUtil;
import com.rafpereira.accesscontrol.data.util.AccessControlSessionFactoryUtil;
import com.rafpereira.accesscontrol.model.FeatureType;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.business.util.ScheduleOwnershipUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class TestDBConnectivity {

	public static void main(String[] args) {
		SessionFactoryUtil schedSessionFactory = new SchedulerSessionFactoryUtil();
		SessionFactoryUtil accessControlSessionFactory = new AccessControlSessionFactoryUtil();

		ScheduleOwnershipUtil soUtil = new ScheduleOwnershipUtil();

		for (ScheduleOwnership so : soUtil.listByFilter(null)) {
			System.out.println(so.getId() + " " + so.getDescription());
		}

		
		FeatureTypeUtil ftUtil = new FeatureTypeUtil();

		for (FeatureType ft : ftUtil.listByFilter(null)) {
			System.out.println(ft.getId() + " " + ft.getDescription());
		}
		
		schedSessionFactory.close();
		accessControlSessionFactory.close();
	}

}

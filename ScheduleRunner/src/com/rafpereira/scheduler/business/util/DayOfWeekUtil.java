package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.DayOfWeek;

public class DayOfWeekUtil extends CrudAccessControlUtil<DayOfWeek> {

	@Override
	public List<DayOfWeek> listByFilter(DayOfWeek dayFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();

		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from DayOfWeek dow ");
		sb.append("where 1 = 1 ");

		if (dayFilter != null) {
			if (dayFilter.getId() != null) {
				sb.append("and dow.id = ?" + params.size() + " ");
				params.add(dayFilter.getId());
			}
			if (dayFilter.getDescription() != null && !dayFilter.getDescription().trim().equals("")) {
				sb.append("and upper(dow.description) like ?" + params.size() + " ");
				params.add("%" + dayFilter.getDescription().trim().toUpperCase() + "%");
			}
		}

		sb.append("order by dow.id");

		TypedQuery<DayOfWeek> query = session.createQuery(sb.toString(), DayOfWeek.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<DayOfWeek> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

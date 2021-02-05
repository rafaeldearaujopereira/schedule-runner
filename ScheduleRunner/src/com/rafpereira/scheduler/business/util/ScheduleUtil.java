package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.Schedule;

/**
 * The CRUD Util class for Schedule.
 * @author rafaeldearaujopereira
 */
public class ScheduleUtil extends CrudAccessControlUtil<Schedule> {

	@Override
	public List<Schedule> listByFilter(Schedule scheduleFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from Schedule s ");
		sb.append("where 1 = 1 ");
		
		if (scheduleFilter != null) {
			if (scheduleFilter.getName() != null && !scheduleFilter.getName().trim().equals("")) {
				sb.append("and upper(s.name) like ?" + params.size() + " ");
				params.add("%" + scheduleFilter.getName().trim().toUpperCase() + "%");
			}
			if (scheduleFilter.getDescription() != null && !scheduleFilter.getDescription().trim().equals("")) {
				sb.append("and upper(s.description) like ?" + params.size() + " ");
				params.add("%" + scheduleFilter.getDescription().trim().toUpperCase() + "%");
			}
		}
		
		sb.append("order by s.name");
		
		TypedQuery<Schedule> query = session.createQuery(sb.toString(), Schedule.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<Schedule> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

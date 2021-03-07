package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.Activity;

/**
 * The CRUD Util class for Activity.
 * @author rafaeldearaujopereira
 */
public class ActivityUtil extends CrudAccessControlUtil<Activity> {

	@Override
	public List<Activity> listByFilter(Activity activityFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from Activity a ");
		sb.append("where 1 = 1 ");
		
		if (activityFilter != null) {
			if (activityFilter.getName() != null && !activityFilter.getName().trim().equals("")) {
				sb.append("and upper(a.name) like ?" + params.size() + " ");
				params.add("%" + activityFilter.getName().trim().toUpperCase() + "%");
			}

			if (activityFilter.getProcess() != null && activityFilter.getProcess().getId() != null) {
				sb.append("and a.process.id = ?" + params.size() + " ");
				params.add(activityFilter.getProcess().getId());
			}
		}
		
		sb.append("order by a.name");
		
		TypedQuery<Activity> query = session.createQuery(sb.toString(), Activity.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<Activity> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.Process;

/**
 * The CRUD Util class for Process.
 * @author rafaeldearaujopereira
 */
public class ProcessUtil extends CrudAccessControlUtil<Process> {

	@Override
	public List<Process> listByFilter(Process processFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from Process p ");
		sb.append("where 1 = 1 ");
		
		if (processFilter != null) {
			if (processFilter.getName() != null && !processFilter.getName().trim().equals("")) {
				sb.append("and upper(p.name) like ?" + params.size() + " ");
				params.add("%" + processFilter.getName().trim().toUpperCase() + "%");
			}
		}
		
		sb.append("order by p.name");
		
		TypedQuery<Process> query = session.createQuery(sb.toString(), Process.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<Process> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

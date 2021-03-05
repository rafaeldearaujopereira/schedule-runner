package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ProcessParameter;

/**
 * The CRUD Util class for ProcessParameter.
 * @author rafaeldearaujopereira
 */
public class ProcessParameterUtil extends CrudAccessControlUtil<ProcessParameter> {

	@Override
	public List<ProcessParameter> listByFilter(ProcessParameter parameterFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from ProcessParameter pp ");
		sb.append("where 1 = 1 ");
		
		if (parameterFilter != null) {
			if (parameterFilter.getName() != null && !parameterFilter.getName().trim().equals("")) {
				sb.append("and upper(pp.name) like ?" + params.size() + " ");
				params.add("%" + parameterFilter.getName().trim().toUpperCase() + "%");
			}
			if (parameterFilter.getDescription() != null && !parameterFilter.getDescription().trim().equals("")) {
				sb.append("and upper(pp.description) like ?" + params.size() + " ");
				params.add("%" + parameterFilter.getDescription().trim().toUpperCase() + "%");
			}
		}
		
		sb.append("order by pp.name");
		
		TypedQuery<ProcessParameter> query = session.createQuery(sb.toString(), ProcessParameter.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<ProcessParameter> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

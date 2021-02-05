package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ProcessType;

/**
 * The CRUD Util class for Process Type.
 * 
 * @author rafaeldearaujopereira
 */
public class ProcessTypeUtil extends CrudAccessControlUtil<ProcessType> {

	@Override
	public List<ProcessType> listByFilter(ProcessType typeFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();

		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from ProcessType pt ");
		sb.append("where 1 = 1 ");

		if (typeFilter != null) {
			if (typeFilter.getDescription() != null && !typeFilter.getDescription().trim().equals("")) {
				sb.append("and upper(pt.description) like ?" + params.size() + " ");
				params.add("%" + typeFilter.getDescription().trim().toUpperCase() + "%");
			}
		}

		sb.append("order by pt.description");

		TypedQuery<ProcessType> query = session.createQuery(sb.toString(), ProcessType.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<ProcessType> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

	/**
	 * Disable the save method.
	 */
	@Override
	public boolean save(ProcessType t) {
		return false;
	}

	/**
	 * Disable the remove method.
	 */
	@Override
	public boolean remove(ProcessType t) {
		return false;
	}

}

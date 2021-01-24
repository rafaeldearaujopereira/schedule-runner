package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class ScheduleOwnershipUtil extends CrudAccessControlUtil<ScheduleOwnership> {

	@Override
	public List<ScheduleOwnership> listByFilter(ScheduleOwnership ownershipFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from ScheduleOwnership so ");
		sb.append("where 1 = 1 ");
		
		if (ownershipFilter != null) {
			if (ownershipFilter.getDescription() != null && !ownershipFilter.getDescription().trim().equals("")) {
				sb.append("and upper(so.description) like ?" + params.size() + " ");
				params.add("%" + ownershipFilter.getDescription().trim().toUpperCase() + "%");
			}
		}
		
		sb.append("order by so.description");
		
		TypedQuery<ScheduleOwnership> query = session.createQuery(sb.toString(), ScheduleOwnership.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<ScheduleOwnership> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

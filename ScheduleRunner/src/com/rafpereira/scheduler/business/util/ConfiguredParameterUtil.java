package com.rafpereira.scheduler.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.data.util.SchedulerSessionFactoryUtil;
import com.rafpereira.scheduler.model.ConfiguredParameter;

/**
 * The CRUD Util class for ConfiguredParameter.
 * @author rafaeldearaujopereira
 */
public class ConfiguredParameterUtil extends CrudAccessControlUtil<ConfiguredParameter> {

	@Override
	public List<ConfiguredParameter> listByFilter(ConfiguredParameter parameterFilter, boolean loadChildren) {

		Session session = getSessionFactoryInstance().getSession();
		
		ArrayList<Object> params = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("from ConfiguredParameter cp ");
		sb.append("where 1 = 1 ");
		
		if (parameterFilter != null) {
			if (parameterFilter.getParameter() != null && parameterFilter.getParameter().getId() != null) {
				sb.append("and cp.parameter.id = ?" + params.size() + " ");
				params.add(parameterFilter.getParameter().getId());
			}
		}
		
		sb.append("order by cp.parameter.name");
		
		TypedQuery<ConfiguredParameter> query = session.createQuery(sb.toString(), ConfiguredParameter.class);
		for (int iParam = 0; iParam < params.size(); iParam++) {
			query.setParameter(iParam, params.get(iParam));
		}
		List<ConfiguredParameter> items = query.getResultList();
		session.close();
		return items;
	}

	@Override
	public SessionFactoryUtil getSessionFactoryInstance() {
		return SchedulerSessionFactoryUtil.getInstance();
	}

}

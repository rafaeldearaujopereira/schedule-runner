package com.rafpereira.scheduler.rest.service;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.accesscontrol.rest.auth.api.UserAuthenticationService;
import com.rafpereira.accesscontrol.rest.service.CrudController;
import com.rafpereira.scheduler.business.util.ScheduleOwnershipUtil;
import com.rafpereira.scheduler.model.ProcessType;
import com.rafpereira.scheduler.model.ScheduleOwnership;

@RestController
@RequestMapping("/scheduleOwnerships")
public class ScheduleOwnershipController extends CrudController<ScheduleOwnership> {

	@NonNull
	UserAuthenticationService authentication;

	@Override
	protected CrudAccessControlUtil<ScheduleOwnership> getCrudUtil() {
		return new ScheduleOwnershipUtil();
	}

	@Override
	public String getNewItemFeatureCode() {
		return null;
	}

	@Override
	public String getUpdateItemFeatureCode() {
		return null;
	}

	@Override
	public String getSearchFeatureCode() {
		return null;
	}

	@Override
	protected Long getItemId(ScheduleOwnership processType) {
		return processType.getId();
	}

	@Override
	protected ScheduleOwnership getNewItem(Long id) {
		ScheduleOwnership feature = new ScheduleOwnership();
		feature.setId(id);
		return feature;
	}

}

package com.rafpereira.scheduler.rest.service;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafpereira.accesscontrol.business.util.CrudAccessControlUtil;
import com.rafpereira.accesscontrol.rest.auth.api.UserAuthenticationService;
import com.rafpereira.accesscontrol.rest.service.CrudController;
import com.rafpereira.scheduler.business.util.ProcessTypeUtil;
import com.rafpereira.scheduler.model.ProcessType;

@RestController
@RequestMapping("/processTypes")
public class ProcessTypeController extends CrudController<ProcessType> {

	@NonNull
	UserAuthenticationService authentication;

	@Override
	protected CrudAccessControlUtil<ProcessType> getCrudUtil() {
		return new ProcessTypeUtil();
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
	protected Long getItemId(ProcessType processType) {
		return processType.getId();
	}

	@Override
	protected ProcessType getNewItem(Long id) {
		ProcessType feature = new ProcessType();
		feature.setId(id);
		return feature;
	}

}

package com.sdi.business.impl;


import com.sdi.business.AlumnosService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.TasksService;
import com.sdi.business.UserService;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AlumnosService createAlumnosService() {
		return new SimpleAlumnosService();
	}

	@Override
	public TasksService createTaskService() {
		return new SimpleTaskService();
	}

	@Override
	public UserService createUserService() {
		return new SimpleUserService();
	}

}

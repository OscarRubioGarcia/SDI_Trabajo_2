package com.sdi.business.impl;


import com.sdi.business.AlumnosService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.TasksService;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AlumnosService createAlumnosService() {
		return new SimpleAlumnosService();
	}

	@Override
	public TasksService createTaskService() {
		return new SimpleTaskService();
	}

}

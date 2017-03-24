package com.sdi.business.impl;


import com.sdi.business.AlumnosService;
import com.sdi.business.CategoriesService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.TasksService;
import com.sdi.business.UsersService;

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
	public UsersService createUserService() {
		return new SimpleUserService();
	}

	@Override
	public CategoriesService createCategoryService() {
		return new SimpleCategoryService();
	}

}

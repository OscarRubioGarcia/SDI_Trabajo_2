package com.sdi.business;

public interface ServicesFactory {
	
	AlumnosService createAlumnosService();
	
	TasksService createTaskService();
	
	UserService createUserService();

}

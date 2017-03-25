package com.sdi.business;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.presentation.BeanUsers;

public class BaseDeDatos {

	/**
	 * borra toda la base de datos menos lo relativo al administrador admin1
	 */
	public static void borraTodo(){
		BeanUsers buser = new BeanUsers();
		buser.listado();
		List<User> usuarios = buser.getUsersList();
		
		for (User user : usuarios)
			if (!"admin1".equals(user.getLogin()))
				buser.baja(user);
	}
	
	/**
	 * crea en la base 3 usuarios genéricos 
	 */
	public static String iniciaUsuarios(){
		UsersService service;
		try{
			service = Factories.services.createUserService();
			
			service.save(new User("user1", "user1@user.com", "user1"));
			service.save(new User("user2", "user2@user.com", "user2"));
			service.save(new User("user3", "user3@user.com", "user3"));

			return "exito";
		} catch(Exception e){
			return "error";
		}
	}
	
	/**
	 * crea en la base tareas genéricas para los 3 usuarios genéricos 
	 */
	public static String iniciaTareas(){
		TasksService service;
		try{
			service = Factories.services.createTaskService();
			
			// TODO: añadir tareas a los usuarios 
			
			return "exito";
		} catch(Exception e){
			return "error";
		}
	}
	
	/**
	 * crea en la base categorías genéricas para los 3 usuarios genéricos
	 */
	public static String iniciaCategorias(){
		CategoriesService service;
		try{
			service = Factories.services.createCategoryService();
			
			// TODO: 
			
			return "exito";
		} catch(Exception e){
			return "error";
		}
	}
}

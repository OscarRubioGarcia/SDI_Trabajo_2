package com.sdi.business.impl.classes.users;

import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.persistence.UserDao;

public class UsersBuscar {

	public User find(long id) throws EntityNotFoundException {
		UserDao dao = Factories.persistence.createUserDao();
		User u = dao.findById(id);
		if ( u == null) {
			throw new EntityNotFoundException("No se ha encontrado el usuario");
		}
		
		return u;
	}
	
	public User findAdmin(String name, String pass) throws EntityNotFoundException{
		UserDao dao = Factories.persistence.createUserDao();
		User u = dao.findByLoginAndPassword(name, pass);
		if ( u == null) {
			throw new EntityNotFoundException("No se ha encontrado el usuario");
		}
		
		return u.getIsAdmin()? u:null;
	}
}


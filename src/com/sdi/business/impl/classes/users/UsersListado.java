package com.sdi.business.impl.classes.users;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.persistence.UserDao;

public class UsersListado {

	public User getUserId(Long id) throws Exception {
		UserDao dao = Factories.persistence.createUserDao();
		return  dao.findById(id);
	}

	public List<User> getAllUsers() {
		UserDao dao = Factories.persistence.createUserDao();
		return  dao.findAll();
	}
}

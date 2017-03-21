package com.sdi.business.impl.classes.users;

import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.persistence.UserDao;
import com.sdi.persistence.exception.PersistenceException;

public class UsersAlta {

	public void save(User user) throws EntityAlreadyExistsException {
		UserDao dao = Factories.persistence.createUserDao();
		try {
			dao.save(user);
		}
		catch (PersistenceException ex) {
			throw new EntityAlreadyExistsException("Usuario ya existe " + user, ex);
		}
	}
}


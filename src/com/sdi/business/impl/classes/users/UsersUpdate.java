package com.sdi.business.impl.classes.users;

import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.persistence.UserDao;
import com.sdi.persistence.exception.PersistenceException;

public class UsersUpdate {

	public void update(User user) throws EntityNotFoundException {
		UserDao dao = Factories.persistence.createUserDao();
		try {
			dao.update(user);
		}
		catch (PersistenceException ex) {
			throw new EntityNotFoundException("User no actualizado " + user, ex);
		}
	}
	
}

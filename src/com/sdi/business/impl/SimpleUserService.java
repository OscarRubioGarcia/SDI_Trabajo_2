package com.sdi.business.impl;

import java.util.List;

import com.sdi.business.UsersService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.business.impl.classes.users.UsersAlta;
import com.sdi.business.impl.classes.users.UsersBuscar;
import com.sdi.business.impl.classes.users.UsersListado;
import com.sdi.business.impl.classes.users.UsersUpdate;
import com.sdi.model.User;

public class SimpleUserService implements UsersService {

	@Override
	public List<User> listUsers() throws BusinessException {
		return new UsersListado().getAllUsers();
	}

	@Override
	public void enableUser(Long id) throws BusinessException, EntityNotFoundException {
		new UsersUpdate().enable(id);
	}

	@Override
	public void disableUser(Long id) throws BusinessException, EntityNotFoundException {
		new UsersUpdate().disable(id);
	}

	@Override
	public void update(User user) throws EntityNotFoundException {
		new UsersUpdate().update(user);
		
	}

	@Override
	public User findAdmin(String name, String pass) throws EntityNotFoundException {
		return new UsersBuscar().findAdmin(name, pass);
	}

	@Override
	public Long save(User user) throws BusinessException,
			EntityAlreadyExistsException {
		return new UsersAlta().save(user);
	}

	@Override
	public User find(String login, String password) throws EntityNotFoundException {
		return new UsersBuscar().find(login, password);
	}

	@Override
	public void deleteUser(Long id) throws EntityNotFoundException {
		new UsersUpdate().delete(id);
	}
	
}

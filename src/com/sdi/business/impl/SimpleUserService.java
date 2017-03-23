package com.sdi.business.impl;

import java.util.List;

import com.sdi.business.UsersService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.business.impl.classes.users.UsersBuscar;
import com.sdi.model.User;

public class SimpleUserService implements UsersService {

	@Override
	public Long registerUser(User user) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findLoggableUser(String login, String password)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUsers() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User tarea) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findAdminUser(String name, String pass) throws EntityNotFoundException {
		return new UsersBuscar().findAdmin(name, pass);
	}
	
}

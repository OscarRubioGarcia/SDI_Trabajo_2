package com.sdi.business.impl;

import java.util.List;

import com.sdi.business.UserService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.model.User;

/**
 * Clase de implementación (una de las posibles) del interfaz de la fachada de
 * servicios
 * 
 * @author Enrique
 * 
 */
public class SimpleUserService implements UserService {

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
	
}

package com.sdi.business;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.model.User;

public interface UsersService {

	//public User findLoggableUser(String login, String password) throws BusinessException;
	public List<User> listUsers() throws BusinessException;
	public void enableUser(Long id) throws BusinessException, EntityNotFoundException;
	public void disableUser(Long id) throws BusinessException, EntityNotFoundException;
	public Long save(User user) throws BusinessException, EntityAlreadyExistsException;;
	
	public void update(User tarea) throws EntityNotFoundException;
	public User findAdmin(String name, String pass) throws EntityNotFoundException;
}

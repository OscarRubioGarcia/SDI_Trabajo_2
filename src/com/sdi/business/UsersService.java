package com.sdi.business;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.model.User;

public interface UsersService {

	public Long registerUser(User user) throws BusinessException;
	public void updateUserDetails(User user) throws BusinessException;
	public User findLoggableUser(String login, String password) throws BusinessException;
	public List<User> listUsers() throws BusinessException;
	public void enableUser(Long id) throws BusinessException;
	public void disableUser(Long id) throws BusinessException;
	public void save(User user);
	
	public void updateUser(User tarea) throws EntityNotFoundException;
	public void deleteUser(Long id) throws EntityNotFoundException;
	public User findAdminUser(String name, String pass) throws EntityNotFoundException;
}

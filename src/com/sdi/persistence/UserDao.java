package com.sdi.persistence;

import com.sdi.model.User;
import com.sdi.persistence.exception.AlreadyPersistedException;
import com.sdi.persistence.util.GenericDao;

public interface UserDao extends GenericDao<User, Long>{

	User findByLogin(String login);
	User findByLoginAndPassword(String login, String password);
	void enableUser(Long id);
	void disableUser(Long id);
	int delete(Long id);
	Long save(User u) throws AlreadyPersistedException;
}

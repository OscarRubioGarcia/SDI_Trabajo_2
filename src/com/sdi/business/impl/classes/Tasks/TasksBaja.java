package com.sdi.business.impl.classes.tasks;

import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.infrastructure.Factories;
import com.sdi.persistence.TaskDao;

public class TasksBaja {

	public void delete(Long id) throws EntityNotFoundException {
		TaskDao dao = Factories.persistence.createTareaDao();
		dao.delete(id);
	}
}

package com.sdi.business.impl.classes.Tasks;

import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Task;
import com.sdi.persistence.TaskDao;

public class TasksAlta {

	public void save(Task tarea) throws EntityAlreadyExistsException {
		TaskDao dao = Factories.persistence.createTareaDao();
		dao.save(tarea);
	}

}

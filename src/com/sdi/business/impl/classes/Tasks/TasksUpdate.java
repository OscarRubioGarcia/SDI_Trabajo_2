package com.sdi.business.impl.classes.Tasks;

import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Task;
import com.sdi.persistence.TaskDao;

public class TasksUpdate {

	public void update(Task tarea) throws EntityNotFoundException {
		TaskDao dao = Factories.persistence.createTareaDao();
		dao.update(tarea);
	}

}

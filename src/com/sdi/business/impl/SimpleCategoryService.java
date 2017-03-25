package com.sdi.business.impl;

import com.sdi.business.CategoriesService;
import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.business.impl.classes.CategoriesBaja;

public class SimpleCategoryService implements CategoriesService {

	@Override
	public int deleteAllByUserId(Long id) throws BusinessException, EntityNotFoundException {
		return new CategoriesBaja().deleteAllByUserId(id);
	}

}

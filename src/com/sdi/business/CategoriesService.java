package com.sdi.business;

import com.sdi.business.exception.BusinessException;
import com.sdi.business.exception.EntityNotFoundException;

public interface CategoriesService {

	public int deleteAllByUserId(Long id) throws BusinessException, EntityNotFoundException;
}

package com.optica.services;

import com.optica.domain.Curriculum;

public interface CurriculumService {

	Curriculum findById(Long id);

	void save(Curriculum curriculum);

	void delete(Long id);

}

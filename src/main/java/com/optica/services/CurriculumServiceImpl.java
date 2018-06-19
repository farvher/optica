package com.optica.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.Curriculum;
import com.optica.repository.CurriculumDao;

@Service
public class CurriculumServiceImpl implements CurriculumService {

	@Autowired
	private CurriculumDao curriculumDao;

	@Override
	public Curriculum findById(Long id) {
		return curriculumDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Curriculum not found"));
	}

	@Override
	public void save(Curriculum curriculum) {
		curriculumDao.save(curriculum);

	}

	@Override
	public void delete(Long id) {
		curriculumDao.deleteById(id);

	}

}

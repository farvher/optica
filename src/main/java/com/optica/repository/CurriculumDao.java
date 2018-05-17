package com.optica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.Curriculum;
@Repository
public interface CurriculumDao  extends JpaRepository<Curriculum, Long>{

}

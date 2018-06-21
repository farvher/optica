package com.optica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.Experience;

@Repository
public interface ExperienceDao extends JpaRepository<Experience, Long> {

}

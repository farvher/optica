package com.optica.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.Apply;

@Repository
public interface ApplyDao extends JpaRepository<Apply, Long> {

	List<Apply> findByCurriculumId(Long id, Pageable pageable);

	List<Apply> findByJobOfferId(Long id, Pageable pageable);

	List<Apply> findByJobOfferIdAndCurriculumId(Long id1, Long id2);
}

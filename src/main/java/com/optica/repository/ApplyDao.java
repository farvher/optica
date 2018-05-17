package com.optica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.Apply;
@Repository
public interface ApplyDao extends JpaRepository<Apply, Long>{

}

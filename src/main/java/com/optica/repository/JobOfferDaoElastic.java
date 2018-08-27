package com.optica.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.optica.domain.JobOffer;
@Repository
public interface JobOfferDaoElastic  extends ElasticsearchCrudRepository< JobOffer,Long>{
	
	

}

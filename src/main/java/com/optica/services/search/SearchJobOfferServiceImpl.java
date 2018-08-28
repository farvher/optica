package com.optica.services.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.JobOffer;
import com.optica.repository.JobOfferDaoElastic;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;

@Service
public class SearchJobOfferServiceImpl implements SearchJobOfferService {
	
	private static final String INDEX ="";
	private static final String TYPE ="";

	private final Logger logger = LoggerFactory.getLogger(SearchJobOfferServiceImpl.class);

	@Autowired
	private JestClient jestClient;

	@Autowired
	private JobOfferDaoElastic jobOfferDaoElastic;

	@Override
	public List<JobOffer> findJobOffersByKeyword(String keyword) {
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.queryString(keyword));
	

			Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(INDEX).addType(TYPE)
					.build();

			JestResult result = jestClient.execute(search);
			return result.getSourceAsObjectList(JobOffer.class);

		} catch (IOException e) {
			logger.error("Search error", e);
		} catch (Exception e) {
			logger.error("Search error", e);
		}
		return new ArrayList<JobOffer>();
	}

	@Override
	public List<JobOffer> findJobOffersByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOffer> findJobOffersByKeywordAndCity(String keyword, String city) {
		// TODO Auto-generated method stub
		return null;
	}

}

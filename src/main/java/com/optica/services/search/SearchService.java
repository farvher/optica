package com.optica.services.search;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.JobOffer;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

@Service
public class SearchService {

	final static Logger logger = LoggerFactory.getLogger(SearchService.class);

	private final static String JOB_INDEX = "jobs";

	private final static String JOB_TYPE = "job";
	
	private final static Integer MAX_SIZE_PAGE = 20;

	@Autowired
	JestClient jestClient;

	private void deleteIndexIfExists(String index) {
		logger.info("[deleteIndexIfExists]");
		DeleteIndex deleteIndex = new DeleteIndex.Builder(index).build();
		try {
			jestClient.execute(deleteIndex);
		} catch (IOException ex) {
			logger.error("ERROR DELETING INDEX", ex);
		}

	}

	private void createIndexIfNotExists(String index) {
		logger.info("[createIndexIfNotExists]");
		IndicesExists indicesExists = new IndicesExists.Builder(index).build();
		try {
			JestResult result = jestClient.execute(indicesExists);
			if (!result.isSucceeded()) {
				// Create articles index
				CreateIndex createIndex = new CreateIndex.Builder(index).build();
				JestResult resultCreate = jestClient.execute(createIndex);
				if(resultCreate.isSucceeded()) {
					logger.info(MessageFormat.format("{0} INDEX CREATED", index));
				}else{
					throw new IllegalStateException("ERROR CREATING INDEZ");
				};
				
			} else {
				logger.info(MessageFormat.format("{0} ALREADY EXISTS", index));
			}
		} catch (IOException ex) {
			logger.error("ERROR CREATING INDEX", ex);
		}
	}

	public void createJobOffer(JobOffer jobOffer) {

		logger.info("[createJobOffer]");
		try {

			createIndexIfNotExists(JOB_INDEX);
			Bulk bulk = new Bulk.Builder()
					.addAction(new Index.Builder(jobOffer)
							.index(JOB_INDEX)
							.type(JOB_TYPE).build())
					.build();

			JestResult result = jestClient.execute(bulk);
			if(result.isSucceeded()) {
				
				logger.info("CREATED");
			}else {
				throw new IllegalStateException("ERROR CREATING REGISTRY");
			}

			logger.info(result.getJsonString());

		} catch (IOException e) {
			logger.error("ERROR IO  INDEXING", e);
		} catch (Exception e) {
			logger.error("ERROR INDEXING", e);
		}

	}

	public List<JobOffer> searchByQueryString(String param) {
		logger.info("[searchArticles]");
		logger.info(param);
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.queryString(param));
			searchSourceBuilder.size(MAX_SIZE_PAGE);
			
			logger.info(searchSourceBuilder.toString());
			Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(JOB_INDEX).addType(JOB_TYPE)
					.build();

			JestResult result = jestClient.execute(search);
			if(result.isSucceeded()) {
				logger.info(result.getSourceAsString());
				
			}else {
				throw new IllegalStateException("ERROR SEARCHING BY QUERY STRING");
			}
		
			return result.getSourceAsObjectList(JobOffer.class);

		} catch (IOException e) {
			logger.error("SEARCH IO ERROR", e);
		} catch (Exception e) {
			logger.error("SEARCH ERROR", e);
		}
		return new ArrayList<>();
	}
}
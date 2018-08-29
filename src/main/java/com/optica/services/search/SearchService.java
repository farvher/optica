package com.optica.services.search;

import java.io.IOException;
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
import io.searchbox.indices.IndicesExists;

@Service
public class SearchService {

    final static Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    JestClient jestClient;


    public void indexSampleArticles(JobOffer jobOffer) {


        try {
            // Delete articles index if it is exists
            //DeleteIndex deleteIndex = new DeleteIndex.Builder("articles").build();
            //jestClient.execute(deleteIndex);

            IndicesExists indicesExists = new IndicesExists.Builder("articles").build();
            JestResult result = jestClient.execute(indicesExists);

            if (!result.isSucceeded()) {
                // Create articles index
                CreateIndex createIndex = new CreateIndex.Builder("articles").build();
                jestClient.execute(createIndex);
            }

            /**
             *  if you don't want to use bulk api use below code in a loop.
             *
             *  Index index = new Index.Builder(source).index("articles").type("article").build();
             *  jestClient.execute(index);
             *
             */

            Bulk bulk = new Bulk.Builder()
                    .addAction(new Index.Builder(jobOffer).index("articles").type("article").build())
                    .build();

            result = jestClient.execute(bulk);

            System.out.println(result.getJsonString());

        } catch (IOException e) {
            logger.error("Indexing error", e);
        } catch (Exception e) {
            logger.error("Indexing error", e);
        }

    }

    public List<JobOffer> searchArticles(String param) {
        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.queryString(param));

            Search search = new Search.Builder(searchSourceBuilder.toString())
                    .addIndex("articles")
                    .addType("article")
                    .build();

            JestResult result = jestClient.execute(search);
            return result.getSourceAsObjectList(JobOffer.class);

        } catch (IOException e) {
            logger.error("Search error", e);
        } catch (Exception e) {
            logger.error("Search error", e);
        }
        return null;
    }
}
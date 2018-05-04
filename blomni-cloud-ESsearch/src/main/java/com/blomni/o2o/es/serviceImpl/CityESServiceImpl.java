package com.blomni.o2o.es.serviceImpl;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blomni.o2o.es.bean.Article;
import com.blomni.o2o.es.bean.Entity;
import com.blomni.o2o.es.repository.ArticleSearchRepository;
import com.blomni.o2o.es.repository.CityESService;

@Service
public class CityESServiceImpl implements CityESService {

	 private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);  
     
	
	@Autowired
    private JestClient jestClient;  
      
	@Autowired
	private ArticleSearchRepository client;
	
	 @Override  
	    public void saveEntity(Entity entity) {  
	        Index index = new Index.Builder(entity).index(Entity.INDEX_NAME).type(Entity.TYPE).build();  
	        try {  
	            jestClient.execute(index);  
	            LOGGER.info("ES 插入完成");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            LOGGER.error(e.getMessage());  
	        }  
	    }  
	      
	      
	    /** 
	     * 批量保存内容到ES 
	     */  
	    @Override  
	    public void saveEntity(List<Entity> entityList) {  
	        Bulk.Builder bulk = new Bulk.Builder();  
	        for(Entity entity : entityList) {  
	            Index index = new Index.Builder(entity).index(Entity.INDEX_NAME).type(Entity.TYPE).build();  
	            bulk.addAction(index);  
	        }         
	        try {  
	            jestClient.execute(bulk.build());  
	            LOGGER.info("ES 插入完成");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            LOGGER.error(e.getMessage());  
	        }  
	    }  
	      
	    /** 
	     * 在ES中搜索内容 
	     */  
	    @Override  
	    public List<Entity> searchEntity(String searchContent){  
	        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
	        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));  
	        //searchSourceBuilder.field("name");  
	        searchSourceBuilder.query(QueryBuilders.matchQuery("name", searchContent));  
	        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(Entity.INDEX_NAME).addType(Entity.TYPE).build();  
	        try {  
	            JestResult result = jestClient.execute(search);  
	            return result.getSourceAsObjectList(Entity.class);  
	        } catch (IOException e) {  
	            LOGGER.error(e.getMessage());  
	            e.printStackTrace();  
	        }  
	        return null;          
	    }  

	    
	


		@Override
		public List<Entity> searchAllEntity() {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
	        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));  
	        //searchSourceBuilder.field("name");  
	        searchSourceBuilder.query(QueryBuilders.matchAllQuery());  
	        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(Entity.INDEX_NAME).addType(Entity.TYPE).build();  
	        try {  
	            JestResult result = jestClient.execute(search);  
	            return result.getSourceAsObjectList(Entity.class);  
	        } catch (IOException e) {  
	            LOGGER.error(e.getMessage());  
	            e.printStackTrace();  
	        }  
	        return null;    
		}


		@Override
		public void saveEntityBySpringData(List<Article> art) {
			
	        client.saveAll(art);
			
		}


		@Override
		public List<Article> searchEntityBySpringData(String content) {
			QueryStringQueryBuilder builder=new QueryStringQueryBuilder(content);
			List<Article> a=(List<Article>) client.search(builder);
			return a;
		}  
}

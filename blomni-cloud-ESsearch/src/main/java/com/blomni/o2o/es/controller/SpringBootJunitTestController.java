package com.blomni.o2o.es.controller;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.support.QuerySourceBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.blomni.o2o.es.ESApplication;
import com.blomni.o2o.es.bean.Article;
import com.blomni.o2o.es.bean.Entity;
import com.blomni.o2o.es.repository.ArticleSearchRepository;
import com.blomni.o2o.es.repository.CityESService;
import com.blomni.o2o.es.repository.EntityRepository;


@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=ESApplication.class)// 指定spring-boot的启动类 
public class SpringBootJunitTestController {
	
	private static final Logger logs = LoggerFactory.getLogger(SpringBootJunitTestController.class);
	
	@Autowired
	private CityESService cityESService;
	
	@Autowired
	private ArticleSearchRepository client;
	
	@Autowired
	private EntityRepository er;
	
	@Autowired
    private JestClient jestClient;  
	
	@Test
    public void test4() throws Exception{
/*		List<Entity> entityList=new ArrayList<Entity>();
		Entity ent=null;
		for (int i = 0; i < 10; i++) {
			ent=new Entity();
			ent.setId((long)i);
			ent.setName("abckdd"+i*4);
			entityList.add(ent);
		}
	
		cityESService.saveEntity(entityList);*/
		
		
		/*List<Entity> entityList=cityESService.searchEntity("abckdd0");
		logs.info("输出={}",JSONObject.toJSONString(entityList));*/
		/*System.out.println("条件搜索"+JSONObject.toJSONString(this.cityESService.searchEntity("在")));
		
		
		System.out.println("所有数据="+JSONObject.toJSONString(this.cityESService.searchAllEntity()));*/
		
		
		
		
		
		//-----------------------添加记录---------------------------
		/*List<Article> entityList=new ArrayList<Article>();
		Article ent=null;
		for (int i = 0; i <5; i++) {
			ent=new Article();
			ent.setId(1L+i);
			ent.setAbstracts("这是第"+i+"个测试");
			ent.setContent("我是第"+i+"个人");
			ent.setTitle("这个是第"+i+"标题");
			entityList.add(ent);
		}
		
		cityESService.saveEntityBySpringData(entityList);*/
		
//		Article ent=new Article();
//		ent.setAbstracts("这个不知道是什么");
//		ent.setContent("测试的内容 是es");
//		ent.setId(1L);
//		ent.setTitle("tanlq 测试");
//		Article art=client.save(ent);
//		System.out.println("结果输出"+art);
		
		
		//----------------------查询记录----------------------------
		/*String queryString = "测试";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Entity> searchResult = er.search(builder);
        Iterator<Entity> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            System.out.println("输出"+iterator.next());
        }*/
		
		//添加
	/*	Article art=new Article();
		art.setAbstracts("这个不知道是什么");
		art.setContent("测试的内容 是es");
		art.setId(1L);
		art.setTitle("tanlq 测试");
		Index index = new Index.Builder(art).index(Article.INDEX_NAME).type(Article.TYPE).build();  
		
		jestClient.execute(index);*/
		
		//查询
		 	SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		 	
	        searchSourceBuilder.query(QueryBuilders.matchQuery("", ""));
	        
			//{\"query\":{\"match\":{\"content\":\"测试\"}}}
			System.out.println("串串"+searchSourceBuilder.toString());
	       Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(Entity.INDEX_NAME).addType(Entity.TYPE).build();
	       //执行action，返回结果              
	       SearchResult result = jestClient.execute(search);
	       
	       System.out.println("输出"+result.getJsonString());
		
    }
	
	
	
	
	
	
	
	
	
}

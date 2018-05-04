package com.blomni.o2o.es.repository;

import java.util.List;

import com.blomni.o2o.es.bean.Article;
import com.blomni.o2o.es.bean.Entity;

public interface CityESService {

	void saveEntity(Entity entity);  
    
    void saveEntity(List<Entity> entityList);  
      
    List<Entity> searchEntity(String searchContent);
 
    public List<Entity> searchAllEntity();
    
    void saveEntityBySpringData(List<Article> art);
    
    List<Article> searchEntityBySpringData(String content);
}

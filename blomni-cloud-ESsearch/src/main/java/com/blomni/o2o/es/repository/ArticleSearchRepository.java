package com.blomni.o2o.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.blomni.o2o.es.bean.Article;

@Component
public interface ArticleSearchRepository  extends  ElasticsearchRepository<Article, Long> {

}

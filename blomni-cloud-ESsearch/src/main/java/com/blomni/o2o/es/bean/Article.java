package com.blomni.o2o.es.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="projectname",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Article implements Serializable  {
	
	public static final String INDEX_NAME = "projectname";
	
	public static final String TYPE = "article";
	
	@Id
    private Long id;
    /**标题*/
    private String title;
    /**摘要*/
    private String abstracts;
    /**内容*/
    private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
	@Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", content='" + content +
                '}';
    }
    
}

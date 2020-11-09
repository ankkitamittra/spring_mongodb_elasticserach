package com.service.db.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Posts {
	@Id
	private String id;
	private String title;
	
    public Posts() {

	}
    
	public Posts(String title) {
		this.title = title;
	}
	
	public String getId() {
	        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
      return "Posts [id=" + id + ", title=" + title + "]";
    }
}
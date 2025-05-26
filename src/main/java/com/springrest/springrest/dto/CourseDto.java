package com.springrest.springrest.dto;

import java.util.List;

public class CourseDto {
	
	 private Long id;
	    private String title;
	    private String description;
	    private List<String> tutorialLinks;

	    // Getters and Setters
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
	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    public List<String> getTutorialLinks() {
	        return tutorialLinks;
	    }
	    public void setTutorialLinks(List<String> tutorialLinks) {
	        this.tutorialLinks = tutorialLinks;
	    }

}

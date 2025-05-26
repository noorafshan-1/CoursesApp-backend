package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.dto.CourseDto;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	
	 // creating a logger
    org.slf4j.Logger logger= LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
	
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();//it will return list of courses
	}
//
//	@Override
//	public Course getCourse(long courseId) {
//		
//		return courseDao.getReferenceById(courseId);
//	}

	@Override
    public Course getCourse(long courseId) {
        
        logger.info("Entering getCourse with courseId: {}", courseId);

        Course course = null;
        try {
            // Retrieve the course from the DAO
            course = courseDao.getReferenceById(courseId);
            // Log for the successful retrieval of the course
            logger.info("Successfully retrieved course: {}", course);
        } catch (Exception e) {
            // Log for any exceptions that occur during the method execution
            logger.error("Error retrieving course with courseId: {}", courseId, e);
        }

        // Log the method exit
        logger.info("Exiting getCourse with course: {}", course);

        return course;
    }
	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Void deleteCourse(long parseLong) {
		Course entity = courseDao.getReferenceById(parseLong);
		courseDao.delete(entity);
		return null;
	}
	
	

	@Override
	public CourseDto getCourseDto(Long courseId) {
	    Course course = getCourse(courseId); // you already have this logic
	    return mapToDto(course);
	}
	
	private CourseDto mapToDto(Course course) {
	    CourseDto dto = new CourseDto();
	    dto.setId(course.getId());
	    dto.setTitle(course.getTitle());
	    dto.setDescription(course.getDescription());

	    // Add sample tutorial links based on title
	    List<String> links;
	    String title = course.getTitle().toLowerCase();
	  

	    if (title.contains("java")) {
	        links = Arrays.asList(
	            "https://www.geeksforgeeks.org/java/",
	            "https://www.youtube.com/playlist?list=PLsyeobzWxl7oZ9tGTHyCu9bZ1TKx5hA12"
	        );
	    } else if (title.contains("node")) {
	        links = Arrays.asList(
	            "https://nodejs.dev/en/learn/",
	            "https://www.youtube.com/watch?v=fBNz5xF-Kx4"
	        );
	    } else if (title.contains("html")) {
	        links = Arrays.asList(
	            "https://www.w3schools.com/html/"
	        );
	    }else if (title.contains("react")) {
	        links = Arrays.asList(
	            "https://reactjs.org/docs/getting-started.html",
	            "https://www.youtube.com/watch?v=w7ejDZ8SWv8"
	        );
	    }else if (title.contains("python")) {
	    	 links = Arrays.asList(
	    		"https://www.learnpython.org/"	 
	    	);
	    }else if (title.contains("spring boot")) {
	    	 links = Arrays.asList(
	    		"https://www.tutorialspoint.com/spring_boot/index.htm"	 
	    	);
	    } else {
	        links = List.of();
	    }

	    dto.setTutorialLinks(links);
	    return dto;
	}

}

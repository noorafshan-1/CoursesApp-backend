package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.dto.ContactDto;
import com.springrest.springrest.dto.CourseDto;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.CourseServiceImpl;


@CrossOrigin(origins = "http://localhost:3000") 
@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "WelcoAutome to our courses App";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
		
	}
	
	//single course get
	
//	@GetMapping("/courses/{courseId}")
//	public Course getCourse(@PathVariable String courseId) {
//	
//		return this.courseService.getCourse(Long.parseLong(courseId));
//	}
	
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId) {
	    CourseDto dto = courseService.getCourseDto(courseId);
	    return ResponseEntity.ok(dto);
	}

	
	//course add
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	//update course using PUT request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/contact")
	public ResponseEntity<String> handleContact(@RequestBody ContactDto contact) {
	    // Here, we can log, email, or store contact info in DB
	    System.out.println("Contact Message: " + contact.getMessage());
	    return new ResponseEntity<>("Message received", HttpStatus.OK);
	}
	
	

	
	
}

package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
@RequestMapping("/courseapi")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/hi")
	public ResponseEntity healthCheck(@RequestParam (name = "username") String username) {
		String s = "Hello : "+username;
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void addCourse(@RequestBody Course c, @PathVariable String topicId) {
		c.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(c);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Test test(@RequestParam(name = "name") String name,
            @RequestParam(name = "password") String pw) {
		Test test = new Test();
		test.setPassword(pw.replaceAll("a", "*"));
		test.setName(name);
		return test;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test2")
	public Test test2(@RequestBody Test test) {
		test.setPassword(test.getPassword().replaceAll("a", "*"));
		return test;
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course c, @PathVariable String id, @PathVariable String topicId) {
		c.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(id, c);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}

package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService cs;

	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourse() {
		return cs.getAllCourse();
	}

	@RequestMapping("/topics/{id}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return cs.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{id}")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		cs.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		cs.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		cs.deleteCourse(id);
	}
}

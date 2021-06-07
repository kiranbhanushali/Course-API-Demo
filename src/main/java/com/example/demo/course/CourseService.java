package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository cr;

	public List<Course> getAllCourse() {
//		return ls;
		List<Course> ls = new ArrayList<>();
		cr.findAll().forEach(ls::add);
		return ls;
	}

	public Course getCourse(String id) {
//		return ls.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return cr.findById(id).get();
	}

	public void updateCourse(Course course) {
		cr.save(course);
	}

	public void deleteCourse(String id) {
		cr.deleteById(id);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		cr.save(course);
	}
}

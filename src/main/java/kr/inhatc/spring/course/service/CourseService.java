package kr.inhatc.spring.course.service;

import kr.inhatc.spring.course.entity.Course;

public interface CourseService {
	void saveCourse(Course course);
	
	Course getCourse(Long id);
}

package kr.inhatc.spring.course.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;


@Controller
public class CourseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "course/courseRegist", method=RequestMethod.POST)
	public String courseRegist(Course course) {
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecTitle());
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecContent());
		courseService.saveCourse(course);
		return "lecture/test";
	}
	
	@RequestMapping("course/courseRegistForm")
	public String courseRegistForm() {
		//Lecture lecture = new Lecture();
		//Course course;
		
		
		return "lecture/test";
	}
}

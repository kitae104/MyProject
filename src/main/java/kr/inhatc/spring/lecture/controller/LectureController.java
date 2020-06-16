package kr.inhatc.spring.lecture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.service.LectureService;
import kr.inhatc.spring.user.entity.Users;



@Controller
public class LectureController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LectureService lectureService;	
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("lecture")
	public String index() {

		return "lecture/index";
	}
	
	@RequestMapping("lecture/lectureRegistForm")
	public String lectureRegist() {

		return "lecture/lectureRegist";
	}
	
	@RequestMapping(value = "lecture/lectureRegist", method=RequestMethod.POST)
	public String lectureRegist(Lecture lecture) {
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecTitle());
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecContent());
		
		Long id = (long) 7; 
		Course course = courseService.getCourse(id);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+course);
		course.addLecture(lecture);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+course);
		lectureService.saveLecture(lecture);
		return "lecture/lectureRegist";
	}
	
	@RequestMapping(value= "/lecture/lectureShow/{id}",method=RequestMethod.GET)
	public String lectureShow(@PathVariable("id") Long id, Model model) {
		Lecture lecture = lectureService.lectureShow(id);
		model.addAttribute("lecture", lecture);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture);
		return "lecture/lectureShow";
	} 

	@RequestMapping("/lecture/courseRegist")
	public String test() {

		return "lecture/test";
	}
}

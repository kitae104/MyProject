package kr.inhatc.spring.lecture.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.service.LectureService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LectureControllerTest {

	@Autowired
	CourseService courseService;
	
	@Autowired
	LectureService lectureService;
	
	@Test
	void test() {
		Course c = new Course();
		c.setCouOutline("개요");
		c.setCouTitle("강좌 제목");
		courseService.saveCourse(c);
		
		Lecture l = new Lecture();
		l.setLecContent("한국사내용");
		l.setLecTitle("강의 제목");
		l.setCourse(c);							//
		
		c.addLecture(l);		
		
	}

}

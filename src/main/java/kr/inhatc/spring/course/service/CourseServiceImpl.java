package kr.inhatc.spring.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.repository.CourseRepository;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.repository.LectureRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void saveCourse(Course course) {
		courseRepository.save(course);	
	}



	@Override
	public Course getCourse(Long id) {
		
		Optional<Course> optional = courseRepository.findById(id);
		if(optional.isPresent()) {
			Course course = optional.get();
			return course;
		}else
		{
			throw new NullPointerException("******we dont have any course what you want. sorry!!***********");
		}
		
	}
	
}

package kr.inhatc.spring.lecture.service;

import java.util.List;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.user.entity.Users;

public interface LectureService {
	

	void saveLecture(Lecture lecture);
	
	Lecture lectureShow(Long id);
}

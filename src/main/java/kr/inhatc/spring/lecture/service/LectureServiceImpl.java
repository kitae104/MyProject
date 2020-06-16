package kr.inhatc.spring.lecture.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.repository.LectureRepository;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	LectureRepository lectureRepository;
	

	
	@Override
	public void saveLecture(Lecture lecture) {
		lectureRepository.save(lecture);	
	}

	@Override
	public Lecture lectureShow(Long id) {
		System.out.println("lectuers ID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
		Optional<Lecture> optional = lectureRepository.findById(id);
		if(optional.isPresent()) {
			Lecture lecture = optional.get();
			return lecture;
		}else
		{
			throw new NullPointerException("******we dont have any lecture what you want. sorry!!***********");
		}
	}

}

package kr.inhatc.spring.lecture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.lecture.entity.Lecture;

@Repository 
public interface LectureRepository extends CrudRepository<Lecture, Long> {
	Optional<Lecture> findById(Long id);
	
}

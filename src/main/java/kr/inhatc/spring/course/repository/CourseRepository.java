package kr.inhatc.spring.course.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.course.entity.Course;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	Optional<Course> findById(Long id);
}

package kr.inhatc.spring.lecture.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Nationalized;

import kr.inhatc.spring.course.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name="LECTURE_SEQ_GENERATOR",
		sequenceName="LECTURE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name ="lecture")
@NoArgsConstructor
@Data
public class Lecture {
	// 주키 설정 자동 증가 long타입
	@Id
	@Column(name ="lec_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "LECTURE_SEQ_GENERATOR") 
	private Long lecId;
	
	//
	@ManyToOne
	@JoinColumn(name="cou_id")
	private Course course;
	
	private String lecTitle;
	
	@Lob
	@Nationalized
	private String lecContent;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false,columnDefinition = "date default sysdate")
	private Date joinDate;
	
	
}

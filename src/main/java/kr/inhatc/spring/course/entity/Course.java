package kr.inhatc.spring.course.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Nationalized;

import kr.inhatc.spring.lecture.entity.Lecture;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name="COURSE_SEQ_GENERATOR",
		sequenceName="COURSE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)  
@Table(name ="course")
@NoArgsConstructor
@Data
public class Course {
	// primary key
	@Id
	@Column(name ="cou_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "COURSE_SEQ_GENERATOR") 
	private Long couId;
	
	// forign key
	@OneToMany(mappedBy = "course")
//	@JoinTable(name = "LECTURE",
//				joinColumns = @JoinColumn(name="lec_id"),
//				inverseJoinColumns = @JoinColumn(name="cou_id")
//				)
	private List<Lecture> lecture = new ArrayList<Lecture>();
	
	private String couTitle;
	private String couOutline;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false,columnDefinition = "date default sysdate")
	private Date couResgistDate;
	
	public void addLecture(Lecture lecture) {
		System.out.println("==========================================="+this);
		
		getLecture().add(lecture);
		lecture.setCourse(this);
	}
	
}
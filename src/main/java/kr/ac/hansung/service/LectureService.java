package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;
import kr.ac.hansung.model.DivisionGrade;
import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.SemesterLecture;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	
	public List<Lecture> getDetail(String username, String years, String semester) {
		return lectureDAO.getLecture(username, years, semester);
	}
	public List<Lecture> getCurrent(String username) {
		
		return lectureDAO.getLectures(username);
	}
	
	public List<SemesterLecture> getSemseter(String username) {
		return lectureDAO.getSemesterLectures(username);
	}
	
	public List<DivisionGrade> getDivision(String username) {
		return lectureDAO.getDivisionGrades(username);
	}
	
	public void insert(Lecture lecture) {
		lectureDAO.insert(lecture);		
	}
}

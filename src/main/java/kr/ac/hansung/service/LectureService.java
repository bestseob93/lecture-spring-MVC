package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;
import kr.ac.hansung.model.Lecture;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	public List<Lecture> getCurrent() {
		
		return lectureDAO.getLectures();
	}
	public void insert(Lecture lecture) {
		lectureDAO.insert(lecture);		
	}
}

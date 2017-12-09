package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LectureService;

public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/lectures")
	public String showLectures(Model model) {
		List<Lecture> lectures = lectureService.getCurrent();
		model.addAttribute("lectures", lectures);
		
		return "lectures";
	}

}

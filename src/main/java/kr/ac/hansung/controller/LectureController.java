package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/lectures")
	public String showLectures(Model model) {
		List<Lecture> lectures = lectureService.getCurrent();
		model.addAttribute("lectures", lectures);
		
		return "lectures";
	}

	@RequestMapping("/createlecture")
	public String createLecture(Model model) {
		model.addAttribute("lecture", new Lecture());
		
		return "createlecture";
	}

	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Lecture lecture, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createlecture";
		}
		
		lectureService.insert(lecture);
		return "lecturecreated";
	}
}

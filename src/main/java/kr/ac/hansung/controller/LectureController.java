package kr.ac.hansung.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.hansung.model.DivisionGrade;
import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.SemesterLecture;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/lectures")
	public String showLectures(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<Lecture> lectures = lectureService.getCurrent(username);
		model.addAttribute("lectures", lectures);
		
		return "lectures";
	}
	
	@RequestMapping("/semesterlectures")
	public String showSemesterLectures(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<SemesterLecture> lectures = lectureService.getSemseter(username);
		model.addAttribute("lectures", lectures);
		
		System.out.println(lectures);
		return "semesterlectures";
	}
	
	@RequestMapping("/semesterdetail")
	public String showSemesterDetail(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String resultYear = request.getParameter("years");
		String resultSemester = request.getParameter("semester");
		
		List<Lecture> lectures = lectureService.getDetail(username, resultYear, resultSemester);
		model.addAttribute("results", lectures);
		
		return "semesterdetail";
	}
	
	@RequestMapping("/divisiongrade")
	public String showDivisionGrades(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<DivisionGrade> divisions = lectureService.getDivision(username);
		model.addAttribute("divisions", divisions);
		
		return "divisiongrade";
	}

	@RequestMapping("/createlecture")
	public String createLecture(Model model) {
		model.addAttribute("lecture", new Lecture());
		
		return "createlecture";
	}

	@RequestMapping("/docreate")
	public String doCreate(HttpServletRequest request, Model model, @Valid Lecture lecture, BindingResult result) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

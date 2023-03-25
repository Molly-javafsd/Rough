package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Subject;
import com.example.demo.service.SubjectDAO;

@Controller
public class SubjectController {
	@Autowired
	SubjectDAO dao;
	private final String FOLDER_PATH="D:\\img\\";


	@RequestMapping("/")
	public ModelAndView frontPage(HttpServletRequest request,HttpServletResponse repsonse) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping("/insert")
	public ModelAndView addData(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse repsonse) throws IllegalStateException, IOException {
		ModelAndView mv=new ModelAndView();
		Subject s=new Subject();
		s.setId(Integer.parseInt(request.getParameter("subid")));
		s.setName(request.getParameter("subname"));
		s.setStream(request.getParameter("substr"));
		String fileinfo=FOLDER_PATH+file.getOriginalFilename();
		s.setFilePath(fileinfo);
	
		String ss=dao.insert(s);
		if(ss!=null) {
		
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delData(HttpServletRequest request,HttpServletResponse repsonse) {
		ModelAndView mv=new ModelAndView();
		Subject s=new Subject();
		s.setId(Integer.parseInt(request.getParameter("subid")));
		String ss=dao.delete(s);
		if(ss!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/getall")
	public ModelAndView displayAll(HttpServletRequest request,HttpServletResponse repsonse) {
		ModelAndView mv=new ModelAndView();
		List<Subject> list=dao.getAll();
		mv.setViewName("showcontent.jsp");
		mv.addObject("list",list);
		return mv;
	}
	
}

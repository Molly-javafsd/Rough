package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Subject;
import com.example.demo.repo.SubjectRepo;
@Service
public class SubjectDAO {
	@Autowired
	SubjectRepo repo;
	
	

	
	public String insert(Subject s) {
		

		Subject ss=repo.save(s);

		if(ss!=null) {
			return "done inserting";
		}
		else {
			return "Failed to insert";
		}
	}
	
	public String delete(Subject s) {
		repo.delete(s);
		return "deleted";
	}
	
	public List<Subject> getAll(){
		return repo.findAll();
	}
}

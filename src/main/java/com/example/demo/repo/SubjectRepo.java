package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer>{
	public Optional<Subject> findByName(String filename);
}

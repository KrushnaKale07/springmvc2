package com.krushnas.springmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushnas.springmvc2.pojo.StudentPOJO;
import com.krushnas.springmvc2.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(String name, String email, long contact, String addres) {
		StudentPOJO pojo = repository.addStudent(name, email, contact, addres);
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO pojo = repository.searchStudent(id);
		return pojo;
	}

	public List<StudentPOJO> findAllStudents() {
		List<StudentPOJO> students = repository.findALLStudent();
		return students;
	}

	public StudentPOJO removeStudent(int id) {
		StudentPOJO pojo = repository.removeStudent(id);
		return pojo;
	}
	
	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
		StudentPOJO pojo = repository.updateStudent(id, name, email, contact, address);
		return pojo;
	}
}

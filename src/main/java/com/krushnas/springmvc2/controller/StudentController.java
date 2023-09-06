package com.krushnas.springmvc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krushnas.springmvc2.pojo.StudentPOJO;
import com.krushnas.springmvc2.service.StudentService;

//import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Home page Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	// Add page controller
	@GetMapping("/add")
	public String addPage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Add";
		}
		return "Add";
	}

	// Add Student Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {
		StudentPOJO pojo = service.addStudent(name, email, contact, address);

		// Success
		if (pojo != null) {
			map.addAttribute("msg", "Data inserted successfully...!");
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			return "Add";
		}
		// Failure
		map.addAttribute("msg", "Data not inserted...!");
		List<StudentPOJO> students = service.findAllStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
		}
		return "Add";
	}

	// Search page controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}

	// Search student Controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map) {

		StudentPOJO pojo = service.searchStudent(id);
		// Success
		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("msg", "Student data not found..!");
			return "Search";
		}
		// Failure
		map.addAttribute("msg", "Student data not found...!");
		return "Search";
	}

	// Remove page controller
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		// Success
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Removes";
		}
		map.addAttribute("msg", "No data present...!");
		return "Removes";
	}

	// Remove student Controller
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id, ModelMap map) {
		StudentPOJO pojo = service.removeStudent(id);
		List<StudentPOJO> students = service.findAllStudents();

		// Success
		if (pojo != null) {
			map.addAttribute("msg", "Data removed successfully...!");
			map.addAttribute("students", students);
			return "Remove";
		}

		// Failure
		map.addAttribute("msg", "Data does not exists...!");
		map.addAttribute("students", students);
		return "Remove";
	}

	// Update page controller
	@GetMapping("/update")
	public String updatePage() {
		return "Update";
	}

	// Logout page controller
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}
}

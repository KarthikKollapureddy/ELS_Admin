package coms.Admin.controller;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coms.Admin.Service.AdminService;
import coms.Admin.bean.Grades;
import coms.Admin.bean.Subjects;
import coms.Admin.exception.GradeAlreadyExists;
import coms.Admin.exception.GradeNotFound;
import coms.Admin.exception.SubjectAlreadyExists;
import coms.Admin.exception.SubjectNotFound;

@RestController
@RequestMapping("/elearning/api/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired AdminService adminService;
	
	@PostMapping("/addGrades")
	public ResponseEntity<Grades> addGrad(@RequestBody Grades grad) throws GradeAlreadyExists{
		
		return new ResponseEntity<Grades>(adminService.insertGrade(grad),HttpStatus.OK);
		
	}
	
	@GetMapping("/getGrades")
	public ResponseEntity<List<Grades>> getGrade() throws Exception{
		
		return new ResponseEntity<List<Grades>>(adminService.grades(),HttpStatus.OK);
		
	}
	
	@PatchMapping("/editGrad/{gradId}")
	public ResponseEntity<Grades> editGrade(@RequestBody String gradName,@PathVariable Integer gradId) throws GradeNotFound{
		
		return new ResponseEntity<Grades>(adminService.updateGrad(gradName, gradId),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteGrad/{gradId}")
	public ResponseEntity<Map<String, String>> deleteGrade(@PathVariable Integer gradId) throws GradeNotFound{
		adminService.deleteGrade(gradId);
		Map<String, String> message = new HashMap<>();
		message.put("message", "Grade with Id "+gradId+" deleted");
		return new ResponseEntity<Map<String, String>>(message,HttpStatus.OK);
//		return new ResponseEntity<String>("Grade with Id "+gradId+" deleted",HttpStatus.OK);
	
		
		
		
	}
	
	@GetMapping("/getInfo")
	public ResponseEntity<Map<String,Integer>> getInformation(){
		return adminService.fetchInfo();
	}
	
	@PostMapping("/addSubject")
	public ResponseEntity<Subjects> insertSubject(@RequestBody Subjects subject) throws SubjectAlreadyExists{
		return new ResponseEntity<Subjects>(adminService.insertSubjects(subject),HttpStatus.OK);
		
	}
	
	@GetMapping("/getSubjects")
	public ResponseEntity<List<Subjects>> getAllSubjects() throws SubjectNotFound{
		return new ResponseEntity<List<Subjects>>(adminService.subjects(),HttpStatus.OK);
	}
	
	@PatchMapping("/editSub/{subId}")
	public ResponseEntity<Subjects> updateSubjectName(@PathVariable int subId,@RequestBody String subName) throws SubjectNotFound{
		return new ResponseEntity<Subjects>(adminService.updateSubjects(subId, subName),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteSub/{subId}")
	public ResponseEntity<Map<String, String>> deleteSubName(@PathVariable int subId) throws SubjectNotFound{
		adminService.deleteSub(subId);
		Map<String, String> message = new HashMap<>();
		message.put("message", "Subject with Id "+subId+" deleted");
		return new ResponseEntity<Map<String, String>>(message,HttpStatus.OK);
	}
	
	@GetMapping("/getGrade/{id}")
	public ResponseEntity<Grades> getGradeInfo(@PathVariable int id) {
		return new ResponseEntity<Grades>(adminService.getGrade(id),HttpStatus.OK);
	}

	@GetMapping("/getSubject/{id}")
	public ResponseEntity<Subjects> getSubjectInfo(@PathVariable Integer id) {
		return new ResponseEntity<Subjects>(adminService.getSubject(id),HttpStatus.OK);
	}

	

}

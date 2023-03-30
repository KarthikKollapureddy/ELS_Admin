package coms.Admin.Service;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import coms.Admin.bean.Grades;
import coms.Admin.bean.Subjects;
import coms.Admin.exception.GradeAlreadyExists;
import coms.Admin.exception.GradeNotFound;
import coms.Admin.exception.SubjectAlreadyExists;
import coms.Admin.exception.SubjectNotFound;

public interface AdminService {

	Grades insertGrade(Grades grad) throws GradeAlreadyExists;

	List<Grades> grades() throws GradeNotFound;

	Grades updateGrad(String gradName,Integer gradId) throws  GradeNotFound;

	void deleteGrade(Integer gradId) throws GradeNotFound;

	ResponseEntity<Map<String, Integer>> fetchInfo() ;

	Subjects insertSubjects(Subjects subject) throws SubjectAlreadyExists;

	List<Subjects> subjects() throws SubjectNotFound;

	Subjects updateSubjects(int subId, String subName) throws SubjectNotFound;

	void deleteSub(int subId) throws SubjectNotFound;

	Grades getGrade(int id);

	Subjects getSubject(int id);

}

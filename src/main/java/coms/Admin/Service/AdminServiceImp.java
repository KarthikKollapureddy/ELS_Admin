package coms.Admin.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coms.Admin.DAO.GradeDao;
import coms.Admin.DAO.RegisterUserDao;
import coms.Admin.DAO.SubjectDao;
import coms.Admin.bean.Grades;
import coms.Admin.bean.Register;
import coms.Admin.bean.Subjects;
import coms.Admin.exception.GradeAlreadyExists;
import coms.Admin.exception.GradeNotFound;
import coms.Admin.exception.SubjectAlreadyExists;
import coms.Admin.exception.SubjectNotFound;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired SubjectDao subDao;
	@Autowired GradeDao gradDao;
	@Autowired RegisterUserDao registerDao;
	
	@Override
	public Grades insertGrade(Grades grad) throws GradeAlreadyExists {
		// TODO Auto-generated method stub
		Boolean bool=gradDao.existsByGradName(grad.getGradName());
		if(bool == false) {
		   return  gradDao.save(grad);
		}
		else {
			throw new GradeAlreadyExists();
		}
	}
	
	
	
	


	@Override
	public List<Grades> grades() throws GradeNotFound {
		// TODO Auto-generated method stub
		
		
		List<Grades> grades= gradDao.findAll();
		if(grades.size()==0) {
			throw new GradeNotFound();
		}
		return grades;
		
	}
	@Override
	public Grades updateGrad(String gradName,Integer gradId) throws GradeNotFound {
		// TODO Auto-generated method stub
		Optional<Grades> grad=gradDao.findById(gradId);
		if(grad.isEmpty()) {
			throw new GradeNotFound();
		}
		grad.get().setGradName(gradName);
		return gradDao.saveAndFlush(grad.get());
	}
	@Override
	public void deleteGrade(Integer gradId) throws GradeNotFound {
		// TODO Auto-generated method stub
		
		Optional<Grades> grad=gradDao.findById(gradId);
		if(grad.isEmpty()) {
			throw new GradeNotFound();
		}
		gradDao.deleteById(gradId);

		
	}
	@Override
	public ResponseEntity<Map<String, Integer>> fetchInfo()  {
		// TODO Auto-generated method stub
		int s=0,t=0;
		Map<String, Integer> rm= new HashMap<String, Integer>();
		
	List<Register> res =	 registerDao.findAll();
	
	for(Register  r:res) {
		if(r.getRole()==2) {
			t++;
		}
		else if(r.getRole() ==3) {
			s++;
		}
	}
		rm.put("users", s+t);
		rm.put("trainer", t);
		rm.put("students", s);
		System.out.print(rm.get("users"));
		if(s+t == 0) {
			return new ResponseEntity<Map<String,Integer>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Map<String,Integer>>(rm,HttpStatus.OK);

	}
	@Override
	public Subjects insertSubjects(Subjects subject) throws SubjectAlreadyExists {
		Subjects sub=subDao.findBySubName(subject.getSubName());
		if(sub == null) {
		   return subDao.save(subject);
		}
		else {
			throw new SubjectAlreadyExists();
		}

	}
	@Override
	public List<Subjects> subjects() throws SubjectNotFound {
		// TODO Auto-generated method stub
		List<Subjects> subjects= subDao.findAll();
		if(subjects.size()==0) {
			throw new SubjectNotFound();
		}
		return subjects;
	}
	@Override
	public Subjects updateSubjects(int subId, String subName) throws SubjectNotFound {
		// TODO Auto-generated method stub
		Optional<Subjects> subject=subDao.findById(subId);
		if(subject.isEmpty()) {
			throw new SubjectNotFound();
		}
		subject.get().setSubName(subName);
		return subDao.saveAndFlush(subject.get());

	}
	@Override
	public void deleteSub(int subId) throws SubjectNotFound {
		// TODO Auto-generated method stub
		Optional<Subjects> subject=subDao.findById(subId);
		if(subject.isEmpty()) {
			throw new SubjectNotFound();
		}
		subDao.deleteById(subId);

		
	}






	@Override
	public Grades getGrade(int id) {
		// TODO Auto-generated method stub
		return gradDao.findByGradId(id);
	}






	@Override
	public Subjects getSubject(int id) {
		// TODO Auto-generated method stub
		return subDao.findBySubId(id);
	}
	
}

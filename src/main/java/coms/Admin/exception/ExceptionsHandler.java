package coms.Admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler(GradeAlreadyExists.class)
	public ResponseEntity<String> gradeAlredyExists(){
		return new ResponseEntity<String>("Grade alredy exists",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(GradeNotFound.class)
	public ResponseEntity<String> gradeNotFound(){
		return new ResponseEntity<String>("Grade(s) not found.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SubjectAlreadyExists.class)
	public ResponseEntity<String> subjectAlreadyExists(){
		return new ResponseEntity<String>("Subject Alreay Exists",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(SubjectNotFound.class)
	public ResponseEntity<String> subjectNotFound(){
		return new ResponseEntity<String>("Subject Alreay Exists",HttpStatus.CONFLICT);
	}


}

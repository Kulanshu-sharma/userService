package com.voteroid.userService.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.voteroid.userService.dtos.ExceptionFieldsDTO;
import com.voteroid.userService.dtos.Messages;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidToken.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(InvalidToken ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.INVALID_TOKEN);
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(NoUserInformationRecieved.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(NoUserInformationRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_USER_information_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoUserNameRecieved.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(NoUserNameRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_USER_NAME_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoUserPhoneNoRecieved.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(NoUserPhoneNoRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_USER_PHONE_NO_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoUserEmailIdRecieved.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(NoUserEmailIdRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_USER_EMAIL_ID_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoUserPasswordRecieved.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(NoUserPasswordRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_USER_PASSWORD_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNoOrEmailIdAlreadyExist.class)
	public ResponseEntity<Object> handleNoClientNameRecieved(PhoneNoOrEmailIdAlreadyExist ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.PHONE_EMAIL_ALREADY_EXIST);
        return new ResponseEntity<>(body, HttpStatus.ALREADY_REPORTED);
	}
	
	
}

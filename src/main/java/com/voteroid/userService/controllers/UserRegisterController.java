package com.voteroid.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.userService.dtos.Constants;
import com.voteroid.userService.dtos.Reply;
import com.voteroid.userService.entities.UserTbl;
import com.voteroid.userService.exceptions.InvalidToken;
import com.voteroid.userService.exceptions.NoUserEmailIdRecieved;
import com.voteroid.userService.exceptions.NoUserInformationRecieved;
import com.voteroid.userService.exceptions.NoUserNameRecieved;
import com.voteroid.userService.exceptions.NoUserPasswordRecieved;
import com.voteroid.userService.exceptions.NoUserPhoneNoRecieved;
import com.voteroid.userService.exceptions.PhoneNoOrEmailIdAlreadyExist;
import com.voteroid.userService.repositories.UserTblRepository;

@RestController
public class UserRegisterController {
	
	@Autowired
	private UserTblRepository repository;
	
	@PostMapping("/user/registration")
	public Reply userRegistration(@RequestHeader(Constants.TOKEN_DATA) String data,@RequestBody UserTbl userTbl) {
		Reply reply = new Reply(data);
		if(userTbl==null)
			throw new NoUserInformationRecieved();
		if(userTbl.getUserName()==null || userTbl.getUserName().isEmpty())
			throw new NoUserNameRecieved();
		if(userTbl.getPassword()==null||userTbl.getPassword().isEmpty())
			throw new NoUserPasswordRecieved();
		if(userTbl.getUserPhoneNo()==null || userTbl.getUserPhoneNo().isEmpty())
			throw new NoUserPhoneNoRecieved();
		if(userTbl.getUserEmailId()==null || userTbl.getUserEmailId().isEmpty())
			throw new NoUserEmailIdRecieved();
		if(reply.getAttribute(Constants.CLIENT_ID)==null)
			throw new InvalidToken();
		userTbl.setClientId(Integer.parseInt(reply.getAttribute(Constants.CLIENT_ID)+""));
		try {
			UserTbl persistedUserTbl = repository.save(userTbl);
			reply.setData(persistedUserTbl.getUserId());
		}catch(DataIntegrityViolationException ex) {
			throw new PhoneNoOrEmailIdAlreadyExist();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return reply;
	}

}

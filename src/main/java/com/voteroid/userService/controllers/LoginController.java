package com.voteroid.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.userService.dtos.Constants;
import com.voteroid.userService.dtos.Messages;
import com.voteroid.userService.dtos.Reply;
import com.voteroid.userService.entities.UserTbl;
import com.voteroid.userService.exceptions.NoUserEmailIdRecieved;
import com.voteroid.userService.exceptions.NoUserPasswordRecieved;
import com.voteroid.userService.repositories.UserTblRepository;

@RestController
public class LoginController {

	@Autowired
	UserTblRepository repository;
	
	@PostMapping("/user/login")
	public Reply validateUser(@RequestHeader("userData") String data,@RequestBody UserTbl userTbl) {
		Reply reply = new Reply(data);
		if(userTbl.getUserId() == 0)
			throw new NoUserEmailIdRecieved();
		if(userTbl.getPassword()==null||userTbl.getPassword().isEmpty())
			throw new NoUserPasswordRecieved();
		UserTbl userTblResponse = repository.findByUserIdAndPassword(userTbl.getUserId(),userTbl.getPassword());
		if(userTblResponse==null) {	//Invalid Login Id Or Password...
			reply.setAllowed(false);
			reply.setData(Messages.loginErrors.INVALID_USER_ID_PASSWORD);
		}
		else {
			reply.setAllowed(true);
			reply.setAttribute(Constants.USER_ID,userTbl.getUserId());
			reply.setData(userTblResponse);
		}
		return reply;
	}
}

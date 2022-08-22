package com.voteroid.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.userService.dtos.Constants;
import com.voteroid.userService.dtos.LicenseDataDTO;
import com.voteroid.userService.dtos.Reply;
import com.voteroid.userService.dtos.Response;
import com.voteroid.userService.exceptions.InvalidToken;
import com.voteroid.userService.repositories.ClientProxy;
import com.voteroid.userService.repositories.SAGProxy;

@RestController
public class HomeController {
	
	@Autowired
	SAGProxy sagProxy;
	
	@Autowired
	ClientProxy clientProxy;
	
	@GetMapping("/user/home")
	public Reply retriveLimitConfiguration(@RequestHeader(Constants.TOKEN_DATA) String data,@RequestParam String domainName) {
		Reply reply = new Reply(data);
		Response response = new Response();
		int clientId = clientProxy.getClientIdBydomainName(domainName);
		if(clientId==0) {
			response.setSuccessfull(false);
			response.setMessage("Invalid Domain Name !!!");
		}
		else {
			reply.setAttribute(Constants.CLIENT_ID,clientId);
			response.setSuccessfull(true);
			response.setMessage("Valid Domain Name !!!");
		}
		reply.setData(response);
		return reply;
	}
	
	@PostMapping("/user/generateLicenseKey")
	public Reply generateLicenseKeyFromGateway(@RequestHeader(Constants.TOKEN_DATA) String data,@RequestBody LicenseDataDTO licenseDataDTO) {
		Reply reply = new Reply(data);
		reply.setData(sagProxy.generateLicenseKeyFromGateway("hwhps1427k",licenseDataDTO));
		return reply;
	}
	
	@GetMapping("/user/availableApis")
	public Reply availableApisForUser(@RequestHeader(Constants.TOKEN_DATA) String data) {
		Reply reply = new Reply(data);
		if(reply.getAttribute(Constants.CLIENT_ID)==null)
			throw new InvalidToken();
		Response response = sagProxy.fetchAvailableApiListforUsersFromClientId("hwhps1427k",(int) reply.getAttribute(Constants.CLIENT_ID));
		reply.setData(response);
		return reply;
	}
}

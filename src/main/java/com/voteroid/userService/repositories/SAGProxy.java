package com.voteroid.userService.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.voteroid.userService.dtos.Response;

@FeignClient(name="sag")
public interface SAGProxy {

	@GetMapping("/sag/apisListUser/{clientId}")
	public Response fetchAvailableApiListforUsersFromClientId(@RequestHeader("accessKey") String accessKey,@PathVariable(name="clientId") int clientId);
}

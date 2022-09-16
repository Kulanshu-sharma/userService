package com.voteroid.userService.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.voteroid.userService.dtos.LicenseDataDTO;
import com.voteroid.userService.dtos.Response;

@FeignClient(name="sag")
public interface SAGProxy {

	@GetMapping("/sag/apisListUser/{clientId}")
	public Response fetchAvailableApiListforUsersFromClientId(@RequestHeader("accessKey") String accessKey,@PathVariable(name="clientId") int clientId);

	@PostMapping("/sag/generateLicenseKey")
	public Response generateLicenseKeyFromGateway(@RequestHeader("accessKey") String accessKey,@RequestBody LicenseDataDTO licenseDataDTO);
	
	@GetMapping("/sag/fetchTokens/user")
	public Response fetchTokensForUserId(@RequestHeader("accessKey") String accessKey,@RequestParam("userId") int userId);
}

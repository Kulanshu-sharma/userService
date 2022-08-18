package com.voteroid.userService.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientProxy {
	
	@GetMapping("/client/getClientId/{domainName}")
	public int getClientIdBydomainName(@PathVariable("domainName") String domainName);
}

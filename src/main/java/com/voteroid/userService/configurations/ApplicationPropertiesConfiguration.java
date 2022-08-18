package com.voteroid.userService.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("user-service")
public class ApplicationPropertiesConfiguration {

}

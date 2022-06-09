package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentialsSelenoid.properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}

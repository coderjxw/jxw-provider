package com.example.jxw.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@ConfigurationProperties(prefix = "helm")
@Getter
@Setter
@Component
public class Helm {


    private String whiteList;


}

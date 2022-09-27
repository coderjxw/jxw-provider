package com.example.jxw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("config")
@RefreshScope
public class NacosTest {

    @Value(value = "${server.port}")
    private String port;

    @Value(value = "${goods.crisis_stock:0}")
    private Integer useLocalCache;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return useLocalCache +"==="+ port;
    }
}
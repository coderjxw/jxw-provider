package com.example.jxw.controller;

import com.example.jxw.dto.LeadCreateRequest;
import com.example.jxw.entity.Car;
import com.example.jxw.event.SyncEvent;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;


@RestController
@RequestMapping("/jxw")
@AllArgsConstructor
public class JxwController {


    private ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOGGER = LoggerFactory.getLogger(JxwController.class);


    @GetMapping("/jxw1")
    public Integer jxw1() {
        return 1;
    }


    @GetMapping("/cecId")
    public void cecId(@RequestParam(value = "content") String content,
                      @RequestParam(value = "cecId", required = false) Integer cecId) {
        System.out.println(replaceFileNameSpace(content));
    }

    private String replaceFileNameSpace(String fileName) {
        return StringUtils.isEmpty(fileName) ? null : fileName.replaceAll("\\+", " ");
    }

    @PostMapping("/jxw3")
    public void jxw3(@RequestHeader(name = "x-api-key") String apiKey, @RequestBody Car car) {
        LOGGER.info("publisher sync event start，{}", new Date());
        for (int i = 0; i < 100; i++) {
            applicationEventPublisher.publishEvent(new SyncEvent("test_" + i));
        }
        System.out.println("publisher sync event successfully! ");
    }

    @PostMapping("/{third-party-name}/leads")
    public String createLead(@PathVariable("third-party-name") String thirdPartyName, @RequestBody List<LeadCreateRequest> leadCreateRequestList, @RequestParam("type") String type) {
        return "123";
    }
}
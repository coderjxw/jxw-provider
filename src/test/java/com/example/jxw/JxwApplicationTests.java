package com.example.jxw;

import com.example.jxw.entity.Car;
import com.example.jxw.entity.Pepole;
import com.example.jxw.enums.SurveyCode;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@SpringBootTest
class JxwApplicationTests {

    @Test
    void contextLoads() {

        List<Car> picCars = new ArrayList<>(Arrays.asList(
                Car.builder().id(15).name("1").date("1659684252000").build(),
                Car.builder().id(15).name("2").date("1659684252000").build(),
                Car.builder().id(15).name("1").date("1659597852000").build(),
                Car.builder().id(16).name("4").date("1659597852000").build()
        ));
       Map<String,String> aa=new HashMap<>();
       aa.put("c2f912aa-0603-4950-8997-dd11b767de4a","rrrrrr");
        System.out.println(aa.keySet().contains("c2f912aa-0603-4950-8997-dd11b767de4a"));

        List<Car> result = new ArrayList<>();
        picCars.stream().peek(data -> {
            if (data.getId().equals(15)) {
                result.add(data);
            }
        }).collect(Collectors.toList());
        System.out.println( result);
    }
    private String appendComments(String lead){
        if (1 == 1) {
            return lead == null ? "meTouch推送线索" : String.format("meTouch推送线索 %s", lead);
        } else {
            return lead;
        }
    }
    @Test
    public void test2(){
        SurveyCode surveyCode = SurveyCode.SERVICE_ATTITUDE;
        System.out.println(surveyCode.name());
    }



}

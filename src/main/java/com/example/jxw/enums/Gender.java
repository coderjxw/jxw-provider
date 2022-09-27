package com.example.jxw.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Objects;

import static com.google.common.collect.Maps.newHashMap;

public enum Gender {
    MALE("Male"), FEMALE("Female"), UN("");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Gender create(String value) {
        if (StringUtils.isNotEmpty(value)) {
            return Gender.valueOf(value.toUpperCase());
        }
        return Gender.MALE;
    }

    public static Gender parseWSLeadGender(String wsGender) {
        if (Objects.isNull(wsGender)) {
            return MALE;
        }

        HashMap<String, Gender> convertMap = newHashMap();
        convertMap.put("MALE", MALE);
        convertMap.put("M", MALE);
        convertMap.put("男", MALE);
        convertMap.put("先生", MALE);

        convertMap.put("FEMALE", FEMALE);
        convertMap.put("F", FEMALE);
        convertMap.put("女", FEMALE);
        convertMap.put("女士", FEMALE);
        return convertMap.getOrDefault(wsGender.trim().toUpperCase(), MALE);
    }

    public static Gender parseGender(String value) {
        if (StringUtils.isEmpty(value)) {
            return UN;
        }

        HashMap<String, Gender> convertMap = newHashMap();
        convertMap.put("先生", MALE);
        convertMap.put("女士", FEMALE);
        return convertMap.getOrDefault(value, MALE);
    }

    public String getGenderChineseDescription() {
        if (this == MALE) {
            return "先生";
        }
        if (this == FEMALE) {
            return "女士";
        }
        return "";
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return value;
    }
}


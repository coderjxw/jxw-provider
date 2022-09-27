package com.example.jxw.enums;

public enum DmpCustomerTagFilterType {
    ALL("all"), AFTERSALES("aftersales"), SALES("sales");

    private final String value;

    DmpCustomerTagFilterType(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

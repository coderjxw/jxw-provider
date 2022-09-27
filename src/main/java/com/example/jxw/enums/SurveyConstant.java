package com.example.jxw.enums;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

import static com.example.jxw.enums.SurveyCode.*;

public class SurveyConstant {
    protected static final String ANONYMOUS_CUSTOMER_NAME = "*";

    public static final String INVITED_TEST_DRIVE = "有邀请我试驾";
    @SuppressWarnings("unused")
    public static final String UNINVITED_TEST_DRIVE = "未邀请我试驾";

    public static final String SURVEY_REGEX = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\\\w\\s\\u4e00-\\u9fa5]*";

    public static Boolean isAnonymous(String questionName, Double score) {
        return ANONYMOUS_CUSTOMER.name().equals(questionName)
                && score == 1;
    }

    public static Boolean isDealerVehicleTypeNotConfirm(String questionName, Double score) {
        return (DEALER_VEHICLE_TYPE_CONFIRM.name().equals(questionName)
                || CLI_DEALER_VEHICLE_TYPE_CONFIRM.name().equals(questionName))
               && score == 1;
    }

    public static List<String> getOptionsNotShown() {
        List<String> optionsNotShown = Lists.newArrayList("线上预约试乘试驾很方便", "线上预约试乘试驾不方便");
        return Collections.unmodifiableList(optionsNotShown);
    }
}

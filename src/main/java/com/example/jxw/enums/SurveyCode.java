package com.example.jxw.enums;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static com.example.jxw.enums.SurveyConstant.SURVEY_REGEX;

@Slf4j
public enum SurveyCode {
    SERVICE_ATTITUDE("销售人员的礼貌亲切程度", Lists.newArrayList("销售人员的服务态度")),
    OVERALL_EXPERIENCE("您在奔驰经销店的体验如何"),
    TEST_DRIVE("您在奔驰经销店的试驾体验如何"),
    TEST_DRIVE_ORDER("您对通过梅赛德斯-奔驰官方线上渠道进行试乘试驾预约体验如何？"),
    NOT_TEST_DRIVE("您没有试乘试驾是因为："),
    PRODUCT_RECOMMENDATION("销售人员给您推荐产品的过程"),
    HANDOVER_EXPERIENCE("您对今天整个交车过程的体验满意吗？"),
    NEW_CAT_SATISFACTION("您对新车外观内饰的清洁和完好情况满意吗？"),
    HANDOVER_INTRODUCTION("您对今天交车过程中的功能介绍满意吗？"),
    HANDOVER_SERVICE_ATTITUDE("在今天交车过程中，工作人员给您兑现承诺（各项实物或服务）的表现，您满意吗？"),
    HANDOVER_WAITING_TIME_SATISFACTION("您对今天在经销店的交车时长满意吗？"),
    HANDOVER_WAITING_TIME("在今天手续办理和车辆交付过程中您独自等待的时长是："),
    HANDOVER_SUGGESTION("您还有其他什么建议？"),

    //cli survey questions
    CLI_DEALER_VEHICLE_TYPE_CONFIRM(SURVEY_REGEX + "您是在" + SURVEY_REGEX + "购买的" + SURVEY_REGEX + "吗？" + SURVEY_REGEX),
    CHOOSE_DEALER("1. 今后您会愿意继续接受这家经销商的服务吗？"),
    CHOOSE_DEALER_A("1.a 您觉得经销商哪些方面做得比较好，让您愿意继续选择呢？"),
    CHOOSE_DEALER_B("1.b 当时发生了什么事，让您不愿意继续选择呢？"),
    RECOMMEND_DEALER("2. 考虑到目前为止您的拥车经历, 请您用以下的评分标准, 您是否会将您的汽车/或汽车经销商推荐给您的朋友, 家人或是公司同事？"),
    RECOMMEND_DEALER_A("2.a 您觉得经销商哪些方面做得比较好，让您愿意推荐呢？"),
    RECOMMEND_DEALER_B("2.b 当时发生了什么事，让您不愿意推荐呢？"),


    //csi invoice survey questions
    DEALER_VEHICLE_TYPE_CONFIRM("尊敬的" + SURVEY_REGEX + "先生/女士，请根据您在经销商的实际购车体验给出评价。我们非常重视您的反馈，感谢您的支持！" + SURVEY_REGEX +
            "您是在" + SURVEY_REGEX + "购买的" + SURVEY_REGEX + "吗？"),
    CSI_INVOICE_OVERALL_EXPERIENCE("1. 请您对新车的经销商服务的总体满意度打分"),
    CSI_INVOICE_OVERALL_EXPERIENCE_A("1.a 您觉得经销商哪些方面做得比较好，让您比较满意？"),
    CSI_INVOICE_OVERALL_EXPERIENCE_B("1.b 当时发生了什么事，让您不太满意呢？"),
    SHOWROOM_RECEPTION("2. 请您对经销商的展厅欢迎进行评价："),
    SHOWROOM_ENVIRONMENT("3. 请您对经销商展示厅的整体环境进行评价：（例如：展厅氛围、产品展示、等候区、整洁度等）"),
    SC_POLITENESS("4.1 销售人员礼貌亲切程度"),
    SC_PROFESSIONAL_COMPETENCE("4.2 销售人员的专业能力与知识"),
    SC_COMMITMENT_FULFILLMENT("4.3 承诺兑现（包括各项实物或服务）"),
    TEST_DRIVE_EXPERIENCE("5.2 请您对试乘试驾体验进行评价：（例如：试驾邀约、试驾车型及车款、试驾时长等）"),
    VEHICLE_CONDITION("6.1 交车时车的状况"),
    VEHICLE_FUNCTION_EXPLANATION("6.2 经销商向您完整解释车的功能配置及使用方法（例如：易于理解、满足您的需求等）"),
    VEHICLE_DELIVERY_EXPERIENCE("6.3 经销商交车的过程"),
    RETURN_VISIT_EXPERIENCE("8. 请您对经销商交车后的跟进服务进行评价（例如：经销商解决问题的能力等）"),
    DEALER_RECOMMENDATION("9. 考虑到目前为止您的拥车经历, 请您用以下的评分标准, 您是否会将您的经销商推荐给您的朋友, 家人或是公司同事？"),

    ANONYMOUS_CUSTOMER("感谢您的评价，为了帮助经销商提升服务，您愿意将您的信息及反馈的意见提供给经销商吗？");

    private String description;
    private List<String> historyDescriptions;

    SurveyCode(String description) {
        this.description = description;
        historyDescriptions = new ArrayList<>();
    }

    SurveyCode(String description, List<String> historyDescriptions) {
        this.description = description;
        this.historyDescriptions = historyDescriptions;
    }

    public String getDescription() {
        return description;
    }

    public boolean descriptionEquals(String description) {
        return this.historyDescriptions.contains(description) || this.description.equals(description);
    }

    public boolean descriptionPatternEquals(String description) {
        for (String historyDescription : this.historyDescriptions) {
            if (Pattern.compile(historyDescription).matcher(description).matches()) {
                return true;
            }
        }
        return Pattern.compile(this.description).matcher(description).matches();
    }

    public static String mapToCode(String name) {
        for (SurveyCode surveyCode : values()) {
            if(surveyCode.descriptionEquals(name) || surveyCode.descriptionPatternEquals(name)) {
                return surveyCode.name();
            }
        }
        return name;
    }

    public static List<SurveyCode> getCsiInvoiceCodeShown() {
        List<SurveyCode> csiInvoiceCodeShown = Lists.newArrayList(
                CSI_INVOICE_OVERALL_EXPERIENCE,
                CSI_INVOICE_OVERALL_EXPERIENCE_A,
                CSI_INVOICE_OVERALL_EXPERIENCE_B,
                SHOWROOM_RECEPTION,
                SHOWROOM_ENVIRONMENT,
                SC_POLITENESS,
                SC_PROFESSIONAL_COMPETENCE,
                SC_COMMITMENT_FULFILLMENT,
                TEST_DRIVE_EXPERIENCE,
                VEHICLE_CONDITION,
                VEHICLE_FUNCTION_EXPLANATION,
                VEHICLE_DELIVERY_EXPERIENCE,
                RETURN_VISIT_EXPERIENCE,
                DEALER_RECOMMENDATION,
                ANONYMOUS_CUSTOMER
        );
        return Collections.unmodifiableList(csiInvoiceCodeShown);
    }
}

package com.example.jxw.enums;

import java.util.Arrays;
import java.util.function.Function;

public enum SurveyQuestionType {

    SINGLE_CHOICE_QUESTION(0, "单选题", x -> x, intValue -> {
        if (intValue == 0) {
            return "是";
        } else {
            return "否";
        }
    }),

    MULTIPLE_CHOICE_QUESTION(1, "多选题"),
    QUESTION_ANSWER_QUESTION(2, "问答题"),
    MULTIPLE_LINE_QUESTION(3, "多行问答题"),
    FIVE_POINTED_STAR_SCORING_QUESTION(4, "评分题-五角星", x -> x + 1),
    HEART_SHAPE_SCORING_QUESTION(5, "评分题-心形"),
    OPTION_QUESTION(6, "选项题"),
    MATRIX_SCORING_QUESTION(7, "评分矩阵"),
    POINT_SCORING_QUESTION(8, "评分题-指针"),
    FIVE_STAR_SCORING_QUESTION(9, "评分题-五星十分", x -> x + 1),
    GROUP_TITLE(-1, "分组标题");


    public final int questionType;
    public final String questionName;
    public final Function<Integer, Integer> scoreMappingFunction;
    public final Function<Integer, String> contentMappingFunction;

    SurveyQuestionType(int questionType, String questionName) {
        this.questionType = questionType;
        this.questionName = questionName;
        this.scoreMappingFunction = x -> x;
        this.contentMappingFunction = String::valueOf;
    }

    SurveyQuestionType(int questionType, String questionName, Function<Integer, Integer> scoreMappingFunction) {
        this.questionType = questionType;
        this.questionName = questionName;
        this.scoreMappingFunction = scoreMappingFunction;
        this.contentMappingFunction = String::valueOf;

    }

    SurveyQuestionType(int questionType, String questionName, Function<Integer, Integer> scoreMappingFunction, Function<Integer, String> contentMappingFunction) {
        this.questionType = questionType;
        this.questionName = questionName;
        this.scoreMappingFunction = scoreMappingFunction;
        this.contentMappingFunction = contentMappingFunction;
    }




}

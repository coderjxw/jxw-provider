package com.example.jxw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadCreateRequest {

    private String thirdPartyId;
    private String gsCode;
    private String dealerLocation;
    private String dealerName;
    private String firstName;
    private String lastName;
    private String gender;
    private String mobile;
    private String interestVariantEn;
    private String interestVariantCn;
    private String interestClassEn;
    private String interestClassCn;
    private String interestBrandEn;
    private String interestBrandCn;
    private String queryType;
    private String scName;
    private String scMobile;
    private String comment;
    private String outletCode;
    private String baumusterNst;
    private String scId;
    private String paintCode;
    private String rimCode;
    private String upholsteryCode;
    private String trimCode;
    private String packages;
    private String others;

    public boolean isValid() {
        return StringUtils.hasText(thirdPartyId) &&
                StringUtils.hasText(gsCode) &&
                StringUtils.hasText(lastName) &&
                StringUtils.hasText(gender) &&
                StringUtils.hasText(mobile) &&
                isValidMobile(mobile);
    }

    public static boolean isValidMobile(String mobile) {
        return mobile.matches("^1\\d{10}\\**$");
    }

    public boolean isNotValid() {
        return !isValid();
    }

    public ThirdPartyLeadDTO convertToThirdPartyLeadDTO(String leadType) {
        String firstNameOptional = Optional.ofNullable(firstName).orElse("");
        return ThirdPartyLeadDTO.builder()
                .thirdPartyId(thirdPartyId)
                .gsCode(gsCode)
                .dealerLocation(dealerLocation)
                .dealerName(dealerName)
                .firstName(firstNameOptional)
                .lastName(lastName)
                .name(lastName + firstNameOptional)
                .gender(gender)
                .mobile(mobile)
                .interestVariantEn(interestVariantEn)
                .interestVariantCn(interestVariantCn)
                .interestClassEn(interestClassEn)
                .interestClassCn(interestClassCn)
                .interestBrandEn(interestBrandEn)
                .interestBrandCn(interestBrandCn)
                .queryType(queryType)
                .leadType(leadType)
                .scName(scName)
                .scMobile(scMobile)
                .comment(comment)
                .outletCode(outletCode)
                .baumusterNst(baumusterNst)
                .scId(scId)
                .paintCode(paintCode)
                .upholsteryCode(upholsteryCode)
                .trimCode(trimCode)
                .rimCode(rimCode)
                .packages(packages)
                .others(others)
                .build();
    }
}

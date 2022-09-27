package com.example.jxw.dto;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThirdPartyLeadDTO {

    private String thirdPartyId;
    private String gsCode;
    private String dealerLocation;
    private String dealerName;
    private String firstName;
    private String lastName;
    private String name;
    private String gender;
    private String mobile;
    private String interestVariantEn;
    private String interestVariantCn;
    private String interestClassEn;
    private String interestClassCn;
    private String interestBrandEn;
    private String interestBrandCn;
    private String queryType;
    private String leadType;
    private String scName;
    private String scMobile;
    private String comment;

    private String dealerId;
    private String outletCode;
    private String baumusterNst;
    private String scId;
    private String paintCode;
    private String rimCode;
    private String upholsteryCode;
    private String trimCode;
    private String packages;
    private String others;

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ThirdPartyLeadDTO) {
            ThirdPartyLeadDTO dto = (ThirdPartyLeadDTO) obj;
            return StringUtils.equals(getPrimaryKey(), dto.getPrimaryKey());
        }
        return false;
    }

    public String getPrimaryKey() {
        return name + mobile + gsCode;

    }
}

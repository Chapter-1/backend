package com.chapter1.blueprint.member.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputProfileDTO {
    private Double income;
    private String occupation;
    private String region;
    private String district;
    private String local;
    private Integer maritalStatus;
    private Integer hasChildren;
    private String housingType;
}

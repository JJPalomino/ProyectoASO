package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BProductOut {
    private String bid;
    private BSubproductOut bSubproductOut;
}

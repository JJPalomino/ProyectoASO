package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BDetailsOut {
    private String bofferType;
    private BLimitAmountOut bLimitAmountOut;
    private BLimitAmountOut bmaximumAmount;
    private BLimitAmountOut bminimumAmount;
    private BProductOut bproductOut;
}

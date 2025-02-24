package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailsOut {
    private String offerType;
    private LimitAmountOut limitAmountOut;
    private LimitAmountOut maximumAmount;
    private LimitAmountOut minimumAmount;
    private ProductOut productOut;
}

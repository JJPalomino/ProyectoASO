package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Details {
    @Pattern(regexp = "^[A-Z]+$", message = "El nombre debe estar en mayúsculas")
    private String offerType;
    @Valid
    private LimitAmount limitAmount;
    @Valid
    private Product product;
}

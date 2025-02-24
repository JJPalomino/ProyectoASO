package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Product {
    @Pattern(regexp = "^TDC$", message = "El identificador del producto debe ser 'TDC'")
    private String id;
    @Valid
    private Subproduct subproduct;
}

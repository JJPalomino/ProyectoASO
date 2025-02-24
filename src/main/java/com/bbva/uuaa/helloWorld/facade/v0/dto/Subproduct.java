package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class Subproduct {
    @Size(min = 0, max = 2, message = "El identificador del subproducto debe tener entre 0 y 2 caracteres")
    private String id;
}

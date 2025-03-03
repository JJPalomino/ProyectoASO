package com.bbva.uuaa.helloWorld.business.v0;

import com.bbva.uuaa.helloWorld.business.v0.dto.BDataIn;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDataOut;

public interface IBSrvHelloWorld {
    BDataOut mapBusiness (BDataIn bDataIn);
}

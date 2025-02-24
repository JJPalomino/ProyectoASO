package com.bbva.uuaa.helloWorld.facade.v0;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreated;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DataIn;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DataOut;

public interface ISrvHelloWorld {
	ServiceResponseCreated<DataOut> helloWorldPost(DataIn dataIn, String nuip);
}

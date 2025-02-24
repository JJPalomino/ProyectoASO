package com.bbva.uuaa.helloWorld.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreated;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.uuaa.helloWorld.business.v0.IBSrvHelloWorld;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDataIn;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDataOut;
import com.bbva.uuaa.helloWorld.facade.v0.ISrvHelloWorld;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DataIn;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DataOut;
import com.bbva.uuaa.helloWorld.facade.v0.mapper.IMapperSrvHelloWorld;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@SN (registryID = "SNGG20240069", logicalID = "helloWorld")
@VN (vnn = "v0")
@Path ("/v0")
public class SrvHelloWorld implements ISrvHelloWorld {

	@Autowired
	IBSrvHelloWorld business;

	@Override
	@POST
	@Path ("/simulations/{nuip}")
	@Consumes ({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	@SMC (registryID = "SMCGG20240070", logicalID = "prueba")
	public ServiceResponseCreated<DataOut> helloWorldPost(@Valid DataIn dataIn, @PathParam("nuip") String nuip){
		IMapperSrvHelloWorld mapper = Mappers.getMapper(IMapperSrvHelloWorld.class);
		dataIn.setNuip(nuip);
		BDataIn bDataIn = mapper.mapDataIn(dataIn);
		BDataOut bDataOut = business.mapBusiness(bDataIn);
		DataOut dataOut = mapper.mapDataOut(bDataOut);


		return ServiceResponseCreated.data(dataOut).build();
	}
}

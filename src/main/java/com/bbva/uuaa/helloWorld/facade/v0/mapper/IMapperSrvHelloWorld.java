package com.bbva.uuaa.helloWorld.facade.v0.mapper;

import com.bbva.uuaa.helloWorld.business.v0.dto.*;
import com.bbva.uuaa.helloWorld.facade.v0.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IMapperSrvHelloWorld {
    @Mapping(target = "nuip", source = "nuip")
    @Mapping(target = "bdetails", source = "details")
    BDataIn mapDataIn (DataIn dataIn);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nuip", source = "nuip")
    @Mapping(target = "detailsOut", source = "bdetailsOut")
    DataOut mapDataOut(BDataOut bDataOut);

    @Mapping(target = "bofferType", source = "offerType")
    @Mapping(target = "BLimitAmount", source = "limitAmount")
    @Mapping(target = "BProduct", source = "product")
    BDetails mapDetailsIn(Details details);
    @Mapping(target = "offerType", source = "bofferType")
    @Mapping(target = "limitAmountOut", source = "BLimitAmountOut")
    @Mapping(target = "maximumAmount", source = "bmaximumAmount")
    @Mapping(target = "minimumAmount", source = "bminimumAmount")
    @Mapping(target = "productOut", source = "bproductOut")
    DetailsOut mapDetalisOut(BDetailsOut bdetailsOut);

    @Mapping(target = "bamount", source = "amount")
    @Mapping(target = "bcurrency", source = "currency")
    BLimitAmount mapLimitAmountIn(LimitAmount limitAmount);

    @Mapping(target = "amount", source = "bamount")
    @Mapping(target = "currency", source = "bcurrency")
    LimitAmountOut mapLimitAmountOut(BLimitAmountOut bLimitAmountOut);

    @Mapping(target = "bid", source = "id")
    @Mapping(target = "bsubproduct", source = "subproduct")
    BProduct mapProductIn(Product product);

    @Mapping(target = "id", source = "bid")
    @Mapping(target = "subproductOut", source = "BSubproductOut")
    ProductOut mapProdcutOut(BProductOut bproductOut);

    @Mapping(target = "bid", source = "id")
    BSubproduct mapSubproductIn(Subproduct subproduct);

    @Mapping(target = "id", source = "bid")
    SubproductOut mapSubproductOut(BSubproductOut bSubproductOut);
}

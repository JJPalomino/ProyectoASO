package com.bbva.uuaa.helloWorld.business.v0.impl;

import com.bbva.uuaa.helloWorld.business.v0.IBSrvHelloWorld;
import com.bbva.uuaa.helloWorld.business.v0.dto.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Random;

@Service
public class BSrvHelloWorld implements IBSrvHelloWorld {
    @Override
    public BDataOut mapBusiness(BDataIn bDataIn) {
        BDataOut bDataOut = new BDataOut();
        BDetailsOut bDetailsOut = new BDetailsOut();
        BLimitAmountOut bLimitAmountOut = new BLimitAmountOut();
        BLimitAmountOut minimumAmount = new BLimitAmountOut();
        BLimitAmountOut maximumAmount = new BLimitAmountOut();
        BProductOut bProductOut = new BProductOut();
        BSubproductOut bSubproductOut = new BSubproductOut();
        Random random = new Random();

        long generatedId = 1_000_000_000L + (long) (random.nextDouble() * (1_000_000_000L));
        String assignedUniqueId = Long.toString(generatedId);
        bDataOut.setId(assignedUniqueId);

        bDataOut.setNuip(bDataIn.getNuip());

        bDetailsOut.setBofferType(bDataIn.getBdetails().getBofferType());

        bLimitAmountOut.setBamount(bDataIn.getBdetails().getBLimitAmount().getBamount());
        bLimitAmountOut.setBcurrency(bDataIn.getBdetails().getBLimitAmount().getBcurrency());
        bDetailsOut.setBLimitAmountOut(bLimitAmountOut);

        Number inputAmount = bDataIn.getBdetails().getBLimitAmount().getBamount();
        BigDecimal amount = new BigDecimal(inputAmount.toString());


        BigDecimal tenOff = amount.multiply(BigDecimal.valueOf(0.90));
        minimumAmount.setBamount(tenOff);
        minimumAmount.setBcurrency(bDataIn.getBdetails().getBLimitAmount().getBcurrency());


        BigDecimal increaseByFivePercent = amount.multiply(BigDecimal.valueOf(1.05));
        maximumAmount.setBamount(increaseByFivePercent);
        maximumAmount.setBcurrency(bDataIn.getBdetails().getBLimitAmount().getBcurrency());

        bDetailsOut.setBminimumAmount(minimumAmount);
        bDetailsOut.setBmaximumAmount(maximumAmount);

        bProductOut.setBid(bDataIn.getBdetails().getBProduct().getBid());

        bSubproductOut.setBid(bDataIn.getBdetails().getBProduct().getBsubproduct().getBid());

        bProductOut.setBSubproductOut(bSubproductOut);
        bDetailsOut.setBproductOut(bProductOut);

        bDataOut.setBdetailsOut(bDetailsOut);
        return bDataOut;
    }
}

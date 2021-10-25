package com.portal.trading.validation;

import com.portal.trading.Model.TradingRequest;
import org.springframework.stereotype.Service;

@Service
public class RequestBodyValidation {

    // I could also have used libraries(would have required adding dependencies in pom.xml for validation but preferred writing a separate class for the same
    public boolean validateTradingRequest (TradingRequest tradingRequest) {
        if(tradingRequest.getPrice() <=0 || tradingRequest.getQuantity()<=0 || tradingRequest.getStockId()==null || tradingRequest.getDirection()==null)
            return false;
        return true;

    }

}

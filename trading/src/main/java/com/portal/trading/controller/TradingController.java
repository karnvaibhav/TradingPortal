package com.portal.trading.controller;

import com.portal.trading.Model.ExecutedTrade;
import com.portal.trading.Model.StockId;
import com.portal.trading.Model.TradingRequest;
import com.portal.trading.validation.RequestBodyValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RestController
public class TradingController {

    @Autowired
    public RequestBodyValidation requestBodyValidation;

  // A queue to maintain the incoming Trade Orders ideally should have used Db layer but avoiding that for now and thus maintaining queue
   public static Queue<TradingRequest> OrderQueue = new LinkedList<>();

   // A Map to keep track of List of Execute Trades with key value where key being the stockId
   public static HashMap<String, List<ExecutedTrade>> executedTradeHashMap = new HashMap<>();


    /**
     * Post Method for Trading
     * @param tradingRequest
     * @return
     */
    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<String> submitTradeOrder(@RequestBody TradingRequest tradingRequest) {

        if (requestBodyValidation.validateTradingRequest(tradingRequest)){

            //Adding current time to incoming orders i.e the time trade order is received

            tradingRequest.setLocalDateTime(LocalDateTime.now());

            //Logic to be written for Trade Execution from the queue declared above check if there are any orders opposite to current request received currently returning dummy hard coded value
            return ResponseEntity.status(HttpStatus.OK).body("Trading Order Placed Succesfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Verify Your Trading Request There Might Be some Missing fields");
    }


    /**
     * Method to get All Executed Trades by StockId
     * @param stockId
     * @return
     */
    @GetMapping("/trades")
    @ResponseBody
    public List<ExecutedTrade> getExecutedTrades(@RequestParam StockId stockId){
        //Currently it will return null as Logic for submitTradeOrder is not written
        return executedTradeHashMap.get(stockId.toString());
    }
}

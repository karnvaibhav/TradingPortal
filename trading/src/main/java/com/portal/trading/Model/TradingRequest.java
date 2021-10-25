package com.portal.trading.Model;


import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

/**
 * Request object for incoming Trading Request
 */
public class TradingRequest {


    private double price;

    private int quantity;

    private LocalDateTime localDateTime;

    private Direction direction;

    private StockId stockId;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public StockId getStockId() {
        return stockId;
    }

    public void setStockId(StockId stockId) {
        this.stockId = stockId;
    }






}

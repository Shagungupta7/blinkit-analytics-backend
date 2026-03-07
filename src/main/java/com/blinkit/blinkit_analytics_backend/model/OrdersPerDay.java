package com.blinkit.blinkit_analytics_backend.model;

public class OrdersPerDay {
    private final String date;
    private final int totalOrder;

    public OrdersPerDay(String date, int totalOrder){
        this.date = date;
        this.totalOrder = totalOrder;
    }

    public String getDate(){ return date; }
    public int getTotalOrder() { return totalOrder; }
}

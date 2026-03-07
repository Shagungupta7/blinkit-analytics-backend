package com.blinkit.blinkit_analytics_backend.model;

public class OrdersPerCity {
    private final String city;
    private final long totalOrders;

    public OrdersPerCity(String city, long totalOrders){
        this.city = city;
        this.totalOrders = totalOrders;
    }

    public String getCity(){
        return city;
    }
    public long getTotalOrders(){
        return totalOrders;
    }

}

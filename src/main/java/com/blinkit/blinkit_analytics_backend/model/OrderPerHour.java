package com.blinkit.blinkit_analytics_backend.model;

public class OrderPerHour {
    private final long totalOrders;
    private final int hour;

    public OrderPerHour(long totalOrders, int hour){
        this.totalOrders = totalOrders;
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public long getTotalOrders() {
        return totalOrders;
    }
}

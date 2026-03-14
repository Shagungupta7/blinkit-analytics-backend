package com.blinkit.blinkit_analytics_backend.model;

public class OrdersPerPaymentMethod {
    private final String method;
    private final long totalOrders;

    public OrdersPerPaymentMethod(String method, long totalOrders){
        this.method = method;
        this.totalOrders = totalOrders;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public String getMethod() {
        return method;
    }
}

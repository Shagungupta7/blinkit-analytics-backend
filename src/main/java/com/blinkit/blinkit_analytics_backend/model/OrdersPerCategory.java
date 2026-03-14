package com.blinkit.blinkit_analytics_backend.model;

public class OrdersPerCategory {
    private final String category;
    private final long totalOrders;

    public OrdersPerCategory(String category, long totalOrders){
        this.category = category;
        this.totalOrders = totalOrders;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public String getCategory() {
        return category;
    }
}

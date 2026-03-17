package com.blinkit.blinkit_analytics_backend.model;

public class ZoneWiseDistribution {
    private final String zone;
    private final long totalOrders;

    public ZoneWiseDistribution(String zone, long totalOrders){
        this.zone = zone;
        this.totalOrders = totalOrders;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public String getZone() {
        return zone;
    }

}

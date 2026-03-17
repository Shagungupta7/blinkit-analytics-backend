package com.blinkit.blinkit_analytics_backend.model;

public class ZoneWiseDistribution {
    private final String city;
    private final String zone;
    private final long totalOrders;

    public ZoneWiseDistribution(String city, String zone, long totalOrders){
        this.zone = zone;
        this.totalOrders = totalOrders;
        this.city = city;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public String getZone() {
        return zone;
    }

    public String getCity() {
        return city;
    }
}

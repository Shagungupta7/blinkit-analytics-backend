package com.blinkit.blinkit_analytics_backend.model;

public class RevenuePerCity {
    private final String city;
    private final double revenue;

    public RevenuePerCity(String city, double revenue){
        this.city = city;
        this.revenue = revenue;
    }

    public String getCity() { return city; }
    public double getRevenue() { return revenue; }
}

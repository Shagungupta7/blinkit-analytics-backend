package com.blinkit.blinkit_analytics_backend.model;

public class AvgDeliveryTimePerCity {
    private final String city;
    private final Double avgDeliveryTime;

    public AvgDeliveryTimePerCity(String city, Double avgDeliveryTime){
        this.avgDeliveryTime = avgDeliveryTime;
        this.city = city;
    }

    public String getCity() { return city; }
    public Double getAvgDeliveryTime() { return avgDeliveryTime; }
}

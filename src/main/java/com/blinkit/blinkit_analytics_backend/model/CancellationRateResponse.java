package com.blinkit.blinkit_analytics_backend.model;

public class CancellationRateResponse {

    private String city;
    private double cancellationRate;

    public CancellationRateResponse(String city, double cancellationRate) {
        this.city = city;
        this.cancellationRate = cancellationRate;
    }

    public String getCity() {
        return city;
    }

    public double getCancellationRate() {
        return cancellationRate;
    }
}

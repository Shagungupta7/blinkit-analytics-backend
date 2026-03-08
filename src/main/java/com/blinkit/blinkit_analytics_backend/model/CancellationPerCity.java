package com.blinkit.blinkit_analytics_backend.model;

public class CancellationPerCity {
    private final String city;
    private final long cancelled_orders;
    private final long total_orders;
    private final double rate;

    public CancellationPerCity(String city, long cancelled_orders, long total_orders, double rate){
        this.city = city;
        this.rate = rate;
        this.cancelled_orders = cancelled_orders;
        this.total_orders = total_orders;
    }

    public String getCity() {
        return city;
    }

    public double getRate() {
        return rate;
    }

    public long getCancelled_orders() {
        return cancelled_orders;
    }

    public long getTotal_orders() {
        return total_orders;
    }
}

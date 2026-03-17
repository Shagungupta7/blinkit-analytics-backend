package com.blinkit.blinkit_analytics_backend.model;

public class RiderPerCity {
    private final String city;
    private final long count;

    public RiderPerCity(String city, long count){
        this.city = city;
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public long getCount() {
        return count;
    }
}

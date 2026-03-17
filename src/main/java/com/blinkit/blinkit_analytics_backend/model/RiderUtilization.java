package com.blinkit.blinkit_analytics_backend.model;

public class RiderUtilization {
    private final String city;
    private final long total_deliveries;
    private final long total_riders;
    private final long avg_deliveries_per_rider;

    public RiderUtilization(String city, long total_deliveries, long total_riders, long avg_deliveries_per_rider){
        this.city = city;
        this.avg_deliveries_per_rider = avg_deliveries_per_rider;
        this.total_riders = total_riders;
        this.total_deliveries = total_deliveries;
    }

    public String getCity() {
        return city;
    }

    public long getAvg_deliveries_per_rider() {
        return avg_deliveries_per_rider;
    }

    public long getTotal_deliveries() {
        return total_deliveries;
    }

    public long getTotal_riders() {
        return total_riders;
    }
}


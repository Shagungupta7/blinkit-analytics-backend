package com.blinkit.blinkit_analytics_backend.model;

import java.time.LocalTime;

public class DeliveryTImeByHour {
    private final int hour;
    private final double minutes;

    public DeliveryTImeByHour(int hour, double minutes){
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public double getMinutes() {
        return minutes;
    }
}

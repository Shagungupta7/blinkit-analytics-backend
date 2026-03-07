package com.blinkit.blinkit_analytics_backend.model;

public class Top5Riders {
    private final String name;
    private final double time;

    public Top5Riders(String name, double time){
        this.name = name;
        this.time = time;
    }

    public String getName() { return name; }
    public double getTime() { return time; }
}

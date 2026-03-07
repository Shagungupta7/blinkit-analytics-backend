package com.blinkit.blinkit_analytics_backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrdersPerDay {
    private final LocalDate date;
    private final long totalOrder;

    public OrdersPerDay(LocalDate date, long totalOrder){
        this.date = date;
        this.totalOrder = totalOrder;
    }

    public LocalDate getDate(){ return date; }
    public long getTotalOrder() { return totalOrder; }
}

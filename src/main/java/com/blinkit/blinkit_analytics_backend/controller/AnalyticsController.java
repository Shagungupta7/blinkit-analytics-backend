package com.blinkit.blinkit_analytics_backend.controller;

import com.blinkit.blinkit_analytics_backend.model.*;
import com.blinkit.blinkit_analytics_backend.service.AnalyticsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/cancellation-rate")
    public List<CancellationRateResponse> getCancellationRate() {
        return analyticsService.getCancellationRate();
    }

    @GetMapping("/total-orders")
    public long getTotalOrders() {
        return analyticsService.getTotalOrders();
    }

    @GetMapping("/orders-per-city")
    public List<OrdersPerCity> getOrdersPerCity(){
        return analyticsService.getOrderPerCity();
    }

    @GetMapping("/avg-time-per-city")
    public List<AvgDeliveryTimePerCity> getAvgTimePerCity(){
        return analyticsService.getAvgDeliveryTimePerCity();
    }

    @GetMapping("/top-5-riders")
    public List<Top5Riders> getTopRiders(){
        return analyticsService.getTopRiders();
    }

    @GetMapping("/orders-per-day")
    public List<OrdersPerDay> getOrderPerDay(){
        return analyticsService.getOrdersPerDay();
    }
}
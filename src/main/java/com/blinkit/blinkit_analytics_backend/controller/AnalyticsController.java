package com.blinkit.blinkit_analytics_backend.controller;

import com.blinkit.blinkit_analytics_backend.model.*;
import com.blinkit.blinkit_analytics_backend.service.AnalyticsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@CrossOrigin(origins = "http://localhost:5173")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/cancellation-rate")
    public double getCancellationRate() {
        return analyticsService.getAvgCancellationRate();
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

    @GetMapping("/revenue-per-city")
    public List<RevenuePerCity> getRevenuePerCity(){
        return analyticsService.getRevenuePerCity();
    }
    @GetMapping("/avg-order-value")
    public double getAvgOrderValue(){
        return analyticsService.getAVGOrderValue();
    }

    @GetMapping("/cancellation-per-city")
    public List<CancellationPerCity> getCancellationPerCity(){
        return analyticsService.getCancellationPerCity();
    }

    @GetMapping("/peak-delivery-hours")
    public List<DeliveryTImeByHour> getDeliveryTImeByHour(){
        return analyticsService.getDeliveryTimeByHour();
    }

    @GetMapping("/orders-per-hour")
    public List<OrderPerHour> getOrderPerHour(){
        return analyticsService.getOrderPerHour();
    }

    @GetMapping("total-revenue")
    public double getTotalRevenue() {
        return analyticsService.getTotalRevenue();
    }

    @GetMapping("total-riders")
    public long getTotalRiders(){
        return analyticsService.getTotalRiders();
    }

    @GetMapping("avg-delivery-time")
    public double getAvgDeliveryTime(){
        return analyticsService.getAvgDeliveryTime();
    }

    @GetMapping("orders-per-payment-method")
    public List<OrdersPerPaymentMethod  > getOrderPerPaymentMethod(){
        return analyticsService.getOrdersPerPaymentMethod();
    }

    @GetMapping("orders-per-category")
    public List<OrdersPerCategory> getOrdersPerCategory(){
        return analyticsService.getOrdersPerCategory();
    }

    @GetMapping("zone-wise-distribution")
    public List<ZoneWiseDistribution> getZoneWiseDistribution(){
        return analyticsService.getZoneWiseDistribution();
    }

    @GetMapping("rider-per-city")
    public List<RiderPerCity> getRiderPerCity(){
        return analyticsService.getRiderPerCity();
    }

    @GetMapping("rider-utilization")
    public List<RiderUtilization> getRiderUtilization(){
        return analyticsService.getRiderUtilization();
    }

    @GetMapping("repeat-customers")
    public long getRepeatCustomers(){
        return analyticsService.getRepeatCustomers();
    }
}
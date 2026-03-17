package com.blinkit.blinkit_analytics_backend.service;


import com.blinkit.blinkit_analytics_backend.model.*;
import com.blinkit.blinkit_analytics_backend.repository.AnalyticsRepository;
import com.blinkit.blinkit_analytics_backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    private final OrderRepository orderRepository;

    public long getTotalOrders(){
        return orderRepository.count();
    }

    public AnalyticsService(AnalyticsRepository analyticsRepository, OrderRepository orderRepository) {
        this.analyticsRepository = analyticsRepository;
        this.orderRepository = orderRepository;
    }

    public double getAvgCancellationRate() {
        return analyticsRepository.getAvgCancellationRate();
    }

    public List<OrdersPerCity> getOrderPerCity(){
        return analyticsRepository.getOrdersPerCity();
    }

    public List<AvgDeliveryTimePerCity> getAvgDeliveryTimePerCity() {
        return analyticsRepository.getAvgDeliveryTimePerCity();
    }
    public List<Top5Riders> getTopRiders(){
        return analyticsRepository.getTopRiders();
    }
    public List<OrdersPerDay> getOrdersPerDay(){
        return analyticsRepository.getOrdersPerDay();
    }
    public List<RevenuePerCity> getRevenuePerCity(){
        return analyticsRepository.getRevenuePerCity();
    }
    public double getAVGOrderValue(){
        return analyticsRepository.getAvgOrderValue();
    }
    public List<CancellationPerCity> getCancellationPerCity(){
        return analyticsRepository.getCancellationPerCity();
    }
    public List<DeliveryTImeByHour> getDeliveryTimeByHour(){
        return analyticsRepository.getDeliveryTimeByHour();
    }
    public  List<OrderPerHour> getOrderPerHour(){
        return analyticsRepository.getOrderPerHour();
    }
    public double getTotalRevenue() {
        return analyticsRepository.getTotalRevenue();
    }
    public long getTotalRiders(){
        return analyticsRepository.getTotalRiders();
    }

    public double getAvgDeliveryTime(){
        return analyticsRepository.getAvgDeliveryTime();
    }

    public List<OrdersPerPaymentMethod> getOrdersPerPaymentMethod(){
        return analyticsRepository.getOrdersPerPaymentMethod();
    }

    public List<OrdersPerCategory> getOrdersPerCategory(){
        return analyticsRepository.getOrdersPerCategory();
    }

    public List<ZoneWiseDistribution> getZoneWiseDistribution(){
        return analyticsRepository.getZoneWiseDistribution();
    }

    public List<RiderPerCity> getRiderPerCity(){
        return analyticsRepository.getRiderPerCity();
    }

    public List<RiderUtilization> getRiderUtilization(){
        return analyticsRepository.getRiderUtilization();
    }

    public long getRepeatCustomers(){
        return analyticsRepository.getRepeatCustomers();
    }
}
package com.blinkit.blinkit_analytics_backend.controller;

import com.blinkit.blinkit_analytics_backend.model.CancellationRateResponse;
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
}
package com.blinkit.blinkit_analytics_backend.service;


import com.blinkit.blinkit_analytics_backend.model.CancellationRateResponse;
import com.blinkit.blinkit_analytics_backend.repository.AnalyticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<CancellationRateResponse> getCancellationRate() {
        return analyticsRepository.getCancellationRateByCity();
    }
}
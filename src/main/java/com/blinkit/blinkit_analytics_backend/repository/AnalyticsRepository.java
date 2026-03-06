package com.blinkit.blinkit_analytics_backend.repository;

import com.blinkit.blinkit_analytics_backend.model.CancellationRateResponse;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnalyticsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CancellationRateResponse> getCancellationRateByCity() {

        String sql = """
            SELECT o.city,
            ROUND(COUNT(c.order_id)::numeric / COUNT(o.order_id) * 100, 2)
            FROM orders o
            LEFT JOIN cancellations c ON o.order_id = c.order_id
            GROUP BY o.city
        """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();

        List<CancellationRateResponse> response = new ArrayList<>();

        for (Object[] row : results) {
            String city = (String) row[0];
            Double rate = ((Number) row[1]).doubleValue();

            response.add(new CancellationRateResponse(city, rate));
        }

        return response;
    }
}
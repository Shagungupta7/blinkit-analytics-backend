package com.blinkit.blinkit_analytics_backend.repository;

import com.blinkit.blinkit_analytics_backend.model.*;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<OrdersPerCity> getOrdersPerCity(){
        String sql = """
                SELECT city, COUNT(*) FROM orders GROUP BY city;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<OrdersPerCity> response = new ArrayList<>();

        for(Object[] row : results){
            String city = (String) row[0];
            long totalOrders = ((Number) row[1]).longValue();

            response.add(new OrdersPerCity(city, totalOrders));
        }
        return response;
    }

    public List<AvgDeliveryTimePerCity> getAvgDeliveryTimePerCity(){
        String sql = """
                SELECT o.city, ROUND(AVG(d.delivery_minutes)::numeric, 2)
                FROM orders o
                JOIN deliveries d
                ON o.order_id = d.order_id
                GROUP BY o.city;
                """;
        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<AvgDeliveryTimePerCity> response = new ArrayList<>();

        for(Object[] row : results){
            String city = (String) row[0];
            Double avgTime = ((Number)row[1]).doubleValue();

            response.add(new AvgDeliveryTimePerCity(city, avgTime));
        }

        return response;
    }

    public List<Top5Riders> getTopRiders() {
        String sql = """
                SELECT r.name, ROUND(AVG(d.delivery_minutes)::numeric, 2) AS avg_time
                FROM rider r
                JOIN deliveries d
                ON r.riderid = d.riderid
                GROUP BY r.name
                ORDER BY avg_time ASC
                LIMIT 5;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<Top5Riders> response = new ArrayList<>();

        for(Object[] row : results){
            String name = (String) row[0];
            double time = ((Number) row[1]).doubleValue();

            response.add(new Top5Riders(name, time));
        }
        return response;
    }

    public List<OrdersPerDay> getOrdersPerDay(){
        String sql = """
                SELECT DATE(order_time) AS order_date, COUNT(*)
                FROM orders
                GROUP BY order_date
                ORDER BY order_date;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<OrdersPerDay> response = new ArrayList<>();

        for (Object[] row : results){
            LocalDate date = (LocalDate) row[0];
            long total = ((Number) row[1]).longValue();

            response.add(new OrdersPerDay(date, total));
        }
        return response;
    }
}
package com.blinkit.blinkit_analytics_backend.repository;

import com.blinkit.blinkit_analytics_backend.model.*;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnalyticsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public double getAvgCancellationRate() {

        String sql = """
            SELECT ROUND(COUNT(c.order_id)::numeric / COUNT(o.order_id) * 100, 2)
            FROM orders o
            LEFT JOIN cancellations c ON o.order_id = c.order_id;
        """;

        Object results = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) results).doubleValue();
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
                SELECT
                r.name,
                d.delivery_minutes
                FROM rider r
                JOIN deliveries d
                ON r.riderid = d.riderid
                ORDER BY d.delivery_minutes ASC
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
                ORDER BY order_date DESC;
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

    public List<RevenuePerCity> getRevenuePerCity(){
        String sql = """
                SELECT city, SUM(order_amount) AS total_amount
                FROM orders
                GROUP BY city
                ORDER BY total_amount ASC;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<RevenuePerCity> response = new ArrayList<>();

        for(Object[] row : results){
            String city = (String) row[0];
            double revenue = ((Number) row[1]).doubleValue();

            response.add(new RevenuePerCity(city, revenue));
        }
        return response;
    }

    public double getAvgOrderValue() {
        String sql = """
                SELECT SUM(order_amount)/COUNT(order_id)
                FROM orders;
                """;

        Object res = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) res).doubleValue();
    }

    public List<CancellationPerCity> getCancellationPerCity(){
        String sql = """
                SELECT city,
                COUNT(CASE WHEN status = 'Cancelled' THEN 1 END) AS cancelled_orders,
                COUNT(*) AS total_orders,
                ROUND( COUNT(CASE WHEN status = 'Cancelled' THEN 1 END)::numeric / COUNT(*), 2)
                AS cancellation_rate
                FROM orders
                GROUP BY city;
                """;

        List<Object[]> res = entityManager.createNativeQuery(sql).getResultList();
        List<CancellationPerCity> response = new ArrayList<>();

        for(Object[] row : res){
            String city = (String) row[0];
            long cancelled_orders = (((Number) row[1]).longValue());
            long total_orders = ((Number) row[2]).longValue();
            double rate = ((Number) row[3]).doubleValue();
            response.add(new CancellationPerCity(city, cancelled_orders, total_orders, rate));
        }
        return response;
    }

    public List<DeliveryTImeByHour> getDeliveryTimeByHour(){
        String sql = """
                SELECT EXTRACT(HOUR FROM o.order_time) AS hour,
                AVG(d.delivery_minutes)
                FROM orders o
                JOIN deliveries d
                ON o.order_id = d.order_id
                GROUP BY hour
                ORDER BY hour DESC;
                """;

        List<DeliveryTImeByHour> response = new ArrayList<>();
        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();

        for (Object[] row : results){
            int hour = ((Number) row[0]).intValue();
            double avgDeliveryTime = ((Number) row[1]).doubleValue();

            response.add(new DeliveryTImeByHour(hour, avgDeliveryTime));
        }
        return response;
    }

    public List<OrderPerHour> getOrderPerHour(){
        String sql = """
                SELECT EXTRACT(HOUR FROM order_time) AS hour, COUNT(*)
                FROM orders
                GROUP BY hour
                ORDER BY hour;
                """;

        List<Object[]> result = entityManager.createNativeQuery(sql).getResultList();
        List<OrderPerHour> response = new ArrayList<>();

        for(Object[] row : result){
            int hour = ((Number) row[0]).intValue();
            long orders = ((Number) row[1]).intValue();

            response.add(new OrderPerHour(orders, hour));
        }
        return response;
    }

    public double getTotalRevenue() {
        String sql = """
                SELECT
                ROUND(SUM(order_amount)::numeric, 2)
                FROM orders;
                """;

        Object results = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) results).doubleValue();
    }

    public long getTotalRiders(){
        String sql = """
                SELECT
                COUNT(riderid)
                FROM rider;
                """;

        Object result = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) result).longValue();
    }

    public double getAvgDeliveryTime() {
        String sql = """
                SELECT
                ROUND(AVG(delivery_minutes)::numeric,2)
                FROM deliveries;
                """;

        Object result = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) result).doubleValue();
    }

    public List<OrdersPerPaymentMethod> getOrdersPerPaymentMethod(){
        String sql = """
                 SELECT
                 payment_method, COUNT(order_id)
                 FROM orders
                 GROUP BY payment_method;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<OrdersPerPaymentMethod> response = new ArrayList<>();

        for(Object[] row : results){
            String method = row[0].toString();
            long totalOrders = ((Number)row[1]).longValue();

            response.add(new OrdersPerPaymentMethod(method, totalOrders));
        }
        return response;
    }

    public List<OrdersPerCategory> getOrdersPerCategory(){
        String sql = """
                SELECT
                category, COUNT(order_id)
                FROM orders
                GROUP BY category;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<OrdersPerCategory> response = new ArrayList<>();

        for(Object[] row : results){
            String category = row[0].toString();
            long totalOrders = ((Number) row[1]).longValue();

            response.add(new OrdersPerCategory(category, totalOrders));
        }
        return response;
    }

    public List<ZoneWiseDistribution> getZoneWiseDistribution(){
        String sql = """
                SELECT zone, COUNT(*)
                FROM orders
                GROUP BY zone;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<ZoneWiseDistribution> response = new ArrayList<>();

        for(Object[] row : results){
            String zone = row[0].toString();
            long orders = ((Number)row[1]).longValue();

            response.add(new ZoneWiseDistribution(zone, orders));
        }
        return response;
    }

    public List<RiderPerCity> getRiderPerCity(){
        String sql = """
                SELECT city, COUNT(*)
                FROM rider
                GROUP BY city;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<RiderPerCity> response = new ArrayList<>();

        for(Object[] row : results){
            String city = row[0].toString();
            long count = ((Number)row[1]).longValue();

            response.add(new RiderPerCity(city, count));
        }

        return response;
    }

    public List<RiderUtilization> getRiderUtilization(){
        String sql = """
                SELECT
                r.city,
                COUNT(d.delivery_id) AS total_deliveries,
                COUNT(DISTINCT r.riderid) AS total_riders,
                COUNT(d.delivery_id)/COUNT(DISTINCT r.riderid) AS avg_deliveries_per_rider
                FROM rider r
                JOIN deliveries d
                ON r.riderid = d.riderid
                GROUP BY r.city;
                """;

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<RiderUtilization> response = new ArrayList<>();

        for(Object[] row : results){
            String city = row[0].toString();
            long deliveries = ((Number) row[1]).longValue();
            long riders = ((Number) row[2]).longValue();
            long avg = ((Number) row[3]).longValue();

            response.add(new RiderUtilization(city, deliveries, riders, avg));
        }
        return response;
    }

    public long getRepeatCustomers(){
        String sql = """
                 SELECT
                 COUNT(*)
                 FROM
                 (SELECT
                 customer_id,
                 COUNT(order_id)
                 FROM orders
                 GROUP BY customer_id
                 HAVING COUNT(order_id) > 1)
                 AS repeat_customers;
                """;

        Object results = entityManager.createNativeQuery(sql).getSingleResult();

        return ((Number) results).longValue();
    }
}
package com.blinkit.blinkit_analytics_backend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String city;
    private String category;
    private Double orderAmount;
    private String paymentMethod;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    public Order(){}

    public Long getId(){ return orderId; }

    public String getCity(){ return city; }

    public String getCategory(){ return category; }

    public String getPaymentMethod() { return  paymentMethod; }

    public LocalDateTime getOrderTime() { return  orderTime; }

    public Double getOrderAmount() { return orderAmount; }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}

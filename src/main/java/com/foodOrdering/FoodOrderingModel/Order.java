package com.foodOrdering.FoodOrderingModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Order {
    public enum PaymentType{
        COD , UPI , DEBIT_CARD
    }
    public enum OrderStatus{
        ACTIVE , DELIVERED , CANCELLED
    }

    @Id
    private UUID orderId;
    private UUID customerId;
    private UUID restaurantId;
    private double totalAmount;
    private PaymentType paymentType;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;



    public Order() {
        this.orderId = UUID.randomUUID();
    }


    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", restaurantId=" + restaurantId +
                ", totalAmount=" + totalAmount +
                ", paymentType=" + paymentType +
                ", orderItems=" + orderItems +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

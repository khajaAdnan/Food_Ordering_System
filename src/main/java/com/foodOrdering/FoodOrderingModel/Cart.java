package com.foodOrdering.FoodOrderingModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Cart {

    @Id
    private UUID customerId;
    private UUID restaurantId;
    private String customerName;
    private String restaurantName;
    private List<OrderItem> addOrderItems;
    private double totalPrice;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<OrderItem> getAddOrderItems() {
        return addOrderItems;
    }

    public void setAddOrderItems(List<OrderItem> addOrderItems) {
        this.addOrderItems = addOrderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "customerId=" + customerId +
                ", restaurantId=" + restaurantId +
                ", customerName='" + customerName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", addOrderItems=" + addOrderItems +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

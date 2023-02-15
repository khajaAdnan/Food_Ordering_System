package com.foodOrdering.FoodOrderingModel;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class OrderItem {

    public enum TypeOfOrderItem{
        veg , nonVeg
    }

    private UUID OrderItemId;
    private String OrderItemName;
    private double orderItemPrice;
    private Boolean orderItemStatus;
    private TypeOfOrderItem typeOfOrderItem;
    private int orderQuantity;

    public OrderItem() {
        OrderItemId = UUID.randomUUID();
    }

    public UUID getOrderItemId() {
        return OrderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        OrderItemId = orderItemId;
    }

    public String getOrderItemName() {
        return OrderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        OrderItemName = orderItemName;
    }

    public double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Boolean getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(Boolean orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public TypeOfOrderItem getTypeOfOrderItem() {
        return typeOfOrderItem;
    }

    public void setTypeOfOrderItem(TypeOfOrderItem typeOfOrderItem) {
        this.typeOfOrderItem = typeOfOrderItem;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "OrderItemId=" + OrderItemId +
                ", OrderItemName='" + OrderItemName + '\'' +
                ", orderItemPrice=" + orderItemPrice +
                ", orderItemStatus=" + orderItemStatus +
                ", typeOfOrderItem=" + typeOfOrderItem +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}

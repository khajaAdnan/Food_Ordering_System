package com.foodOrdering.FoodOrderingModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Restaurant {

    public enum TypeOfRestaurant{
        nonVeg , veg , both_Veg_And_NonVeg
    }

    @Id
    private UUID restaurantId;
    private String restaurantName;
    private Address address;
    private TypeOfRestaurant typeOfRestaurant;
    public List<Items> itemsData;

    public Restaurant(UUID restaurantId, String restaurantName, Address address, TypeOfRestaurant typeOfRestaurant, List<Items> itemsData) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.typeOfRestaurant = typeOfRestaurant;
        this.itemsData = itemsData;
    }

    public Restaurant(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Restaurant() {
        this.restaurantId = UUID.randomUUID();
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TypeOfRestaurant getTypeOfRestaurant() {
        return typeOfRestaurant;
    }

    public void setTypeOfRestaurant(TypeOfRestaurant typeOfRestaurant) {
        this.typeOfRestaurant = typeOfRestaurant;
    }

    public List<Items> getItemsData() {
        return itemsData;
    }

    public void setItemsData(List<Items> itemsData) {
        this.itemsData = itemsData;
    }


}

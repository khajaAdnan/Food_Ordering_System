package com.foodOrdering.FoodOrderingModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Items {
    public enum TypeOfItem{
        veg , nonVeg
    }
    public enum ItemStatus{
        stock_Available , stock_Not_Available
    }
    @Id
    private UUID itemId;
    private String itemName;
    private double itemPrice;
    private ItemStatus itemStatus;
    private TypeOfItem typeOfItem;


    public Items() {
        this.itemId = UUID.randomUUID();
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public TypeOfItem getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(TypeOfItem typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemStatus=" + itemStatus +
                ", typeOfItem=" + typeOfItem +
                '}';
    }
}

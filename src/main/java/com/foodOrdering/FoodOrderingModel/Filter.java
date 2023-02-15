package com.foodOrdering.FoodOrderingModel;

public class Filter {

    private String city;
    public enum TypeOfRestaurant{
        veg , non_veg , both
    }
    private TypeOfRestaurant typeOfRestaurant;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public TypeOfRestaurant getTypeOfRestaurant() {
        return typeOfRestaurant;
    }

    public void setTypeOfRestaurant(TypeOfRestaurant typeOfRestaurant) {
        this.typeOfRestaurant = typeOfRestaurant;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "city='" + city + '\'' +
                ", typeOfRestaurant=" + typeOfRestaurant +
                '}';
    }
}

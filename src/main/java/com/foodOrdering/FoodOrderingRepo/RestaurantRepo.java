package com.foodOrdering.FoodOrderingRepo;

import com.foodOrdering.FoodOrderingModel.Items;
import com.foodOrdering.FoodOrderingModel.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RestaurantRepo extends MongoRepository<Restaurant , UUID> {

    @Query("{ 'RestaurantName' : { $regex: '(?i)?0' } }")
    List<Restaurant> findRestaurantByName(String restaurantName);

    @Query("{ 'ItemName' : { $regex: '(?i)?0' } }")
    List<Items> findItemByName(String itemName);
}

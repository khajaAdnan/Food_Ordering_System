package com.foodOrdering.ResRepo;

import com.foodOrdering.FoodOrderingModel.Restaurant;
import com.foodOrdering.FoodOrderingRepo.RestaurantRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RestaurantRepoTest {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Test
    void findRestaurantByName() {
        List<Restaurant> restaurantList = restaurantRepo.findRestaurantByName("alsaba");
        for (Restaurant restaurant : restaurantList){
          String name = restaurant.getRestaurantName();
            assertThat(name).isEqualTo("alsaba");
        }
    }
}
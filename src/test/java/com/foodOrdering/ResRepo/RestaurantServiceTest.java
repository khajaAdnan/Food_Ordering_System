package com.foodOrdering.ResRepo;

import com.foodOrdering.FoodOrderingModel.Restaurant;
import com.foodOrdering.FoodOrderingRepo.RestaurantRepo;
import com.foodOrdering.FoodOrderingService.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {


    @Mock
    private RestaurantRepo restaurantRepo;


    private RestaurantService restaurantService;

    @BeforeEach
    void setUp(){
        this.restaurantService = new RestaurantService(this.restaurantRepo);
    }

    @Test
    void getAllRestaurant() {
        restaurantService.getAllRestaurant();
        verify(restaurantRepo).findAll();
    }

    @Test
    void getRestaurantById(){
      restaurantService.getRestaurantById(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5"));
      assertThat(restaurantRepo.findById(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5")));
    }

    @Test
    void addRestaurant(){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("erjg");
        when(restaurantRepo.save(restaurant)).thenReturn(restaurant);
        assertEquals(restaurant , restaurantService.addRestaurant(restaurant));
    }

    @Test
    void deleteRestaurant(){
         Restaurant restaurant = new Restaurant();
         restaurantService.deleteRestaurant(restaurant.getRestaurantId());
         verify(restaurantRepo , times(1)).deleteById(restaurant.getRestaurantId());
    }

    @Test
    void listingWithPagination(){
        List<Restaurant> restaurantList = (List<Restaurant>) restaurantRepo.findAll();
        for(Restaurant restaurant : restaurantList){
            assertThat(restaurantList).isNotNull();
        }
    }


}
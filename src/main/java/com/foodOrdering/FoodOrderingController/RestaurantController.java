package com.foodOrdering.FoodOrderingController;

import com.foodOrdering.FoodOrderingModel.Filter;
import com.foodOrdering.FoodOrderingModel.Items;
import com.foodOrdering.FoodOrderingModel.Restaurant;
import com.foodOrdering.FoodOrderingService.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/get/all/restaurant")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/get/restaurant/{id}")
    public Optional<Restaurant> getByRestaurantId(@PathVariable UUID id) {
        return Optional.ofNullable(restaurantService.getRestaurantById(id));
    }

    @PostMapping("/add/restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/add/items")
    public Restaurant updateItem(@RequestBody Items items , @RequestParam UUID restaurantId){
        return restaurantService.updateItem((List<Items>) items , restaurantId);
    }

    @PutMapping("/update/restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRestaurant(@PathVariable UUID id){
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/get/restaurant/name")
    public List<Restaurant> findRestaurantByName(@RequestParam String restaurantName){
        return restaurantService.findRestaurantByName(restaurantName);
    }

    @GetMapping("/listing/pagination")
    public List<Restaurant> listingWithPagination(@RequestParam int pageNo, @RequestParam int size){
        return restaurantService.listingWithPagination(pageNo , size);
    }


    @GetMapping("/filter")
    public List<Restaurant> filterRestaurant(@RequestBody Filter filter){
        return restaurantService.filterRestaurant((filter));
    }
}

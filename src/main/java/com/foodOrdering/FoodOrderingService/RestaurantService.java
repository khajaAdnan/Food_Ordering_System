package com.foodOrdering.FoodOrderingService;

import com.foodOrdering.FoodOrderingModel.Filter;
import com.foodOrdering.FoodOrderingModel.Items;
import com.foodOrdering.FoodOrderingModel.Restaurant;
import com.foodOrdering.FoodOrderingRepo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public RestaurantService(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }


    public Restaurant addRestaurant(Restaurant restaurant) {
       return restaurantRepo.save(restaurant);

    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(UUID id) {
        return restaurantRepo.findById(id).orElse(null);
    }


    public void deleteRestaurant(UUID id) {
        restaurantRepo.deleteById(id);
    }


    public Restaurant updateRestaurant(Restaurant restaurant) {
        AtomicReference<Restaurant> restaurantAtomicReference = new AtomicReference<>();
        Optional<Restaurant> restaurantOptional = restaurantRepo.findById(restaurant.getRestaurantId());
        restaurantOptional.ifPresent(data -> {
            data.setAddress(restaurant.getAddress());
            data.setItemsData(restaurant.getItemsData());
            data.setRestaurantName(restaurant.getRestaurantName());
            data.setTypeOfRestaurant(restaurant.getTypeOfRestaurant());
            restaurantAtomicReference.set(restaurantRepo.save(data));
        });
        return restaurantAtomicReference.get();
    }


    public List<Restaurant> findRestaurantByName(String restaurantName) {
        return restaurantRepo.findRestaurantByName(restaurantName);
    }

    public List<Items> findItemByName(String itemName) {
        return restaurantRepo.findItemByName(itemName);
    }


    public List<Restaurant> listingWithPagination(int page , int size){
        Pageable pageable = PageRequest.of(page,size);
        Query query = new Query();
        query.with(pageable);
        List<Restaurant> restaurants = mongoTemplate.find(query, Restaurant.class);
        return restaurants;
    }


    public List<Restaurant> filterRestaurant(Filter filter){

        Query query = new Query();
        if(filter.getCity()!=null) {
            query.addCriteria(Criteria.where("address.city").is(filter.getCity()));
        }
        if(filter.getTypeOfRestaurant()!=null){
            query.addCriteria(Criteria.where("TypeOfRestaurant").is(filter.getTypeOfRestaurant()));
        }
        List<Restaurant> restaurants = mongoTemplate.find(query,Restaurant.class);
        return restaurants;
    }


    public Restaurant updateItem( List<Items> items, UUID restaurantId) {
        AtomicReference<Restaurant> restaurantAtomicReference = new AtomicReference<>();
        Optional<Restaurant> restaurantOptional = restaurantRepo.findById(restaurantId);
        restaurantOptional.ifPresent(data -> {
            data.getItemsData().addAll(items);
            restaurantAtomicReference.set(restaurantRepo.save(data));
        });
        return restaurantAtomicReference.get();
    }
}
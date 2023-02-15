package com.foodOrdering.FoodOrderingRepo;

import com.foodOrdering.FoodOrderingModel.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CartRepo extends MongoRepository<Cart , UUID> {
}

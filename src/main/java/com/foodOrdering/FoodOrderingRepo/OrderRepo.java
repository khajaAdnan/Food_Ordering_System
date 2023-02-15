package com.foodOrdering.FoodOrderingRepo;

import com.foodOrdering.FoodOrderingModel.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepo extends MongoRepository<Order , UUID> {
}

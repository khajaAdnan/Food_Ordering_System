package com.foodOrdering.FoodOrderingRepo;

import com.foodOrdering.FoodOrderingModel.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepo extends MongoRepository<Customer , UUID> {
}

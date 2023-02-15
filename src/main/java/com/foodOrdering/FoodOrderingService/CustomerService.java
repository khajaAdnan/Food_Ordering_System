package com.foodOrdering.FoodOrderingService;

import com.foodOrdering.FoodOrderingModel.Cart;
import com.foodOrdering.FoodOrderingModel.Customer;
import com.foodOrdering.FoodOrderingModel.Restaurant;
import com.foodOrdering.FoodOrderingRepo.CartRepo;
import com.foodOrdering.FoodOrderingRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private MongoTemplate mongoTemplate;


    public Customer addCustomer(Customer customer) {
       return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(UUID customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    public void deleteCustomer(UUID customerId) {
        customerRepo.deleteById(customerId);
    }


    public Customer updateCustomer(Customer customer) {
        AtomicReference<Customer> customerAtomicReference = new AtomicReference<>();
        Optional<Customer> customerOptional = customerRepo.findById(customer.getCustomerId());
        customerOptional.ifPresent(data -> {
            data.setCustomerName(customer.getCustomerName());
            data.setAddress(customer.getAddress());
            data.setCustomerMobileNumber(customer.getCustomerMobileNumber());
            data.seteMail(customer.geteMail());
            customerAtomicReference.set(customerRepo.save(data));
        });
        return customerAtomicReference.get();
    }

    public List<Customer> listingWithPagination(int page , int size){
        Pageable pageable = PageRequest.of(page,size);
        Query query = new Query();
        query.with(pageable);
        List<Customer> customers = mongoTemplate.find(query, Customer.class);
        return customers;
    }
}

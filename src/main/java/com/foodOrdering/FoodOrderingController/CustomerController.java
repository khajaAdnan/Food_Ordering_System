package com.foodOrdering.FoodOrderingController;

import com.foodOrdering.FoodOrderingModel.Cart;
import com.foodOrdering.FoodOrderingModel.Customer;
import com.foodOrdering.FoodOrderingService.CartService;
import com.foodOrdering.FoodOrderingService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/all/customer")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/get/customer/{id}")
    public Optional<Customer> getByCustomerId(@PathVariable UUID id) {
        return Optional.ofNullable(customerService.getCustomerById(id));
    }

    @PostMapping("/add/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/update/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
    }
}

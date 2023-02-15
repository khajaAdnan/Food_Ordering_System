package com.foodOrdering.FoodOrderingController;

import com.foodOrdering.FoodOrderingModel.Cart;
import com.foodOrdering.FoodOrderingModel.Order;
import com.foodOrdering.FoodOrderingService.CartService;
import com.foodOrdering.FoodOrderingService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PutMapping("/to/cart")
    public Order pushCartToOrder(@RequestParam UUID customerId){
        return orderService.pushCartToOrder(customerId);
    }

    @GetMapping("/get/all/order")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/get/order/{id}")
    public Optional<Order> getByOrderId(@PathVariable UUID id) {
        return Optional.ofNullable(orderService.getOrderById(id));
    }

    @PutMapping("/update/orderStatus")
    public Order updateOrderStatus(@RequestParam UUID OrderId , @RequestParam Order.OrderStatus status){

        return orderService.orderStatus(OrderId , status);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable UUID id){
        orderService.deleteOrder(id);
    }
}

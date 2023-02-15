package com.foodOrdering.FoodOrderingService;

import com.foodOrdering.FoodOrderingModel.*;
import com.foodOrdering.FoodOrderingRepo.CartRepo;
import com.foodOrdering.FoodOrderingRepo.CustomerRepo;
import com.foodOrdering.FoodOrderingRepo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartRepo cartRepo;


    public Order pushCartToOrder(UUID customerId){
        Optional<Cart> cart = cartRepo.findById(customerId);
        Order order = new Order();
        order.setTotalAmount(cart.get().getTotalPrice());
        order.setRestaurantId(cart.get().getRestaurantId());
        order.setOrderItems(cart.get().getAddOrderItems());
        order.setCustomerId(cart.get().getCustomerId());
        return orderRepo.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    public Order getOrderById(UUID orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    public void deleteOrder(UUID orderId) {
        orderRepo.deleteById(orderId);
    }


    public Order orderStatus(UUID OrderId, Order.OrderStatus status ) {
        AtomicReference<Order> orderAtomicReference = new AtomicReference<>();
        Optional<Order> orderOptional = orderRepo.findById(OrderId);
        orderOptional.ifPresent(data -> {
            data.setOrderStatus(status);
            orderAtomicReference.set(orderRepo.save(data));
        });
        return orderAtomicReference.get();
    }
}


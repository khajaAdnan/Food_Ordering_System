package com.foodOrdering.FoodOrderingService;

import com.foodOrdering.FoodOrderingModel.Cart;
import com.foodOrdering.FoodOrderingModel.OrderItem;
import com.foodOrdering.FoodOrderingRepo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;


    public List<Cart> getAllCart() {
        return cartRepo.findAll();
    }

    public Cart getCartByCustomerId(UUID customerId) {
        return cartRepo.findById(customerId).orElse(null);
    }

    public void deleteCartByCustomerId(UUID customerId) {
        cartRepo.deleteById(customerId);
    }


    public Cart updateCart(Cart cart) {
        AtomicReference<Cart> cartAtomicReference = new AtomicReference<>();
        Optional<Cart> cartOptional = cartRepo.findById(cart.getCustomerId());
        cartOptional.ifPresent(data -> {
            data.setRestaurantId(cart.getRestaurantId());
            data.setAddOrderItems(cart.getAddOrderItems());
            data.setCustomerName(cart.getCustomerName());
            data.setRestaurantName(cart.getRestaurantName());
            double totalPrice = 0.0;
            if (data.getAddOrderItems() != null) {
                for (OrderItem orderItem : data.getAddOrderItems()) {
                    totalPrice = (totalPrice + (orderItem.getOrderItemPrice() * orderItem.getOrderQuantity()));
                }
            }
            data.setTotalPrice(totalPrice);
            cartAtomicReference.set(cartRepo.save(data));
        });
        return cartAtomicReference.get();
    }

    public Cart addCart(Cart cart) {
        return  cartRepo.save(cart);

    }
}
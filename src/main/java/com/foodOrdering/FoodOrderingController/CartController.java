package com.foodOrdering.FoodOrderingController;

import com.foodOrdering.FoodOrderingModel.Cart;
import com.foodOrdering.FoodOrderingService.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    @GetMapping("/get/all/cart")
    public List<Cart> getAllCart() {
        return cartService.getAllCart();
    }

    @GetMapping("/get/cart/{id}")
    public Optional<Cart> getCartByCustomerId(@PathVariable UUID id) {
        return Optional.ofNullable(cartService.getCartByCustomerId(id));
    }

    @PutMapping("/update/cart")
    public Cart updateCart(@RequestBody Cart cart){
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable UUID id){
        cartService.deleteCartByCustomerId(id);
    }

}

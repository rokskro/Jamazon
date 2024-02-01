package com.testing.controllers;

import com.testing.dto.AddToCartDto;
import com.testing.model.pojos.Cart;
import com.testing.model.pojos.Orders;
import com.testing.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addProductToCart(@RequestBody AddToCartDto addToCartDto) {
        Cart cart = cartService.addProductToCart(addToCartDto);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long cartId) {
        cartService.removeProductFromCart(cartId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/checkout")
    public ResponseEntity<Orders> convertCartToOrder(@RequestParam Long customerId) {
        Orders order = cartService.convertCartToOrder(customerId);
        return ResponseEntity.ok(order);
    }
}

package com.testing.service;

import com.testing.dto.AddToCartDto;
import com.testing.model.pojos.Cart;
import com.testing.model.pojos.Product;
import com.testing.repo.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, long customerId) {
        Cart cart = new Cart(addToCartDto, customerId);
        cartRepository.save(cart);
    }

    private Cart addToCartFromDto(AddToCartDto addToCartDto, long customerId) {
        Cart cart = new Cart(addToCartDto, customerId);
        return cart;
    }

    public void updateCartItem(AddToCartDto cartDto, long customerId, Product product){
        Cart cart = getAddToCartFromDto(cartDto,customerId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setCustomerId(customerId);
        cart.setId(cartDto.getId());
        cart.setProductId(product.getId());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    public void deleteCartItem(long cartId, long customerId) throws CartItemNotExistException {
        if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + cartId);
        cartRepository.deleteById(cartId);

    }


}

package com.testing.service;

import com.testing.dto.AddToCartDto;
import com.testing.model.pojos.Cart;
import com.testing.model.pojos.Customer;
import com.testing.model.pojos.Product;
import com.testing.repo.CartRepository;
import com.testing.repo.CustomerRepository;
import com.testing.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository,
                       CustomerRepository customerRepository,
                       ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Cart addProductToCart(AddToCartDto addToCartDto) {
        Customer customer = customerRepository.findById(addToCartDto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Product product = productRepository.findById(addToCartDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Cart cart = new Cart(customer, product, addToCartDto.getQuantity());
        return cartRepository.save(cart);
    }

    public void removeProductFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }


}

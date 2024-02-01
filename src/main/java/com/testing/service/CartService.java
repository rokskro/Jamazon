package com.testing.service;

import com.testing.dto.AddToCartDto;
import com.testing.model.pojos.*;
import com.testing.repo.CartRepository;
import com.testing.repo.CustomerRepository;
import com.testing.repo.OrdersRepository;
import com.testing.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    private final OrdersRepository ordersRepository;

    @Autowired
    public CartService(CartRepository cartRepository,
                       CustomerRepository customerRepository,
                       ProductRepository productRepository,
                       OrdersRepository ordersRepository
                       ) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.ordersRepository = ordersRepository;
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


    public Orders convertCartToOrder(Long customerId) {
        List<Cart> cartItems = cartRepository.findAllByCustomerId(customerId);
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        //List<OrderProduct> orderProducts = new ArrayList<>();
        Orders newOrder = new Orders();
        double orderTotal = 0.0;

        for (Cart cartItem : cartItems) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(newOrder);
            orderProduct.setProduct(cartItem.getProduct());
            orderProduct.setQuantity(cartItem.getQuantity());

            double productTotal = cartItem.getQuantity() * cartItem.getProduct().getValue();
            orderProduct.setPrice(productTotal);
            orderTotal += productTotal;

            newOrder.getOrderProducts().add(orderProduct);

        }

        newOrder.setTotalCost(orderTotal);
        /*newOrder.setOrdersStatus(OrdersStatus.PENDING);
        newOrder.setCustomer(customerRepository.findById(customerId));
        newOrder.setDatePlaced(new Date());*/

        ordersRepository.save(newOrder);
        cartRepository.deleteAll(cartItems);

        return newOrder;
    }

}

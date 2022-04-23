package com.micropos.carts.rest;

import com.micropos.carts.api.CartApi;
import com.micropos.carts.dto.CartDto;
import com.micropos.carts.mapper.CartsMapper;
import com.micropos.carts.model.Cart;
import com.micropos.carts.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class CartsController implements CartApi {

    private final CartsMapper cartsMapper;

    private final CartsService cartsService;

    Cart cart;

    @Autowired
    public CartsController(CartsService cartService, Cart cart, CartsMapper cartsMapper) {
        this.cartsService = cartService;
        this.cart = cart;
        this.cartsMapper = cartsMapper;
    }

    @Override
    public ResponseEntity<CartDto> addToCart(String productId) {
        if (cart == null) cart = new Cart();
        cartsService.add(cart, productId, 1);
        return  new ResponseEntity<>(cartsMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> listCart() {
        if (cart == null) cart = new Cart();
        return new ResponseEntity<>(cartsMapper.toCartDto(cart), HttpStatus.OK);
    }
}

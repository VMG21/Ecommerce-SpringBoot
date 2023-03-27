package com.vic.carrito.repository;

import com.vic.carrito.dl.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}

package com.vic.carrito.repository;

import com.vic.carrito.dl.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
}

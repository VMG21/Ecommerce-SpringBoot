package com.vic.carrito.bl;



import com.vic.carrito.dl.Customer;

import java.math.BigDecimal;

public interface PurchaseProcess {
    public void AddItemToCart(Integer itemId, BigDecimal quantity);

    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity);

    public void Checkout();

    public Customer setCustomer(int customerId);

    public Customer getCustomer();
}

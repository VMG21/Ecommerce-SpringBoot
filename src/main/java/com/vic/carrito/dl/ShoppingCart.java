package com.vic.carrito.dl;

import jakarta.persistence.*;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shoppingCart_id")
    private long shoppingCartId;

    @Column(name = "customer_id")
    private long customerId;

    public ShoppingCart(){}

    public ShoppingCart(long customer_id){
        this.customerId = customer_id;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public long getCustomer_id() {
        return customerId;
    }

    @OneToOne(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoppingCartItem_id")
    private ShoppingCartItem shoppingCartItem;
}

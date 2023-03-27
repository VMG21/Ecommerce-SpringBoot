package com.vic.carrito.dl;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shoppingCartItem")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shoppingCartItem_id")
    private long shoppingCartItemId;

    @Column(name = "shoppingCart_id")
    private Long shoppingCartId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "quantity")
    private BigDecimal quantity;

    public ShoppingCartItem(){}

    public ShoppingCartItem(Long shoppingCartId, Long itemId, BigDecimal quantity){
        this.shoppingCartId = shoppingCartId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public long getId() {
        return shoppingCartItemId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public Long getItemId() {
        return itemId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @OneToOne(mappedBy = "shoppingCartItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;

//    @OneToMany(mappedBy = "shoppingCartItem")
//    private Set<Item> items = new HashSet<>();
}

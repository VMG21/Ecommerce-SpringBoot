package com.vic.carrito.dl;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    public Item(){}

    public Item(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString(){
        return "Producto [id = " + itemId + ", nombre = " + name + ", precio = " + price + "]";
    }

//    @ManyToOne
//    @JoinColumn(name = "shoppingCartItem_id")
//    private ShoppingCartItem shoppingCartItem;
}

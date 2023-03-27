package com.vic.carrito.bl;

import com.vic.carrito.dl.Item;

import java.util.List;

public interface itemService {
    List<Item> getAllItems();

    Item getItemById(Long id);

    Item updateItem(Item item);

    void deleteItemById(Long id);
}

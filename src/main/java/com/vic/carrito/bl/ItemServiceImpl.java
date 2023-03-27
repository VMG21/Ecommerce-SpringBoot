package com.vic.carrito.bl;

import com.vic.carrito.dl.Item;
import com.vic.carrito.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements itemService{
    private ItemRepository itemRepository;


    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @Override
    public List <Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }


    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }


}

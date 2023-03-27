package com.vic.carrito.controller;

import com.vic.carrito.bl.itemService;
import com.vic.carrito.dl.Item;
import com.vic.carrito.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiItem")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) String name){
        try {
            List<Item> items = new ArrayList<Item>();
            if (name == null)
                itemRepository.findAll().forEach(items::add);
            else
                itemRepository.findByName(name).forEach(items::add);

            if (items.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id){
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()){
            return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/addItem", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RedirectView redirect(@Validated @ModelAttribute("item") Item item, Model model) {
            Item _item = itemRepository
                    .save(new Item(item.getName(), item.getDescription(), item.getPrice()));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/items");

        return redirectView;
    }

//    @DeleteMapping("/items/{id}")
//    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") long id){
//        try {
//            itemRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping("/itemsD")
    public ResponseEntity<HttpStatus> deleteAllItems() {
        try {
            itemRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

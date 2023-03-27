package com.vic.carrito.controller;

import com.vic.carrito.bl.itemService;
import com.vic.carrito.dl.Customer;
import com.vic.carrito.dl.Item;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarritoFrontend {

    private itemService itemService;

    public CarritoFrontend(itemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        return "register";
    }

    @GetMapping("/items")
    public String item(Model model){
        model.addAttribute("item", itemService.getAllItems());

        return "items";
    }

    @GetMapping("/newItem")
    public String item2(Model model){
        Item item = new Item();

        model.addAttribute("item", item);

        return "addItem";
    }

    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

    @GetMapping("/items/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "updateItem";
    }

    @PostMapping(value="/items/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("item") Item item, Model model) {

        Item existingItem = itemService.getItemById(id);
        existingItem.setItemId(id);
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setPrice(item.getPrice());

        itemService.updateItem(existingItem);

        return "redirect:/items";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("title", "Carrito de compras");
        return "login";
    }
}

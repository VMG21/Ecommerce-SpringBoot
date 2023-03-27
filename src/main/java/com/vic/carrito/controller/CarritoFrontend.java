package com.vic.carrito.controller;

import com.vic.carrito.bl.itemService;
import com.vic.carrito.dl.Customer;
import com.vic.carrito.dl.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("title", "Carrito de compras");
        return "login";
    }
}

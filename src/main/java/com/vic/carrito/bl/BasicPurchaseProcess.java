//package com.vic.carrito.bl;
//
//import com.vic.carrito.dl.Customer;
//import com.vic.carrito.dl.Item;
//import com.vic.carrito.dl.ShoppingCart;
//import com.vic.carrito.repository.CustomerRepository;
//import com.vic.carrito.repository.ItemRepository;
//
//import java.math.BigDecimal;
//
//
//public class BasicPurchaseProcess implements PurchaseProcess{
//    private final CustomerRepository customerRepository;
//    private final ItemRepository itemRepository;
//
//    private Customer customer;
//    private ShoppingCart shoppingCart;
//
//    public BasicPurchaseProcess() {
//        this.customerRepository = new Customer;
//        this.itemRepository = new Item;
//        this.shoppingCart = new ShoppingCart();
//    }
//
//    @Override
//    public void AddItemToCart(Integer itemId, BigDecimal quantity) {
//        var item = itemRepository.findItem(itemId);
//        this.shoppingCart.AddItemToCart(item, quantity);
//    }
//
//    @Override
//    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity) {
//        if (quantity.compareTo(BigDecimal.ZERO) == 0) {
//            return;
//        }
//
//        var currentQuantity = this.shoppingCart.GetItemQuantity(itemRepository.findItem(itemId));
//        if (currentQuantity.compareTo(quantity) <= 0) {
//            this.shoppingCart.RemoveItemFromCart(itemRepository.findItem(itemId));
//        } else if (currentQuantity.compareTo(quantity) > 0) {
//            this.shoppingCart.UpdateItemInCart(itemRepository.findItem(itemId), currentQuantity.subtract(quantity));
//        }
//    }
//
//    @Override
//    public void Checkout() {
//        throw new UnsupportedOperationException("Unimplemented method 'Checkout'");
//    }
//
//    @Override
//    public Customer setCustomer(int customerId) {
//        this.customer = customerRepository.findCustomer(customerId);
//        return this.customer;
//    }
//
//    @Override
//    public Customer getCustomer() {
//        return this.customer;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Customer: " + this.customer.email()+"\n");
//        var items = this.shoppingCart.getItems();
//
//        items.forEach((key, value) -> {
//            sb.append("Item: " + key.toString() + " Quantity: " + value + "\n");
//        });
//
//        return sb.toString();
//    }
//}

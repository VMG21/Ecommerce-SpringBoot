package com.vic.carrito.controller;

import com.vic.carrito.dl.Customer;
import com.vic.carrito.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCustomer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllItems(@RequestParam(required = false) String email){
        try {
            List<Customer> customer = new ArrayList<Customer>();
            if (email == null)
                customerRepository.findAll().forEach(customer::add);
            else
                customerRepository.findByEmail(email).forEach(customer::add);

            if (customer.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getItemById(@PathVariable("id") long id){
        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()){
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RedirectView redirect(@Validated @ModelAttribute("customer") Customer customer, Model model){

            Customer _customer = customerRepository
                    .save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone()));

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8080/login");

            return redirectView;
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customerD")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        try {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.vic.carrito;

import com.vic.carrito.dl.Item;
import com.vic.carrito.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CarritoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarritoApplication.class, args);
	}

	@Autowired
	private ItemRepository itemRepository;

	BigDecimal a = new BigDecimal(45);
	BigDecimal b = new BigDecimal(45);
	BigDecimal c = new BigDecimal(45);

	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("asd", "asd", a);
		itemRepository.save(item1);

		Item item2 = new Item("asd", "asd", b);
		itemRepository.save(item2);

		Item item3 = new Item("asd", "asd", c);
		itemRepository.save(item3);
	}
}

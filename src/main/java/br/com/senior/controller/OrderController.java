package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.domain.service.OrderService;
import br.com.senior.model.Order;
import br.com.senior.model.dto.OrderDTO;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Order> list() {
		return orderService.list();

	}

	@GetMapping("/{orderID}")
	public ResponseEntity<Order> readOrder(@PathVariable Long orderID) {
		Optional<Order> order = this.orderService.read(orderID);
		return order.isPresent() ? ResponseEntity.ok(order.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO, HttpServletResponse response) {
		Order orderCreated = orderService.create(orderDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);

	}

	@PutMapping("/{orderID}")
	public Order update(@RequestBody OrderDTO orderDTO, @PathVariable Long orderID) {
		Order orderRead = orderService.read(orderID).orElseThrow(IllegalArgumentException::new);
		return orderService.update(orderRead, orderDTO);

	}

	@DeleteMapping("/{orderID}")
	public void deleteOrder(@PathVariable Long orderID) {
		orderService.delete(orderID);

	}

}

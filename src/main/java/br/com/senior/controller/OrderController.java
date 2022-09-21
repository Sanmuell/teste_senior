package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletResponse;

import br.com.senior.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.service.OrderService;
import br.com.senior.model.Order;
import br.com.senior.model.dto.OrderDTO;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<Order> list() {
		return orderService.list();

	}

	@GetMapping("/por-numero")
	public List<Order> listByNumber(@RequestParam ("number") Integer number){
		return orderRepository.number(number);
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
	public ResponseEntity<Order> update(@RequestBody OrderDTO orderDTO, @PathVariable Long orderID) {
		Order orderRead = orderService.read(orderID).orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(orderDTO, orderRead );
		orderService.update(orderRead, orderDTO);
		return ResponseEntity.ok(orderRead);

	}

	@DeleteMapping("/{orderID}")
	public void deleteOrder(@PathVariable Long orderID) {
		orderService.delete(orderID);

	}

}

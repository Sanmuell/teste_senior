package br.com.senior.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import javax.servlet.http.HttpServletResponse;

import br.com.senior.model.OrderEntity;
import br.com.senior.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.service.OrderService;
import br.com.senior.model.dto.OrderDTO;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<OrderEntity> list() {
		return orderService.list();

	}

	@GetMapping("/por-numero")
	public List<OrderEntity> listByNumber(@RequestParam ("number") Integer number){
		return orderRepository.number(number);
	}



	@GetMapping("/{orderID}")
	public ResponseEntity<OrderEntity> readOrder(@PathVariable UUID orderID) {
		Optional<OrderEntity> order = this.orderService.read(orderID);
		return order.isPresent() ? ResponseEntity.ok(order.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDTO orderDTO, HttpServletResponse response) {
		OrderEntity orderEntityCreated = orderService.create(orderDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderEntityCreated);

	}

	@PutMapping("/{orderID}")
	public ResponseEntity<OrderEntity> update(@RequestBody OrderDTO orderDTO, @PathVariable UUID orderID) {
		OrderEntity orderEntityRead = orderService.read(orderID).orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(orderDTO, orderEntityRead);
		orderService.update(orderEntityRead, orderDTO);
		return ResponseEntity.ok(orderEntityRead);

	}

	@DeleteMapping("/{orderID}")
	public void deleteOrder(@PathVariable UUID orderID) {
		orderService.delete(orderID);

	}

}

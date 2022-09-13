package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.domain.service.OrderItemService;
import br.com.senior.domain.model.OrderItem;
import br.com.senior.domain.model.dto.OrderItemDTO;
import br.com.senior.domain.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderItemController {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/{orderId}/items/")
	public List<OrderItem> list() {
		return orderItemService.list();

	}

	@GetMapping("/{orderId}/items/{orderItemId}")
	public ResponseEntity<OrderItem> readOrderItem(@PathVariable Long orderItemId) {
		Optional<OrderItem> orderItem = this.orderItemRepository.findById(orderItemId);
		return orderItem.isPresent() ? ResponseEntity.ok(orderItem.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/{orderId}/items/")
	public ResponseEntity<OrderItem> create(@PathVariable Long orderId, @RequestBody OrderItemDTO orderItemDTO) {
		OrderItem itemCreated = this.orderItemService.create(orderItemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemCreated);

	}
	@PutMapping("/{orderId}/items/{orderItemId}")
	public ResponseEntity<OrderItem> update(@PathVariable Long orderItemId, @RequestBody OrderItemDTO orderItemDTO) {
		OrderItem orderItemRead = orderItemService.read(orderItemId).orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(orderItemDTO, orderItemRead );
		orderItemService.update(orderItemRead, orderItemDTO);
		return ResponseEntity.ok(orderItemRead);


	}

}

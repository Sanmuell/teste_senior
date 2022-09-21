package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.service.OrderItemService;
import br.com.senior.model.OrderItemEntity;
import br.com.senior.model.dto.OrderItemDTO;
import br.com.senior.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderItemController {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/{orderId}/items/")
	public List<OrderItemEntity> list() {
		return orderItemService.list();

	}

	@GetMapping("/{orderId}/items/{orderItemId}")
	public ResponseEntity<OrderItemEntity> readOrderItem(@PathVariable Long orderItemId) {
		Optional<OrderItemEntity> orderItem = this.orderItemRepository.findById(orderItemId);
		return orderItem.isPresent() ? ResponseEntity.ok(orderItem.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping("/{orderId}/items/")
	public ResponseEntity<OrderItemEntity> create(@PathVariable Long orderId, @RequestBody OrderItemDTO orderItemDTO) {
		OrderItemEntity itemCreated = this.orderItemService.create(orderItemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemCreated);

	}
	@PutMapping("/{orderId}/items/{orderItemId}")
	public ResponseEntity<OrderItemEntity> update(@PathVariable Long orderItemId, @RequestBody OrderItemDTO orderItemDTO) {
		OrderItemEntity orderItemEntityRead = orderItemService.read(orderItemId).orElseThrow(IllegalArgumentException::new);
		BeanUtils.copyProperties(orderItemDTO, orderItemEntityRead);
		orderItemService.update(orderItemEntityRead, orderItemDTO);
		return ResponseEntity.ok(orderItemEntityRead);


	}

}

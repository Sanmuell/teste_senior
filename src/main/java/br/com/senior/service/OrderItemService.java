package br.com.senior.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.OrderItem;
import br.com.senior.model.dto.OrderItemDTO;
import br.com.senior.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	public List<OrderItem> list() {
		return orderItemRepository.findAll();

	}

	@Transactional
	public Optional<OrderItem> read(Long id) {
		return orderItemRepository.findById(id);
	}

	@Transactional
	public OrderItem create(OrderItemDTO orderItemDTO) {

		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(orderItemDTO.getOrderId());
		orderItem.setItemId(orderItemDTO.getItemId());
		orderItem.setOrderId(orderItemDTO.getOrderId());
		orderItem.setQuantity(orderItemDTO.getQuantity());

		return orderItemRepository.save(orderItem);
	}

	@Transactional
	public OrderItem update(OrderItem orderItem, OrderItemDTO orderItemDTO) {

		orderItem.setItemId(orderItemDTO.getItemId());
		orderItem.setQuantity(orderItemDTO.getQuantity());

		return orderItemRepository.save(orderItem);
	}

}

package br.com.senior.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.OrderItem;
import br.com.senior.model.dto.OrderItemDTO;
import br.com.senior.respository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	public List<OrderItem> list() {
		return orderItemRepository.findAll();

	}

	@Transactional
	public Optional<OrderItem> read(UUID id) {
		return orderItemRepository.findById(id);
	}

	@Transactional
	public OrderItem create(OrderItemDTO orderItemDTO) {

		OrderItem orderItem = new OrderItem();
		orderItem.setOderId(orderItemDTO.getOrderId());
		orderItem.setItemId(orderItemDTO.getItemId());
		orderItem.setOderId(orderItemDTO.getOrderId());
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

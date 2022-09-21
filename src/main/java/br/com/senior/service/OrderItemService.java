package br.com.senior.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.OrderItemEntity;
import br.com.senior.model.dto.OrderItemDTO;
import br.com.senior.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	public List<OrderItemEntity> list() {
		return orderItemRepository.findAll();

	}

	@Transactional
	public Optional<OrderItemEntity> read(Long id) {
		return orderItemRepository.findById(id);
	}

	@Transactional
	public OrderItemEntity create(OrderItemDTO orderItemDTO) {

		OrderItemEntity orderItemEntity = new OrderItemEntity();
		orderItemEntity.setOrderEntityId(orderItemDTO.getOrderEntityId());
		orderItemEntity.setItemEntityId(orderItemDTO.getItemEntityId());
		orderItemEntity.setOrderEntityId(orderItemDTO.getOrderEntityId());
		orderItemEntity.setQuantity(orderItemDTO.getQuantity());

		return orderItemRepository.save(orderItemEntity);
	}

	@Transactional
	public OrderItemEntity update(OrderItemEntity orderItemEntity, OrderItemDTO orderItemDTO) {

		orderItemEntity.setItemEntityId(orderItemDTO.getItemEntityId());
		orderItemEntity.setQuantity(orderItemDTO.getQuantity());

		return orderItemRepository.save(orderItemEntity);
	}

}

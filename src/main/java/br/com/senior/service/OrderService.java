package br.com.senior.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import br.com.senior.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.dto.OrderDTO;
import br.com.senior.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public List<OrderEntity> list() {
		return orderRepository.findAll();

	}

	@Transactional
	public Optional<OrderEntity> read(Long id) {
		return orderRepository.findById(id);
	}

	@Transactional
	public OrderEntity create(OrderDTO orderDTO) {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setNumber(orderDTO.getNumber());
		orderEntity.setDate(orderDTO.getDate());
		orderEntity.setPercentualDiscount(orderDTO.getPercentualDiscount());
		orderEntity.setTotalValue(orderDTO.getTotalValue());

		return orderRepository.save(orderEntity);
	}

	@Transactional
	public OrderEntity update(OrderEntity orderEntity, OrderDTO orderDTO) {

		orderEntity.setNumber(orderDTO.getNumber());
		orderEntity.setDate(orderDTO.getDate());
		orderEntity.setPercentualDiscount(orderDTO.getPercentualDiscount());
		orderEntity.setTotalValue(orderDTO.getTotalValue());

		return orderRepository.save(orderEntity);
	}

	@Transactional
	public void delete(Long orderID) {

		orderRepository.deleteById(orderID);

	}

}

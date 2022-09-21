package br.com.senior.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.Order;
import br.com.senior.model.dto.OrderDTO;
import br.com.senior.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public List<Order> list() {
		return orderRepository.findAll();

	}

	@Transactional
	public Optional<Order> read(Long id) {
		return orderRepository.findById(id);
	}

	@Transactional
	public Order create(OrderDTO orderDTO) {

		Order order = new Order();
		order.setNumber(orderDTO.getNumber());
		order.setDate(orderDTO.getDate());
		order.setPercentualDiscount(orderDTO.getPercentualDiscount());
		order.setTotalValue(orderDTO.getTotalValue());

		return orderRepository.save(order);
	}

	@Transactional
	public Order update(Order order, OrderDTO orderDTO) {

		order.setNumber(orderDTO.getNumber());
		order.setDate(orderDTO.getDate());
		order.setPercentualDiscount(orderDTO.getPercentualDiscount());
		order.setTotalValue(orderDTO.getTotalValue());

		return orderRepository.save(order);
	}

	@Transactional
	public void delete(Long orderID) {

		orderRepository.deleteById(orderID);

	}

}

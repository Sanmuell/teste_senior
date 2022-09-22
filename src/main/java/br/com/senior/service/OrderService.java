package br.com.senior.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import javax.transaction.Transactional;

import br.com.senior.model.ItemEntity;
import br.com.senior.model.OrderEntity;
import br.com.senior.model.dto.OrderItemResultDTO;
import br.com.senior.model.enums.ItemTypeEnum;
import br.com.senior.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.model.dto.OrderDTO;
import br.com.senior.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ItemService itemService;


	@Transactional
	public List<OrderEntity> list() {
		return orderRepository.findAll();

	}

	@Transactional
	public Optional<OrderEntity> read(UUID id) {
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
	public void delete(UUID orderID) {

		orderRepository.deleteById(orderID);

	}


	private Double calculateTotalValue(List<OrderItemResultDTO> itemsList, Double percentualDiscount) {
		Double orderTotalValue = 0.;

		for (OrderItemResultDTO orderItem : itemsList){

			UUID idItem = orderItem.itemId;
			ItemEntity itemEntity = itemService.read(idItem).get();

			Double itemValue = itemEntity.getValue();

			if(itemEntity.getType().equals(ItemTypeEnum.P) && percentualDiscount > 0){
				itemValue = (itemValue - (itemValue * percentualDiscount / 100)) * orderItem.quantity;
			} else {
				itemValue= itemValue * orderItem.quantity;
			}
			orderTotalValue += itemValue;
		}
		return orderTotalValue;
	}

}

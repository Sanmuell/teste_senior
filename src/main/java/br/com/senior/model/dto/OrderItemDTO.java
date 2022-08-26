package br.com.senior.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senior.model.Item;
import br.com.senior.model.Order;

public class OrderItemDTO {

	@JsonIgnore
	private Order orderId;

	private Item itemId;
	private Double quantity;

	public OrderItemDTO() {
	}

	public OrderItemDTO(Order orderId, Item itemId, Double quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;

	}

}

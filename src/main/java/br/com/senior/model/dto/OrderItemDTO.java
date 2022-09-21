package br.com.senior.model.dto;

import br.com.senior.model.Item;
import br.com.senior.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class OrderItemDTO {

	@JsonIgnore
	private Order orderId;
	private Item itemId;
	private Double quantity;



}

package br.com.senior.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senior.domain.model.Item;
import br.com.senior.domain.model.Order;
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

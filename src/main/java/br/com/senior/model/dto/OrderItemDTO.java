package br.com.senior.model.dto;

import br.com.senior.model.ItemEntity;
import br.com.senior.model.OrderEntity;
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
	private OrderEntity orderEntityId;
	private ItemEntity itemEntityId;
	private Double quantity;



}

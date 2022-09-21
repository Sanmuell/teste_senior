package br.com.senior.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {

	private Integer number;

	private Date date = new Date();

	private Double percentualDiscount;

	private Double totalValue;


}

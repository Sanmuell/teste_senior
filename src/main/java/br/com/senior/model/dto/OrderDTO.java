package br.com.senior.model.dto;

import java.util.Date;

public class OrderDTO {

	private Integer number;

	private Date date = new Date();

	private Double percentualDiscount;

	private Double totalValue;

	public OrderDTO() {
	}

	public OrderDTO(Integer number, Date date, Double percentualDiscount, Double totalValue) {
		this.number = number;
		this.date = date;
		this.percentualDiscount = percentualDiscount;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(Double percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}

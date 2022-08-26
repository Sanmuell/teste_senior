package br.com.senior.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ORDERS_TB")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private UUID orderId;

	@Column(name = "order_number")
	private Integer number;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date date = new Date();

	@Column(name = "order_disccount")
	private Double percentualDiscount;

	@Column(name = "order_total_value")
	private Double totalValue;

	public Order() {
	}

	public Order(UUID orderId, Integer number, Date date, Double percentualDiscount, Double totalValue) {
		this.orderId = orderId;
		this.number = number;
		this.date = date;
		this.percentualDiscount = percentualDiscount;
		this.totalValue = totalValue;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
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

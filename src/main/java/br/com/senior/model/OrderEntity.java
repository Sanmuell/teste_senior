package br.com.senior.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter @Getter
@Entity
@Table(name = "ORDERS_TB")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "order_number")
    private Integer number;

    @Column(name = "order_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @CreationTimestamp
    private Date date = new Date();

    @Column(name = "order_disccount")
    private Double percentualDiscount;

    @Column(name = "order_total_value")
    private Double totalValue;


    public OrderEntity(){}

    public OrderEntity(UUID orderId, Integer number, Date date, Double percentualDiscount, Double totalValue) {
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

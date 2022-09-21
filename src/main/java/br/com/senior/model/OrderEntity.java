package br.com.senior.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name = "ORDERS_TB")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

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



}

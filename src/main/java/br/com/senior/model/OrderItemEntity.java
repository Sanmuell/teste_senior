package br.com.senior.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
@Entity
@Table(name = "ORDERS_ITEMS_TB")
public class OrderItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private UUID orderItemId;

    @ManyToOne
   @JoinColumn(name = "item_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ItemEntity itemEntityId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderEntity orderEntityId;

    private Double quantity;

    private Double totalValue;


    public OrderItemEntity(){}


    public OrderItemEntity(UUID orderItemId, ItemEntity itemEntityId, OrderEntity orderEntityId, Double quantity, Double totalValue) {
        this.orderItemId = orderItemId;
        this.itemEntityId = itemEntityId;
        this.orderEntityId = orderEntityId;
        this.quantity = quantity;
        this.totalValue = totalValue;
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public ItemEntity getItemEntityId() {
        return itemEntityId;
    }

    public void setItemEntityId(ItemEntity itemEntityId) {
        this.itemEntityId = itemEntityId;
    }

    public OrderEntity getOrderEntityId() {
        return orderEntityId;
    }

    public void setOrderEntityId(OrderEntity orderEntityId) {
        this.orderEntityId = orderEntityId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}

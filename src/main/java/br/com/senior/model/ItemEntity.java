package br.com.senior.model;

import java.io.Serializable;
import java.util.UUID;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
@Entity
@Table(name = "ITEMS_TB")
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id

    @Column(name = "item_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID itemId;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_value")
    private Double value;

    @Column(name = "item_type")
    private Character type;

    public ItemEntity(){}


    public ItemEntity(UUID itemId, String description, Double value, Character type) {
        this.itemId = itemId;
        this.description = description;
        this.value = value;
        this.type = type;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }
}
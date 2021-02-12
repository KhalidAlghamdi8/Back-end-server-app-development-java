package com.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Inventory")
public class Inventory implements Serializable{
    @Id
    @NotNull (message = " the product must not be null")
    private String product_id;
    @Column(name="AVAILABLE")
    @Min (value =0,message = "the Inventory quantity must be greater then or equal to 0")
    private int quantity_on_hand;

    public Inventory(String product_id, int quantity_on_hand) {
        this.product_id = product_id;
        this.quantity_on_hand = quantity_on_hand;
    }
    public Inventory (){}
    public void add(int quantity) {
        quantity_on_hand += quantity;
    }
    
    public boolean subtract(int quantity) {
        if (quantity_on_hand - quantity >= 0) {
            quantity_on_hand -= quantity;
            return true;
        } else {
            return false;
        }
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }
    
}

package com.example.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product implements Serializable{
    @Id
    @NotNull (message = "the id must be not null")
    @Size (min =1,message = "the product id cant be null")
    private String product_id;
    
    @NotNull (message = "the prodect must be not null")
    @Size (min =10,message = "the product name must be at least 10 char")
    private String prod_name;
    
    @Min (value = 5,message = "the price fiald must be grater than 5")
    private double price;
    private String prod_desc;

    public Product (){}
    public Product(String id, String name, double price, String description) {
        this.product_id = id;
        this.prod_name = name;
        this.price = price;
        this.prod_desc = description;
    }

    public String getId() {
        return product_id;
    }

    public String getName() {
        return prod_name;
    }

    public void setName(String name) {
        this.prod_name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return prod_desc;
    }

    public void setDescription(String description) {
        this.prod_desc = description;
    }
    
    @Override
    public String toString() {
        String s = String.format("Product id: %s\n"
        + "Name: %s\n"
        + "Description: %s\n"
        + "Price: $%.2f", product_id, prod_name, prod_desc, price);
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.product_id);
        hash = 97 * hash + Objects.hashCode(this.prod_name);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.prod_desc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.product_id, other.product_id)) {
            return false;
        }
        if (!Objects.equals(this.prod_name, other.prod_name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.prod_desc, other.prod_desc)) {
            return false;
        }
        return true;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
}

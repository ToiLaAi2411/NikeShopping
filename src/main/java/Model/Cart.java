/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author DUY
 */
public class Cart {
    private Products products;
    private int quantity;
    private Date addAt; 

    public Cart() {
    }

    public Cart(Products products, int quantity, Date addAt) {
        this.products = products;
        this.quantity = quantity;
        this.addAt = addAt;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getAddAt() {
        return addAt;
    }

    public void setAddAt(Date addAt) {
        this.addAt = addAt;
    }

    @Override
    public String toString() {
        return "Cart{" + "products=" + products + ", quantity=" + quantity + ", addAt=" + addAt + '}';
    }

    
    
    

    
    
    
    
    
}

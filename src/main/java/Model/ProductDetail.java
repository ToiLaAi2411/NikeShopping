/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DUY
 */
public class ProductDetail {
    private int productDetail_id;
    private int product_id;
    private int stock;
    private int size_value;
    private int size_id;

    public ProductDetail() {
    }

    public ProductDetail(int productDetail_id, int stock, int size_value) {
        this.productDetail_id = productDetail_id;
        this.stock = stock;
        this.size_value = size_value;
    }

    public ProductDetail(int productDetail_id, int product_id, int stock, int size_value, int size_id) {
        this.productDetail_id = productDetail_id;
        this.product_id = product_id;
        this.stock = stock;
        this.size_value = size_value;
        this.size_id = size_id;
    }

    public int getProductDetail_id() {
        return productDetail_id;
    }

    public void setProductDetail_id(int productDetail_id) {
        this.productDetail_id = productDetail_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSize_value() {
        return size_value;
    }

    public void setSize_value(int size_value) {
        this.size_value = size_value;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "productDetail_id=" + productDetail_id + ", product_id=" + product_id + ", stock=" + stock + ", size_value=" + size_value + ", size_id=" + size_id + '}';
    }
    
    
    
    
}

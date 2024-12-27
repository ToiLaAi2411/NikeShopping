/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DUY
 */
public class Products {
    private int productID;
    private String productName;
    private String description;
    private double price;
    private int categoryID;
    private String imgUrl;
    private String date;

    public Products() {
    }

    public Products(int productID, String productName, String description, double price, int categoryID, String imgUrl, String date) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Products{" + "productID=" + productID + ", productName=" + productName + ", description=" 
                + description + ", price=" + price +", categoryID=" + categoryID + ", imgUrl=" + imgUrl 
                + ", date=" + date + '}';
    }
    
    
    
    
}

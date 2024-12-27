/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.ProductDetail;
import Model.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUY
 */
public class ProductsDAO {
     Connection conn = null;
     PreparedStatement pt = null;
     ResultSet rs = null;
     
     public List<Products> getAllProducts(){
         String SQLQuery = "SELECT * FROM Product";
         List<Products> listProduct = new ArrayList<>();
         try {
             conn = new DBContext().getConnection();
             pt = conn.prepareStatement(SQLQuery);
             rs = pt.executeQuery();
             
             while(rs.next()){
                 int productID = rs.getInt("product_id");
                 String productName = rs.getString("product_name");
                 String description = rs.getString("description");
                 double price = rs.getDouble("price");
                 int categoryID = rs.getInt("category_id");
                 String imgUrl = rs.getString("image_url");
                 String date = null;
                 
                 Products product = new Products(productID, productName, description, price, categoryID, imgUrl, date);
                 listProduct.add(product);
             }
             
             if(listProduct.size() > 0){
                 System.out.println("select all product done");
             }
         } catch (Exception e) {
             System.out.println("error in method getAllProducts " + e.getMessage());
         }
         return listProduct;
     }
     
     public List<Products> getProductByCategory(int cateID){
         String SQLQuery = "select * from Product where category_id = ?";
         List<Products> listP = new ArrayList<>();
         try {
             conn = new DBContext().getConnection();
             pt = conn.prepareStatement(SQLQuery);
             pt.setInt(1, cateID);
             rs = pt.executeQuery();
             
             while (rs.next()) {     
                 int productID = rs.getInt("product_id");
                 String productName = rs.getString("product_name");
                 String description = rs.getString("description");
                 double price = rs.getDouble("price");
                 int categoryID = rs.getInt("category_id");
                 String imgUrl = rs.getString("image_url");
                 String date = null;
                 
                 Products product = new Products(productID, productName, description, price, categoryID, imgUrl, date);
                 listP.add(product);
                 
             }
         } catch (Exception e) {
             System.out.println("error 1 " + e.getMessage());
         }
         
         return listP;
     }
     
     public Products getProductByID(int productID){
         String SQlQuery = "SELECT * FROM  Product WHERE product_id = ?";
         Products product = null;
         
         try {
             conn = new DBContext().getConnection();
             pt = conn.prepareStatement(SQlQuery);
             pt.setInt(1, productID);
             rs = pt.executeQuery();
             if(rs.next()){
                 int productIDs = rs.getInt("product_id");
                 String productName = rs.getString("product_name");
                 String description = rs.getString("description");
                 double price = rs.getDouble("price");
                 int categoryID = rs.getInt("category_id");
                 String imgUrl = rs.getString("image_url");
                 String date = null;
                 
                 product = new Products(productIDs, productName, description, price,categoryID, imgUrl, date);
                 System.out.println("select product by id done");
             }
         } catch (Exception e) {
             System.out.println("error in method getProductByID " + e.getMessage());
         }
         return product;
     }
     
     
     public List<ProductDetail> getProductDetail(int productID){
         String SQLQuery = "SELECT PRODUCTDETAIL_ID, STOCK, SIZE.SIZE_VALUE\n" +
                           "FROM PRODUCTDETAIL AS PRD\n" +
                           "INNER JOIN SIZE AS SIZE ON SIZE.SIZE_ID = PRD.SIZE_ID\n" +
                           "WHERE PRODUCT_ID = ?";
         List<ProductDetail> listProductDetail = new ArrayList<>();
         
         try {
             conn = new DBContext().getConnection();
             pt = conn.prepareStatement(SQLQuery);
             pt.setInt(1, productID);
             rs = pt.executeQuery();
             
             while (rs.next()) {      
                 ProductDetail productDT = new ProductDetail(rs.getInt("productDetail_id"), rs.getInt("stock"), rs.getInt("Size_Value"));
                 listProductDetail.add(productDT);      
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return listProductDetail;
     }
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Cart;
import Model.Products;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUY
 */
public class CartaDAO {

    Connection conn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public int getCartID(int userID) {
        String SQLQuery = "SELECT cart_id \n"
                + "FROM cart\n"
                + "WHERE user_id  = ?";
        int userIDtoReturn = 0;
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, userID);
            rs = pt.executeQuery();

            if (rs.next()) {
                userIDtoReturn = rs.getInt(1);
                System.out.println("select cartID done");
            }
        } catch (Exception e) {
            System.out.println("error in method getCartID " + e.getMessage());
        }
        return userIDtoReturn;
    }

    public List<Cart> getCartByUserID(int userID) {
        String SQLQuery = "SELECT * \n"
                + "FROM cartDetatail\n"
                + "WHERE cart_id  = (SELECT cart_id FROM cart WHERE user_id = ?) ";
        List<Cart> listCart = new ArrayList<>();

        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, userID);
            rs = pt.executeQuery();
            ProductsDAO prd = new ProductsDAO();

            while (rs.next()) {

                int productID = rs.getInt(2);
                int quantity = rs.getInt(3);
                Date date = rs.getDate(4);

                Products productIncart = prd.getProductByID(productID);

                Cart cart = new Cart(productIncart, quantity, date);
                listCart.add(cart);

            }

        } catch (Exception e) {
            System.out.println("error in method getCartByUserID " + e.getMessage());
        }
        return listCart;

    }

    public List<Cart> getCartByCartID(int cartID) {
        String SQLQuery = "SELECT * \n"
                + "FROM cartDetatail\n"
                + "WHERE cart_id  = ?";
        List<Cart> listCart = new ArrayList<>();

        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, cartID);
            rs = pt.executeQuery();
            ProductsDAO prd = new ProductsDAO();

            while (rs.next()) {

                int productID = rs.getInt(2);
                int quantity = rs.getInt(3);
                Date date = rs.getDate(4);

                Products productIncart = prd.getProductByID(productID);

                Cart cart = new Cart(productIncart, quantity, date);
                listCart.add(cart);

            }

        } catch (Exception e) {
            System.out.println("error in method getCartByUserID " + e.getMessage());
        }
        return listCart;

    }
    
    
    public boolean createCart(int userID){
        String SQLQuery = "INSERT INTO cart (user_id)\n" +
                          "VALUES (?)";
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, userID);
            
            int rowEffect = pt.executeUpdate();
            if(rowEffect > 0){
                System.out.println("create cart done");
                return true;
            }
        } catch (Exception e) {
            System.out.println("error in method createCart " + e.getMessage());
        }
        return false;
    }
    
    
    public boolean checkExixtsProduct(int productID, int cartID){
        String SQLQuery = "SELECT product_id "
                         + "FROM cartDetatail "
                         + "WHERE cart_id = ? AND product_id = ?";
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, cartID);
            pt.setInt(2, productID);
            rs = pt.executeQuery();
            
            if(rs.next()){
                System.out.println("Yes");
                return true;
            }
        } catch (Exception e) {
            System.out.println("error in method checkExixtsProduct " + e.getMessage());
        }
        return false;
    }
    
    
    public boolean addNew(int cartID, int productID, int quantity ,Date date){
         String SQLQuery1 = "INSERT INTO cartDetatail (cart_id,product_id,quantity,add_at)\n" +
                            "VALUES (?,?,?,?)";
         
         try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery1);
                 pt.setInt(1, cartID);
                 pt.setInt(2, productID);
                 pt.setInt(3, quantity);
                 pt.setDate(4, date);
                 if(pt.executeUpdate()> 0){
                     return true;
                 }
        } catch (Exception e) {
             System.out.println("error 1 " + e.getMessage());
        }
         return false;
    }
    
    public boolean updateQuantity(int cartID, int productID, int quantity){
         String SQLQuery2 = "UPDATE cartDetatail\n" +
                           "SET quantity = quantity + ?\n" +
                           "WHERE cart_id = ? AND product_id = ?";
         
         try {
             conn = new DBContext().getConnection();
             pt = conn.prepareStatement(SQLQuery2);
             pt.setInt(1, quantity);
             pt.setInt(2, cartID);
             pt.setInt(3, productID);
             
             if(pt.executeUpdate() > 0){
                 return true;
             }            
        } catch (Exception e) {
             System.out.println("error in method2 " + e.getMessage());
        }
        return false;
    }
    
    public boolean addToCart(int cartID, int productID, int quantity ,Date date){ 
        try {      
            //if product existed in cartDetail then update quantity for it following cartID and productID
            if(checkExixtsProduct(productID, cartID)){
                boolean b1 = updateQuantity(cartID, productID, quantity);
                if(b1){
                    System.out.println("b1 done");
                }    
            }else{  //if product does not in cartDetail then add new product
               boolean b2 = addNew(cartID, productID, quantity, date);
               if(b2){
                   System.out.println("b2 done");
               }
            }
            return true;
        } catch (Exception e) {
            System.out.println("error c1 " + e.getMessage());
        }
        return false;
    }
    
    public boolean removeProduct(int cartID, int productID){
        String SQLQuery = "Delete cartDetatail \n" +
                          "WHERE cart_id = ? AND product_id = ?";
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setInt(1, cartID);
            pt.setInt(2, productID);
        } catch (Exception e) {
        }
        return false;
    }

}

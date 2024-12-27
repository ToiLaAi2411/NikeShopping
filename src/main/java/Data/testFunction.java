/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Cart;
import Model.Categories;
import Model.ProductDetail;
import Model.Products;
import Model.User;
import Utils.MD5Encoding;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUY
 */
public class testFunction {
    public static void main(String[] args) {
        UserDAO temp = new UserDAO();   
        ProductsDAO prd = new ProductsDAO();
        CategoryDAO ctd = new CategoryDAO();
        CartaDAO crt = new CartaDAO();
//        Date date = new Date();
//        crt.addToCart(8, 2, 1, null);


        
//      List<ProductDetail> lt = prd.getProductDetail(1);
//        for (ProductDetail productDetail : lt) {
//            System.out.println(productDetail);
//            
//        }

Products pr = prd.getProductByID(1);
        System.out.println(pr.toString());
        
//        
//        for (Cart cart : lt) {
//            System.out.println(cart.toString());
//        }
        
        
        
        
//    User user = temp.getUser("john_doe", "Password123!");
//    temp.createUser(user);
    
//    String encode = "anhduy2411";
//        MD5Encoding temps = new MD5Encoding();
//        encode = temps.md5(encode);
//        System.out.println(encode);
//        System.out.println(user.toString());

//temp.changePassword("john_doe", "241104");
    }
    
   
            
    
}

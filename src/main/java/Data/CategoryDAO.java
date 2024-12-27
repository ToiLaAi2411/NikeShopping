/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUY
 */
public class CategoryDAO {
    Connection conn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    
    public List<Categories> getAllCate(){
        String SQLQuery = "SELECT * FROM Category";
        List<Categories> listCate = new ArrayList<>();
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            rs = pt.executeQuery();
            
            while (rs.next()) {                
                int categoryID = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                
                Categories cate = new Categories(categoryID, categoryName);
                listCate.add(cate);
            }
            
            if(listCate.size() > 0){
                System.out.println("select category done");
            }
        } catch (Exception e) {
            System.out.println("error in method getAllCate()");
        }
        
        return listCate;
    }
   
}

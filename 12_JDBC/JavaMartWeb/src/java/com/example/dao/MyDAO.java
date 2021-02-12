/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.sql.DataSource;

/**
 *
 * @author khali
 */
@Model
public class MyDAO {
    
    @Resource(lookup = "jdbc/mySql")
    private DataSource ds;
    
    public Product getProductById (String prodId){
    Product prod = null;
    
       
        try {
            Connection con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product where Product_ID = '"+ prodId+"'");
            rs.next();
            String id = rs.getString("Product_Id");
           String name = rs.getString("Prod_Name");
           String desc = rs.getString("Prod_Desc");
           double  price = rs.getDouble("Price");
           
           prod = new Product (id,name,price,desc);
           
        } catch (SQLException ex) {
            Logger.getLogger(MyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return prod;
    
    
    }
}

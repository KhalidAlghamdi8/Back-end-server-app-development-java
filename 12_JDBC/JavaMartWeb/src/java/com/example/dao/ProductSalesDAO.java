package com.example.dao;

import com.example.model.ProductSales;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

@Model
public class ProductSalesDAO implements Serializable {

//@Resource (lookup = "jdbc/mySql")
//private  DataSource dataSource;
   @PersistenceContext
    private EntityManager em;

    public void addProductSalesRecord(ProductSales salesRecord) throws SQLException {
//try (Connection conn = dataSource.getConnection()){
//PreparedStatement ps = conn.prepareCall(" INSERT INTO ProductSales VALUES (?,?,?)");
//ps.setInt(1, salesRecord.getSales_id());
//ps.setString(2, salesRecord.getProduct_id());
//ps.setInt(3, salesRecord.getQuantity_sold());
//ps.executeUpdate(); 
//}
        em.persist(salesRecord);
    }

    public List<ProductSales> getProductSalesBySalesID(int sales_ID) throws SQLException {
//        List<ProductSales> pSales = new ArrayList<>();
//        try (Connection conn = dataSource.getConnection()) {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT p from ProductSales p WHERE p.sales_id =" + sales_ID);
//            while (rs.next()) {
//                int sales_id = rs.getInt("Sales_ID");
//                String product_id = rs.getString("Prodect_ID");
//                int quantity_sold = rs.getInt("Quantity");
//                pSales.add(new ProductSales(sales_id, product_id, quantity_sold));
//        
//    }
//}


        String queryString = " SELECT p from ProductSales p WHERE p.sales_id =" + sales_ID;
        TypedQuery<ProductSales> query = em.createQuery(queryString,ProductSales.class);
        List<ProductSales> pSales = query.getResultList();
        return pSales;
    }
}

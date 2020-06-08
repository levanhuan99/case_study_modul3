package dao;

import DBConnection.DBConnection;
import model.Product;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private DBConnection dbconnection;

    private static final String SELECT_ALL_PRODUCTS="select * from product";


    public ProductDAO(DBConnection dbConnection) {
        this.dbconnection=dbConnection;

    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list=new ArrayList<>();
        try {
            Statement statement=dbconnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(SELECT_ALL_PRODUCTS);
            while (resultSet.next()){
                String name=resultSet.getString("name");
                float price=resultSet.getFloat("price");
                String description=resultSet.getString("description");
                String image=resultSet.getString("image");
                int amount=resultSet.getInt("amount");
                list.add(new Product(name,price,description,image,amount));
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



}

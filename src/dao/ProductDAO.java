package dao;

import DBConnection.DBConnection;
import model.Product;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private DBConnection dbconnection;

    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String SELECT_PRODUCT = "select * from product where id= ?";
    private static final String INSERT_Product = "insert into product values (?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT = "update product set name = ?,price= ?, description =?,image=?,amount=? where id = ?;";


    public ProductDAO(DBConnection dbConnection) {
        this.dbconnection = dbConnection;

    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            Statement statement = dbconnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int amount = resultSet.getInt("amount");
                list.add(new Product(id, name, price, description, image, amount));
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findProductById(int idPara) {
        Product product = null;
        PreparedStatement statement = null;
        try {
            statement = dbconnection.getConnection().prepareStatement(SELECT_PRODUCT);
            statement.setInt(1, idPara);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int amount = resultSet.getInt("amount");
                product = new Product(id, name, price, description, image, amount);

            }
            return product;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(INSERT_Product);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getAmount());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(int id) {
        try {
            PreparedStatement statement = dbconnection.getConnection().prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {

        try {
            PreparedStatement statement = dbconnection.getConnection().prepareStatement(UPDATE_PRODUCT);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getImage());
            statement.setInt(5,product.getAmount());
            statement.setInt(6,product.getId());
            statement.executeUpdate();
            //update product set name = ?,price= ?, description =?,image=?,amount=? where id = ?;";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}

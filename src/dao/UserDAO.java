package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/demo";
    private String account = "root";
    private String password = "123456";

    private static final String SELECT_ALL_USERS="select * from user";

    public UserDAO() {
        getConnection();
    }

    protected Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, account, password);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }


    @Override
    public List<User> allUser() {
List<User> users=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String account=resultSet.getString("account");
                String password=resultSet.getString("password");
                String email =resultSet.getString("email");
                String phone=resultSet.getString("phone");
                User newUser=new User(account,password,email,phone);
                users.add(newUser);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}

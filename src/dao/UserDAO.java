package dao;

import DBConnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private static final String SELECT_ALL_USER = "select * from user";
    private static final String SELECT_USER = "select * from user where account = ?";
    private DBConnection connection;

    public UserDAO(DBConnection connection) {
        this.connection = connection;
    }


    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                list.add(new User(id, account, password, email, phone));

            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser() {
        User user=null;
        try {
            PreparedStatement statement=connection.getConnection().prepareStatement(SELECT_USER);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String account=resultSet.getString("account");
                String password=resultSet.getString("password");
                String email=resultSet.getString("phone");
                String phone=resultSet.getString("phone");
                 user=new User(id,account,password,email,phone);
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

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
    private static final String INSERT_USER = "insert into user(account, password, email, phone) values (?,?,?,?)";
    private static final String SELECT_USER_BY_ID =  "select * from user where id = ?";
    private static final String UPDATE_USER  =  "update user set account= ?, password =? ,email=?,phone=? where id=?";
    private static final String SELECT_USER_BY_EMAIL  = "select * from user where email = ?";


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
    public User getUser(String userName) {
        User user = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_USER);
            statement.setString(1,userName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                user = new User(id, account, password, email, phone);
            }
            return user;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_USER);
            statement.setString(1,user.getAccount());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPhone());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getUserByID(int id) {
        User user=null;
        try {
            PreparedStatement statement=connection.getConnection().prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String account=resultSet.getString("account");
                String password=resultSet.getString("password");
                String email=resultSet.getString("email");
                String phone=resultSet.getString("email");
                user=new User(id,account,password,email,phone);

            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement statement=connection.getConnection().prepareStatement(UPDATE_USER);
            statement.setString(1,user.getAccount());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPhone());
            statement.setInt(5,user.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            PreparedStatement statement=connection.getConnection().prepareStatement(SELECT_USER_BY_EMAIL);
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            User user=null;
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String account=resultSet.getString("account");
                String password=resultSet.getString("password");
                String email1=resultSet.getString("email");
                String phone=resultSet.getString("phone");
                user=new User(id,account,password,email1,phone);
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}

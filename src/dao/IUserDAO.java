package dao;

import model.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();

    User getUser(String account);

    void addUser(User user);

    User getUserByID(int id);

    void  updateUser(User user);


}

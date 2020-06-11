package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private User customer;
    List<CartItem> cartItemList ;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<CartItem> getCartItemList() {
        return this.cartItemList;
    }
}

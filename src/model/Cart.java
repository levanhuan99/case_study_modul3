package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> cartItemList = new ArrayList<>();

    public void addItem(CartItem item) {
        for (CartItem newItem : cartItemList) {
            int id = newItem.getProduct().getId();
            if (id == item.getProduct().getId()) {
                increaseQuantityByProductID(id);
            }
        }
    }

    private void increaseQuantityByProductID(int id) {
        for (CartItem item : cartItemList) {
            if (id == item.getProduct().getId()) {
                item.setQuantity(item.getQuantity() + 1);
            }
        }
    }

    public List<CartItem> getCartItemList() {
        return this.cartItemList;
    }
}

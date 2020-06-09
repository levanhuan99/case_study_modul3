package dao;

import model.Product;
import model.User;

import java.util.List;

public interface IProductDAO {

    List<Product> getAllProduct();

    Product findProductById(int id);

    void  addProduct(Product product);

    void deleteProductById(int id);

    void  updateProduct(Product product);
}

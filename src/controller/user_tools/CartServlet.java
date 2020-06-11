package controller.user_tools;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.IUserDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Cart;
import model.CartItem;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.catalog.Catalog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/AddToCart")
public class CartServlet extends HttpServlet {
    IProductDAO productDAO;
    IUserDAO userDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO(dbConnection);
        userDAO=new UserDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> productList=productDAO.getAllProduct();       //đoạn này để hiển thị lại phần product
        request.setAttribute("productList",productList);
        Object o=session.getAttribute("user");

        User user=(User) o;
        request.setAttribute("customer2",user);

        int userId=user.getId();
        int quantity = 1;

        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDAO.findProductById(productId);

        if (session.getAttribute("cart") == null) {
            Cart cart = new Cart();
            List<CartItem> cartItemList = new ArrayList<>();
            CartItem item = new CartItem();
            item.setQuantity(1);
            item.setProduct(product);
            item.setPrice(product.getPrice());
            cartItemList.add(item);
            cart.setCartItemList(cartItemList);
            session.setAttribute("cart", cart);
        } else {
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> itemList = cart.getCartItemList();
            boolean check = false;
            for (CartItem item : itemList) {
                if (item.getProduct().getId() == product.getId()) {
                    item.setQuantity((item.getQuantity() + quantity));
                    check = true;
                }
            }
            if (check == false) {
                CartItem item = new CartItem();
                item.setQuantity(quantity);
                item.setProduct(product);
                item.setPrice(product.getPrice());
                itemList.add(item);
            }
            session.setAttribute("cart", cart);
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/user_page/user_display_form_again.jsp");
        dispatcher.forward(request,response);
    }
}



















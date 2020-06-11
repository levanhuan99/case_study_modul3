package controller.user_tools;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.ProductDAO;
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
import java.io.IOException;

@WebServlet(name = "CartCotrollerServlet", urlPatterns = "/CartController")
public class CartControllerServlet extends HttpServlet {
    IProductDAO productDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session=request.getSession();

        Object o=session.getAttribute("user");
        User user=(User) o;
        request.setAttribute("user4",user);

        Object o1=session.getAttribute("cart");
        Cart cart=(Cart) o1;
        request.setAttribute("productAddToCart",cart);

        if (action.equals("cart")){
            RequestDispatcher dispatcher=request.getRequestDispatcher("home/user_page/cart.jsp");
            dispatcher.forward(request,response);
        }


    }
}

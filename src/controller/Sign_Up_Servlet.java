package controller;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.ProductDAO;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Sign_Up_Servlet", urlPatterns = "/sign_up")
public class Sign_Up_Servlet extends HttpServlet {

    private DBConnection dbConnection=DBConnection.getInstance();
    private ProductDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO=new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("sign_up")) {
            //TODO
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("sign_up")) {
            showSign_Upform(request, response);
        }
    }


    private void showSign_Upform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/sign_up_form.jsp");
        dispatcher.forward(request, response);
    }
}

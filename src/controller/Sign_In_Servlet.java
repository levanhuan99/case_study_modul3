package controller;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sign_In_Servlet",urlPatterns = "/sign_in")
public class Sign_In_Servlet extends HttpServlet {

    private DBConnection dbConnection=DBConnection.getInstance();

    private IProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO=new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action.equals("sign_in")){
            showSign_InFom(request,response);
        }
    }
    private void showSign_InFom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/sign_in_form.jsp");
        dispatcher.forward(request,response);

    }
}

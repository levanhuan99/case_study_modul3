package controller.admin_tools;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminEditServlet",urlPatterns = "/Edit")
public class AdminEditServlet extends HttpServlet {
    IProductDAO productDAO;
    DBConnection dbConnection=DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO=new ProductDAO(dbConnection);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher=request.getRequestDispatcher("home/admin_page/admin_edit_form.jsp");
        dispatcher.forward(request,response);
    }
}

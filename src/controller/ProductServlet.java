package controller;

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
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/home_page")
public class ProductServlet extends HttpServlet {
    private DBConnection connection = DBConnection.getInstance();

    IProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO=new ProductDAO(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "result_search":
                showResult(request,response);
                break;
        }

    }

    private void showResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        String nameSearch = request.getParameter("search");
        list = productDAO.selectProductByName(nameSearch);
        request.setAttribute("search_list", list);
        RequestDispatcher dispatcher;
        if (list.size() == 0) {
            dispatcher = request.getRequestDispatcher("/...thong bao khong tim thay hang");
            dispatcher.forward(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("home/user_page/product_search.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list=productDAO.getAllProduct();
        request.setAttribute("products",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home/home page.jsp");
        dispatcher.forward(request, response);
    }
}

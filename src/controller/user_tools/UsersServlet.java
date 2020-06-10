package controller.user_tools;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsersServlet", urlPatterns = "/User")
public class UsersServlet extends HttpServlet {

    IProductDAO productDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO=new ProductDAO(dbConnection);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "search":
                showResult(request,response);
                break;
        }

    }

    private void showResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> list=new ArrayList<>();
        request.setAttribute("search_list",list);
        String nameSearch=request.getParameter("search");
       list=productDAO.selectProductByName(nameSearch);
        RequestDispatcher dispatcher;
       if (list.size()==0){
           dispatcher=request.getRequestDispatcher("/...thong bao khong tim thay hang");
       }
       else {
           dispatcher=request.getRequestDispatcher("home/user_page/product_search.jsp");
       }
       dispatcher.forward(request,response);
    }
}

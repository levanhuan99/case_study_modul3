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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet {

    IProductDAO productDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter printWriter;
        if (id == productDAO.findProductById(id).getId()) {
            productDAO.deleteProductById(id);
            printWriter = response.getWriter();
            printWriter.write("đã xóa sản phẩm id= " + id);
        } else {
            printWriter = response.getWriter();
            printWriter.write("không có sản phẩm với id= " + id);
        }

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String image = request.getParameter("image");
        Product product = new Product(id, name, price, description, image, amount);
        productDAO.addProduct(product);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "display":
                displayAllProduct(request, response);
                break;
            case "delete":
                showAlertDelete(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                break;

        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/admin_page/edit_form.jsp");
        dispatcher.forward(request,response);
    }

    private void showAlertDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/admin_page/delete_form.jsp");
        dispatcher.forward(request, response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productDAO.getAllProduct();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/admin_page/display_form.jsp");
        dispatcher.forward(request, response);

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/admin_page/add_form.jsp");
        dispatcher.forward(request, response);
    }
}

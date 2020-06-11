package controller.user_tools;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.IUserDAO;
import dao.ProductDAO;
import dao.UserDAO;
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

@WebServlet(name = "UsersServlet", urlPatterns = "/User")
public class UsersServlet extends HttpServlet {

    IProductDAO productDAO;
    DBConnection dbConnection = DBConnection.getInstance();
    IUserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO(dbConnection);
        userDAO=new UserDAO(dbConnection);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showResult(request, response);
                break;
            case "show_detail":
                showDetail(request,response);
                break;
            case "check_password":
                checkPassword(request,response);
                break;
        }
    }

    private void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        int id=Integer.parseInt(request.getParameter("idToCheck"));
        User user=userDAO.getUserByID(id);
        String rePass=user.getPassword();
        RequestDispatcher dispatcher;
        if (password.equals(user.getPassword())){
            request.setAttribute("accountInfor",user);
             dispatcher=request.getRequestDispatcher("home/user_page/account_information.jsp");
            dispatcher.forward(request,response);
        }else {
            dispatcher=request.getRequestDispatcher("");//TODO nếu sai mật khẩu thì đi đến trang j đấy
            dispatcher.forward(request,response);
        }


    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=productDAO.findProductById(id);
        request.setAttribute("product2",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/user_page/product_detail.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";

        }
        switch (action){
            case "customer_information":
                showCustomerInfor(request,response);
                break;
            case "account":
                checkPasswordForm(request,response);

                break;
            case "edit_user_information":
                showEditUserForm(request,response);
                break;
            case "cart":
                break;
            default:
                break;
        }
    }

    private void checkPasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("customerID"));
        User user=userDAO.getUserByID(id);
        request.setAttribute("informationToCheck",user);

        RequestDispatcher dispatcher=request.getRequestDispatcher("home/user_page/check_password_form.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditUserForm(HttpServletRequest request, HttpServletResponse response) {
        //TODO đang làm phần sửa thông tin user,cần xác minh mật khẩu trước khi click vào tài khoản

    }

    private void showCustomerInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("customerID"));
        User user=userDAO.getUserByID(id);
        request.setAttribute("userInfor",user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/user_page/user_information.jsp");
        dispatcher.forward(request,response);
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
}

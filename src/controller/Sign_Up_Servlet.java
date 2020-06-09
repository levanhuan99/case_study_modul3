package controller;

import DBConnection.DBConnection;
import dao.ProductDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sign_Up_Servlet", urlPatterns = "/sign_up")
public class Sign_Up_Servlet extends HttpServlet {

    private DBConnection dbConnection=DBConnection.getInstance();

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO=new UserDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user=null;
        if (action.equals("sign_up")) {
            String accountName=request.getParameter("account");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String phone=String.valueOf(request.getParameter("phone"));
            user=new User(1,accountName,password,email,phone);
            userDAO.addUser(user);
            response.sendRedirect("/home_page");//có thể làm thêm phần gửi mail để xác nhận
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

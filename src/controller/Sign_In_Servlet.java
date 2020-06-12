package controller;

import DBConnection.DBConnection;
import dao.IProductDAO;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Sign_In_Servlet", urlPatterns = "/sign_in")
public class Sign_In_Servlet extends HttpServlet {

    private DBConnection dbConnection = DBConnection.getInstance();

    private UserDAO userDAO;

    private IProductDAO productDAO;


    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(dbConnection);
        productDAO=new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action.equals("sign_in")){
            String account = request.getParameter("userName");
            String password = request.getParameter("password");

            List<Product> list=productDAO.getAllProduct();
            request.setAttribute("list",list);

            HttpSession session = request.getSession();
            Object o = session.getAttribute("USER_IS_LOGGINNED");


                User user = userDAO.getUser(account);
                request.setAttribute("user2",user);
                if (user.getAccount().equals(account) && user.getPassword().equals(password) && user.getId() == 1) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home/admin_page/display_form.jsp");
                    dispatcher.forward(request, response);

                } else if (user.getAccount().equals(account) && user.getPassword().equals(password)&& user.getId()>1) {
                    session.setAttribute("USER_IS_LOGGINNED", true);
                    session.setAttribute("roleUser", user.getId());
                    session.setAttribute("user", user);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("home/user_page/user_display_form.jsp");//TODO làm phần loggin của user
                    dispatcher.forward(request, response);
                }else {
                PrintWriter writer = response.getWriter();
                writer.write("banj chuwa dang xuat");//TODO cần làm thêm trang thông báo phần trang khi đã đang nhập

                }
            }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("sign_in")) {
            showSign_InFom(request, response);
        }
    }

    private void showSign_InFom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/sign_in_form.jsp");
        dispatcher.forward(request, response);

    }
}

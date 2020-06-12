import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.IUserDAO;
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

@WebServlet(name = "ForgotPassword_Servlet", urlPatterns = "/Password")
public class ForgotPassword_Servlet extends HttpServlet {
    IUserDAO userDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("get_pass")) {
            sendPasswordToBack(request, response);
        }

    }

    private void sendPasswordToBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=request.getParameter("email");
        User user = userDAO.getUserByEmail(email);
        request.setAttribute("password",user);

        if (user!=null){
            RequestDispatcher dispatcher=request.getRequestDispatcher("home/return_password.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("get_password")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home/forgot_password_form.jsp");
            dispatcher.forward(request, response);
        }
    }
}

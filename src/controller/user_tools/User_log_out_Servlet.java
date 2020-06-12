package controller.user_tools;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "User_log_out_Servlet", urlPatterns = "/Log_out")
public class User_log_out_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object o=request.getSession();
        HttpSession session=request.getSession();
        String action = request.getParameter("action");
        if (action.equals("log_out")) {
            session.setAttribute("USER_IS_LOGGINNED", null);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home/sign_in_form.jsp");
            dispatcher.forward(request, response);
        }
    }
}

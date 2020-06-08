package controller;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Sign_Up_Servlet",urlPatterns = "/sign_up")
public class Sign_Up_Servlet extends HttpServlet {

    private IUserDAO userDAO=new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "sign_in":
                sign_in(request,response);
                break;

        }
    }

    private void sign_in(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> list=userDAO.allUser();
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        for (int i=0;i<list.size();i++){
            if (account.equals(list.get(i).getAccount()) && password.equals(list.get(i).getPassword())){
                response.sendRedirect("/home_page");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "sign_up":
                showSign_Upform(request,response);
                break;
            case "sign_in":
                showSign_InFom(request,response);
                break;
        }
    }

    private void showSign_InFom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/sign_in_form.jsp");
        dispatcher.forward(request,response);

    }

    private void showSign_Upform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("home/sign_up_form.jsp");
        dispatcher.forward(request,response);
    }
}

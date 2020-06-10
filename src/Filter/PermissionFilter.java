package Filter;

import DBConnection.DBConnection;
import dao.IProductDAO;
import dao.IUserDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "PermissionFilter")//sửa chưa để url của phần lọc,chưa làm được
public class PermissionFilter implements Filter {


    DBConnection dbConnection = DBConnection.getInstance();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object o = session.getAttribute("roleUser");

        if (o != null) {

            int role = Integer.parseInt(o.toString());
            if (role > 1) {
                chain.doFilter(req, resp);
            }
        }else{
            RequestDispatcher dispatcher=req.getRequestDispatcher("home/sign_in_form.jsp");
            dispatcher.forward(request,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }
}

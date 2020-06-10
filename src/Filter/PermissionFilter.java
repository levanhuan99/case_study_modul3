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
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "PermissionFilter",urlPatterns = "/sign_in")
public class PermissionFilter implements Filter {

    IUserDAO userDAO;
     DBConnection dbConnection=DBConnection.getInstance();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session=request.getSession();
        Object o=session.getAttribute("roleUser");



        userDAO=new UserDAO(dbConnection);
        if (o!=null){
            int role=Integer.parseInt(o.toString());
            List<User> list=new ArrayList<>();
            list=userDAO.getAllUser();
            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i).getId()>1){
                    chain.doFilter(req,resp);
                }
            }
        }else {
            RequestDispatcher dispatcher=req.getRequestDispatcher("home_page");
            dispatcher.forward(request,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

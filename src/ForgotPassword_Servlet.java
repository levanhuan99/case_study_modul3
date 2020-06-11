import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPassword_Servlet",urlPatterns = "/Password")
public class ForgotPassword_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        if (action.equals("get_pass")){
            sendPasswordToEmail(request,response);
        }
        
    }

    private void sendPasswordToEmail(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        if (action.equals("get_password")){
            RequestDispatcher dispatcher=request.getRequestDispatcher("home/forgot_password_form.jsp");
            dispatcher.forward(request,response);
        }
    }
}

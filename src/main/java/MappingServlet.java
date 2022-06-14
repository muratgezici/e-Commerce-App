import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MappingServlet", value = "/MappingServlet")
public class MappingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String pageid = request.getParameter("pageid");

       if(pageid.equalsIgnoreCase("login")){
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/login.jsp");
           dispatcher.include(request,response);
       }
       else if(pageid.equalsIgnoreCase("register")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/register-direction.jsp");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag= request.getParameter("direct");
        if(flag.equalsIgnoreCase("customer")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/register-user.jsp");
            dispatcher.forward(request,response);
        }
        else if(flag.equalsIgnoreCase("seller")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/register-seller.jsp");
            dispatcher.forward(request,response);
        }
    }
}

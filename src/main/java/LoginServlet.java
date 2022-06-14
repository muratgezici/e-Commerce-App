import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=getServletContext();
        String usertypeFlag=(String)context.getAttribute("usertypeFlag");
        if(usertypeFlag==null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedin.jsp");
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedinSeller.jsp");
            dispatcher.forward(request,response);
        }

    }
}

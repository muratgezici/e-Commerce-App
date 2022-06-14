import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditInfoServlet", value = "/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag= request.getParameter("editflag");

        if(flag.equalsIgnoreCase("user_edit")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/edit-user.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("user_save")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-user.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("seller_edit")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/edit-seller.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("seller_save")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-seller.jsp");
            dispatcher.forward(request,response);
        }

    }
}

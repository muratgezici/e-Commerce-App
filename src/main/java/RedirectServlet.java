import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String sess="";
        if(session.getAttribute("userType")!=null)
        sess = session.getAttribute("userType").toString();

        if(sess.equalsIgnoreCase("customer")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedin.jsp");
            dispatcher.forward(request,response);
        }
        else if(sess.equalsIgnoreCase("commercial")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedinSeller.jsp");
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String sess="";
        if(session.getAttribute("userType")!=null)
            sess = session.getAttribute("userType").toString();

        if(sess.equalsIgnoreCase("customer")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedin.jsp");
            dispatcher.forward(request,response);
        }
        else if(sess.equalsIgnoreCase("commercial")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedinSeller.jsp");
            dispatcher.forward(request,response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }

    }
}

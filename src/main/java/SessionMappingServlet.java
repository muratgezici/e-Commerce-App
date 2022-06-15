import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionMappingServlet", value = "/SessionMappingServlet")
public class SessionMappingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageid = request.getParameter("pageid");

        HttpSession session=request.getSession();
        if (session == null || session.getAttribute("userType") == null) {
            response.sendRedirect("RedirectServlet");
        }
        else if(pageid==null){
            response.sendRedirect("RedirectServlet");
        }
        else if(pageid.equalsIgnoreCase("profile")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-user.jsp");
            dispatcher.include(request,response);
        }
        else if(pageid.equalsIgnoreCase("orders")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/orders.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("cart")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("home")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedin.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("logout")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            session.invalidate();
            dispatcher.forward(request,response);
        }

        else if(pageid.equalsIgnoreCase("profile-S")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-seller.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("myproducts-S")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("home-S")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedinSeller.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

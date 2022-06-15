import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductOperationServlet", value = "/ProductOperationServlet")
public class ProductOperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        HttpSession session=request.getSession();
        if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect("RedirectServlet");
        }
      else if(action.equalsIgnoreCase("add")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/addproduct.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("edit")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/editproduct.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("delete")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }

       else if(action.equalsIgnoreCase("edit-save")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("add-save")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }
    }
}

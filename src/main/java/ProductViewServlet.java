import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductViewServlet", value = "/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemid = request.getParameter("itemid");
        String userType = request.getParameter("utype");

        if(userType.equalsIgnoreCase("S")){
            if(itemid.equalsIgnoreCase("1")){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfoS.jsp");
                dispatcher.forward(request,response);
            }
        }
      else if(userType.equalsIgnoreCase("U")){
            if(itemid.equalsIgnoreCase("1")){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfoU.jsp");
                dispatcher.forward(request,response);
            }
        }
        else if(userType.equalsIgnoreCase("A")){
            if(itemid.equalsIgnoreCase("1")){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfo.jsp");
                dispatcher.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageid = request.getParameter("productfilter");
        if(pageid.equalsIgnoreCase("none-S")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productsS.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("none-U")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productsU.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("none")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/products.jsp");
            dispatcher.forward(request,response);
        }
    }
}

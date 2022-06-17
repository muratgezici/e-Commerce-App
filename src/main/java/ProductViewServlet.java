import Database.MongoDBProduct;
import Database.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductViewServlet", value = "/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfo.jsp");
                dispatcher.forward(request,response);
        if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect("RedirectServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageid = request.getParameter("productfilter");
        HttpSession session=request.getSession();
        List<Product> products = MongoDBProduct.MongoGetProducts();
        request.setAttribute("productsAll", products);
        String search = request.getParameter("searchstring");
        if(search==null){

        }
        else if(!search.equalsIgnoreCase(" ") && !search.equalsIgnoreCase("")){
            List<Product> products_filtered = MongoDBProduct.MongoGetProductsFilter(search);
            request.setAttribute("productsAll", products_filtered);
        }


        if(pageid.equalsIgnoreCase("none") || pageid.equalsIgnoreCase("exists")){

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/products.jsp");
            dispatcher.forward(request,response);
        }
        else if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else if(pageid.equalsIgnoreCase("none-S") || pageid.equalsIgnoreCase("exists-S")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productsS.jsp");
            dispatcher.forward(request,response);
        }
        else if(pageid.equalsIgnoreCase("none-U") || pageid.equalsIgnoreCase("exists-U")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productsU.jsp");
            dispatcher.forward(request,response);
        }

    }
}

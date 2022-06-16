import Database.MongoDBProduct;
import Database.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductItemViewServlet", value = "/ProductItemViewServlet")
public class ProductItemViewServlet extends HttpServlet {
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
        HttpSession session=request.getSession();
        List<Product> products = MongoDBProduct.MongoGetProducts();
        request.setAttribute("productsAll", products);

        String itemId = request.getParameter("selectedproduct");

        System.out.println("before for loop"+itemId);
        for(Product p:products){
            System.out.println("in for loop "+p.getId());
            if(p.getId().equalsIgnoreCase(itemId)){
                System.out.println("in result");
                request.setAttribute("selectedproduct", p);

               if(session.getAttribute("userType")==null){
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfo.jsp");
                   dispatcher.forward(request,response);
                }
              else if(session.getAttribute("userType").toString().equalsIgnoreCase("customer")){
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfoU.jsp");
                    dispatcher.forward(request,response);
                }
               else if(session.getAttribute("userType").toString().equalsIgnoreCase("commercial")){
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-pages/productinfoS.jsp");
                    dispatcher.forward(request,response);
                }

            }
        }

    }
}

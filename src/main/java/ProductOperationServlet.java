import Database.Commercial;
import Database.MongoDBProduct;
import Database.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

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
            String pid = request.getParameter("productid");
         Product pro =  MongoDBProduct.MongoGetProduct(pid);


            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/editproduct.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("delete")){

            String pid = request.getParameter("productid");
            MongoDBProduct.MongoRemoveProduct(pid);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }

       else if(action.equalsIgnoreCase("edit-save")){
            String pid = request.getParameter("productid");
            Commercial comm = (Commercial)session.getAttribute("userObject");

            String sid1 = comm.getId();
            String name = request.getParameter("pname");
            String desc = request.getParameter("desc");
            String price = request.getParameter("price");
            String stock_quantity = request.getParameter("quantity");
            String add_date = request.getParameter("add_date");
            String ex_date = request.getParameter("ex_date");
            String category = request.getParameter("category");

            MongoDBProduct.MongoDBUpdateProduct(pid,sid1,name,desc,price,stock_quantity,add_date,ex_date,category);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("add-save")){
           Commercial comm = (Commercial)session.getAttribute("userObject");
            String sid1 = comm.getId();
            String name = request.getParameter("pname");
            String desc = request.getParameter("desc");
            String price = request.getParameter("price");
            String stock_quantity = request.getParameter("quantity");
            String add_date = request.getParameter("add_date");
            String ex_date = request.getParameter("ex_date");
            String category = request.getParameter("category");

            MongoDBProduct.mongoInsert(sid1,name,desc,price,stock_quantity,add_date,ex_date,category);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }
    }
}

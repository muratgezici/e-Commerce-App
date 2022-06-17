import Database.Customer;
import Database.MongoDBOrder;
import Database.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "OrderOpsServlet", value = "/OrderOpsServlet")
public class OrderOpsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
      Customer cus = (Customer) session.getAttribute("userObject");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(formatter.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        boolean flag=true;
        ArrayList<Product> products = new ArrayList<Product>();
        if(session.getAttribute("cart")==null){
            flag =false;
        }else{
            products = (ArrayList<Product>) session.getAttribute("cart");
        }
        MongoDBOrder.mongoInsertOrder(cus.getId(),date1,products);

        session.setAttribute("cart",null);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/orders.jsp");
        dispatcher.forward(request,response);
    }
}

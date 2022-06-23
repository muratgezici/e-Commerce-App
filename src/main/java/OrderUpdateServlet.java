import Database.MongoDBOrder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderUpdateServlet", value = "/OrderUpdateServlet")
public class OrderUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("statusupdate");
        String itemid = request.getParameter("itemid");
        String orderid = request.getParameter("orderid");
        System.out.println(itemid+" "+operation);
        if(operation.equalsIgnoreCase("accepted")){
            MongoDBOrder.MongoDBUpdateOrder(itemid,operation, orderid);
            MongoDBOrder.MongoDBUpdateOrderStatus(orderid);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/orderitemsA.jsp");
            dispatcher.forward(request,response);
        }
        else if(operation.equalsIgnoreCase("denied")){
            MongoDBOrder.MongoDBUpdateOrder(itemid,operation, orderid);
            MongoDBOrder.MongoDBUpdateOrderStatus("orderid");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/orderitemsA.jsp");
            dispatcher.forward(request,response);
        }


    }
}

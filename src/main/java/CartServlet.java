import Database.Product;
import com.google.gson.Gson;

import javax.json.JsonObject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ops = request.getParameter("ops");
        String proid = request.getParameter("itemid");
        HttpSession session = request.getSession();
        if(ops.equalsIgnoreCase("delete")){
            ArrayList<Product> products = new ArrayList<Product>();
            products = (ArrayList<Product>) session.getAttribute("cart");
            Product pro_del = null;
            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){

                    session.setAttribute("message", "Product removed!");
                    session.setAttribute("messageType", "red");
                    pro_del = pro;
                    String message = "Product removed!";
                    String messagetype = "warning";
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");


                    String text_to_go = "0:"+message+":"+messagetype;
                    response.setContentType("text/plain");
                    response.getWriter().write(text_to_go);

                }
            }
            products.remove(pro_del);


        }
        else if(ops.equalsIgnoreCase("decrement")){
            ArrayList<Product> products = new ArrayList<Product>();
            products = (ArrayList<Product>) session.getAttribute("cart");
            Product pro_del = null;
            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){
                  int amount = Integer.parseInt( products.get( products.indexOf(pro)).getAmount());
                    amount-=1;
                    if(amount<=0){

                        session.setAttribute("message", "Product removed! (0) amount");
                        session.setAttribute("messageType", "red");
                        pro_del = pro;

                        String message = "Product removed! (0) amount";
                        String messagetype = "warning";
                        String text_to_go = "0:"+message+":"+messagetype;
                        response.setContentType("text/plain");
                        response.getWriter().write(text_to_go);
                    }
                    else{
                        products.get(products.indexOf(pro)).setAmount(String.valueOf(amount));
                        session.setAttribute("message", "successfully decremented!");
                        session.setAttribute("messageType", "green");


                        String message = "successfully decremented!";
                        String messagetype = "warning-green";
                        String text_to_go = pro.getAmount()+":"+message+":"+messagetype;
                        response.setContentType("text/plain");
                        response.getWriter().write(text_to_go);
                    }


                }
            }
            products.remove(pro_del);


        }
        else if(ops.equalsIgnoreCase("increment")){
            ArrayList<Product> products = new ArrayList<Product>();
            products = (ArrayList<Product>) session.getAttribute("cart");

            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){
                    int amount = Integer.parseInt( products.get( products.indexOf(pro)).getAmount());
                    amount+=1;
                    if(amount>Integer.parseInt(products.get( products.indexOf(pro)).getStock_quantity())){
                        session.setAttribute("message", "product stock exceeded, please contact with the shop!");
                        session.setAttribute("messageType", "red");

                        String message = "product stock exceeded, please contact with the shop!";
                        String messagetype = "warning";
                        String text_to_go = pro.getAmount()+":"+message+":"+messagetype;
                        response.setContentType("text/plain");
                        response.getWriter().write(text_to_go);

                    }
                    else{
                        products.get(products.indexOf(pro)).setAmount(String.valueOf(amount));
                        session.setAttribute("message", "successfully incremented!");
                        session.setAttribute("messageType", "green");


                        String message = "succesfully incremented!";
                        String messagetype = "warning-green";
                        String text_to_go = pro.getAmount()+":"+message+":"+messagetype;
                        response.setContentType("text/plain");
                        response.getWriter().write(text_to_go);

                    }

                }
            }
        }

        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
        //dispatcher.forward(request,response);
        //this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Product p = (Product) session.getAttribute("addCartProduct");
        p.getName();
        p.setAmount("1");
        ArrayList<Product> products = new ArrayList<Product>();
       if(session.getAttribute("cart")==null){
           products.add(p);
           session.setAttribute("cart", products);
       }else{
           products = (ArrayList<Product>) session.getAttribute("cart");
           products.add(p);
           session.setAttribute("cart", products);
       }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
        dispatcher.forward(request,response);
}
}

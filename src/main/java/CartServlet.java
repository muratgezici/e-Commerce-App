import Database.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

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
            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){
                    products.remove(pro);
                    session.setAttribute("message", "Product removed!");
                    session.setAttribute("messageType", "red");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
                    dispatcher.forward(request,response);
                }
            }


        }
        else if(ops.equalsIgnoreCase("decrement")){
            ArrayList<Product> products = new ArrayList<Product>();
            products = (ArrayList<Product>) session.getAttribute("cart");

            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){
                  int amount = Integer.parseInt( products.get( products.indexOf(pro)).getAmount());
                    amount--;
                    if(amount<=0){
                        products.remove(pro);
                        session.setAttribute("message", "Product removed! (0) amount");
                        session.setAttribute("messageType", "red");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
                        dispatcher.forward(request,response);
                    }
                    else{
                        products.get(products.indexOf(pro)).setAmount(amount+"");
                        session.setAttribute("message", "successfully decremented!");
                        session.setAttribute("messageType", "green");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
                        dispatcher.forward(request,response);
                    }

                }
            }


        }
        else if(ops.equalsIgnoreCase("increment")){
            ArrayList<Product> products = new ArrayList<Product>();
            products = (ArrayList<Product>) session.getAttribute("cart");

            for(Product pro:products){
                if(pro.getId().equalsIgnoreCase(proid)){
                    int amount = Integer.parseInt( products.get( products.indexOf(pro)).getAmount());
                    amount++;
                    if(amount>Integer.parseInt(products.get( products.indexOf(pro)).getStock_quantity())){
                        session.setAttribute("message", "product stock exceeded, please contact with the shop!");
                        session.setAttribute("messageType", "red");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
                        dispatcher.forward(request,response);
                    }
                    else{
                        products.get(products.indexOf(pro)).setAmount(amount+"");
                        session.setAttribute("message", "successfully incremented!");
                        session.setAttribute("messageType", "green");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
                        dispatcher.forward(request,response);
                    }

                }
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-user/cart.jsp");
        dispatcher.forward(request,response);
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

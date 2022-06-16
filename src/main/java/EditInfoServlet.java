import Database.Commercial;
import Database.Customer;
import Database.MongoDBCommercial;
import Database.MongoDBCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditInfoServlet", value = "/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag= request.getParameter("editflag");

        HttpSession session=request.getSession();
        if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

        else if(flag.equalsIgnoreCase("user_edit")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/edit-user.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("user_save")){
           String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("e-mail");
            String username = request.getParameter("username");
            String address = request.getParameter("address");
          Customer cus = (Customer)  session.getAttribute("userObject");
          String id = cus.getId();
          String pass = cus.getPassword();
            MongoDBCustomer.MongoDBUpdateCustomer(id,name,surname,username,email,address);
            Customer cus1 = new Customer(id,name,surname,username,email,address,pass);
            session.setAttribute("userObject", cus1);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-user.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("seller_edit")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/edit-seller.jsp");
            dispatcher.forward(request,response);
        }
       else if(flag.equalsIgnoreCase("seller_save")){

            String name = request.getParameter("name");
            String surname = request.getParameter("vname");
            String email = request.getParameter("e-mail");
            String username = request.getParameter("username");
            String address = request.getParameter("address");
            Commercial comm = (Commercial)  session.getAttribute("userObject");
            String id = comm.getId();
            String pass = comm.getPassword();
            MongoDBCommercial.MongoDBUpdateCommercial(id,name,surname,username,email,address);
            Commercial comm1 = new Commercial(id,name,surname,username,email,address,pass);
            session.setAttribute("userObject", comm1);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile/profile-seller.jsp");
            dispatcher.forward(request,response);
        }

    }
}

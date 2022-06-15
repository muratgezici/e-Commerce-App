import Database.Commercial;
import Database.Customer;
import Database.MongoDBCommercial;
import Database.MongoDBCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=getServletContext();
        HttpSession session=request.getSession();

        String usertypeFlag=(String)context.getAttribute("usertypeFlag");
       String username= (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        if(usertypeFlag==null){
            Customer cusCheck = MongoDBCustomer.MongoUserCheckCustomer(username,password);
            if(cusCheck!=null){

                session.setAttribute("name",cusCheck.getName());
                session.setAttribute("userObject", cusCheck);
                session.setAttribute("userType","customer");
                session.setAttribute("message", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedin.jsp");
                dispatcher.forward(request,response);
            }
            else{
                session.setAttribute("message", "Check your credidentals!");
                response.sendRedirect("MappingServlet?pageid=login");

            }


        }
        else{
            Commercial commCheck = MongoDBCommercial.MongoUserCheckCommercial(username,password);
            if(commCheck!=null){

                session.setAttribute("name",commCheck.getCname());
                session.setAttribute("userObject", commCheck);
                session.setAttribute("userType","commercial");
                session.setAttribute("message", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexLoggedinSeller.jsp");
                dispatcher.forward(request,response);
            }
            else{
                session.setAttribute("message", "Check your credidentals!");
                response.sendRedirect("MappingServlet?pageid=login");
            }


        }

    }
}

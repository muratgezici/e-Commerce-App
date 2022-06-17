import Database.MongoDBCommercial;
import Database.MongoDBCustomer;
import Database.MongoDBProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String usertype = request.getParameter("direct");
        HttpSession session = request.getSession();
        String message = "";
       if(usertype.equalsIgnoreCase("customerReg")){
           String name = request.getParameter("name");
           String surname = request.getParameter("surname");
           String email = request.getParameter("e-mail");
           String username = request.getParameter("username");
           String address = request.getParameter("address");
           String pass = request.getParameter("password");
           String pass1 = request.getParameter("password1");
           if(name.equalsIgnoreCase("") || name.equalsIgnoreCase(" ") ){
                message+=" (name) ";
           }
           if(surname.equalsIgnoreCase("") || surname.equalsIgnoreCase(" ") ){
               message+=" (surname) ";
           }
           if(email.equalsIgnoreCase("") || email.equalsIgnoreCase(" ") ){
               message+=" (email) ";
           }
           if(username.equalsIgnoreCase("") || username.equalsIgnoreCase(" ") ){
               message+=" (username) ";
           }
           if(address.equalsIgnoreCase("") || address.equalsIgnoreCase(" ") ){
               message+=" (address) ";
           }
           if(!pass.equals(pass1)){
               message+=" (password mismatch) ";
           }

           if(message.length()<2){
               MongoDBCustomer.mongoInsertCustomer(name,surname,username,email,address,pass);
               session.setAttribute("message", "register successful! please login");
               session.setAttribute("messageType", "green");
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/login.jsp");
               dispatcher.forward(request,response);
           }
           else{
               session.setAttribute("messageType", "red");
               session.setAttribute("message", "Check your credidentals! "+message);
               response.sendRedirect("MappingServlet?pageid=customerReg");
           }

       }
       else if(usertype.equalsIgnoreCase("commercialReg")){
           String name = request.getParameter("name");
           String surname = request.getParameter("vname");
           String email = request.getParameter("e-mail");
           String username = request.getParameter("username");
           String address = request.getParameter("address");
           String pass = request.getParameter("password");
           String pass1 = request.getParameter("password1");

           if(name.equalsIgnoreCase("") || name.equalsIgnoreCase(" ") ){
               message+=" (name) ";
           }
           if(surname.equalsIgnoreCase("") || surname.equalsIgnoreCase(" ") ){
               message+=" (surname) ";
           }
           if(email.equalsIgnoreCase("") || email.equalsIgnoreCase(" ") ){
               message+=" (email) ";
           }
           if(username.equalsIgnoreCase("") || username.equalsIgnoreCase(" ") ){
               message+=" (username) ";
           }
           if(address.equalsIgnoreCase("") || address.equalsIgnoreCase(" ") ){
               message+=" (address) ";
           }
           if(!pass.equals(pass1)){
               message+=" (password mismatch) ";
           }

           if(message.length()<2){
               MongoDBCustomer.mongoInsertCustomer(name,surname,username,email,address,pass);
               session.setAttribute("message", "register successful! please login");
               session.setAttribute("messageType", "green");
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-register-profile/login.jsp");
               dispatcher.forward(request,response);
           }
           else{
               session.setAttribute("messageType", "red");
               session.setAttribute("message", "Check your credidentals! "+message);
               response.sendRedirect("MappingServlet?pageid=commercialReg");
           }

       }

    }
}

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Database.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dropdown.css">
    <link rel="stylesheet" href="./css/login.css">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
    <style>
        .content div{
            flex-direction: column;
            justify-content: space-evenly;
            align-items: flex-start;
            
           
        }
        .addremove button{
            width: 15px;
        }
        
        table{
            padding: 10px;
            
        }
        table tr td{
            padding: 10px;
            padding-left: 20px;
        }

    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>

<%
    boolean flag=true;
    ArrayList<Order> orders = new ArrayList<Order>();
   Commercial comm = (Commercial)  session.getAttribute("userObject");
        orders = MongoDBOrder.MongoGetOrdersSeller(comm.getId());
        String orderid = request.getParameter("orderid");

%>
    <div class="content">
        <div>
            <h3>My Orders: </h3>
            <table>
                <tr>
                    <th>Item Name: </th>
                    <th>Item Price: </th>
                    <th>Item Amount: </th>
                    <th>Total Price: </th>
                    <th>Purchase Date: </th>
                    <th>Status: </th>
                    <th>Set Status(only one time!)</th>

                </tr>
                <% for(Order order:orders){
                   ArrayList<Product> pros = order.getProducts();
                   for(Product pro:pros){
                       System.out.println("Status of pro: "+pro.getStatus());
                       if(pro.getStatus().equalsIgnoreCase("waiting")){

                %>
                <tr>
                    <td><%=pro.getName()%></td>
                    <td><%=pro.getPrice()%>TL</td>
                    <td><%=pro.getAmount()%></td>
                    <td><%=Double.parseDouble(pro.getPrice())*Double.parseDouble(pro.getAmount())%>TL</td>
                    <%
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        String addDate = dateFormat.format(order.getOrder_date());%>
                    <td><%=addDate%></td>
                    <td><%=pro.getStatus()%></td>
                    <form action="OrderUpdateServlet" method="post">
                        <input type="hidden" name="itemid" value="<%=pro.getId()%>" >
                        <input type="hidden" name="orderid" value="<%=order.getOid()%>" >
                        <td><button type="submit" name="statusupdate" value="accepted"><i class="fa-solid fa-check"></i></button>
                            <button type="submit" name="statusupdate" value="denied"><i class="fa-solid fa-x"></i></button></td></form>
                    
                </tr>
                <%}}
                }%>
            </table>

        </div>
       
    </div>
</body>
</html>
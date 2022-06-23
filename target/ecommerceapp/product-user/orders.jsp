<%@ page import="Database.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Database.MongoDBOrder" %>
<%@ page import="Database.Customer" %>
<%@ page import="Database.Product" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        .content table button{
            border-radius: 40px;
            width: 25px;
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
<%@ include file = "../headerLoggedin.jsp" %>

<%
    boolean flag=true;
    ArrayList<Order> orders = new ArrayList<Order>();
   Customer cus = (Customer)  session.getAttribute("userObject");
        orders = MongoDBOrder.MongoGetOrdersCustomer(cus.getId());


%>
    <div class="content">
        <div>
            <h3>My Orders: </h3>
            <table>
                <tr>
                    <th>Order Id: </th>
                    <th>Products in: </th>
                    <th>Order Price: </th>
                    <th>Status: </th>
                    <th>Details </th>

                </tr>
                <% for(Order order:orders){
                   ArrayList<Product> pros = order.getProducts();
                   String items="";
                   %>
                <tr>
                 <td><%=order.getOid()%></td>
                <%   for(Product pro:pros){
                    items+= pro.getName() + ", ";
                }
                %>
                    <td><%=items%></td>
                    <td><%=order.getTotalprice()%>TL</td>
                    <td><%=order.getStatus()%></td>
                    <form action="OrderOpsServlet" method="post">
                        <input type="hidden" name="orderid" value="<%=order.getOid()%>">
                    <td><button type="submit" name="showorderitems" value="showorderitems"> <i class="fa fa-info"></i></button></td></form>
                </tr>
                <%items="";}%>
            </table>
        </div>
       
    </div>
</body>
</html>
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
<%@ include file = "../headerLoggedin.jsp" %>

<%
    boolean flag=true;
    ArrayList<Order> orders = new ArrayList<Order>();
   Customer cus = (Customer)  session.getAttribute("userObject");
        orders = MongoDBOrder.MongoGetOrdersCustomer(cus.getId());
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

                </tr>
                <% for(Order order:orders){
                   ArrayList<Product> pros = order.getProducts();
                   if(orderid.equalsIgnoreCase(order.getOid())){
                   for(Product pro:pros){
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
                    
                </tr>
                <%}}
                }%>
            </table>
            <form action="OrderOpsServlet" method="post">
                <button type="submit" name="showorderitems" value="showorderitemsR">Back to Orders</button>
            </form>
        </div>
       
    </div>
</body>
</html>
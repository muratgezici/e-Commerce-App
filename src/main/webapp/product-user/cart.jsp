<%@ page import="Database.Product" %>
<%@ page import="java.util.ArrayList" %>
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
    ArrayList<Product> products = new ArrayList<Product>();
    if(session.getAttribute("cart")==null){
        flag =false;
    }else{
        products = (ArrayList<Product>) session.getAttribute("cart");
    }

%>
    <div class="content">
        <div>
            <h3>My Items: </h3>
            <% String message = (String) session.getAttribute("message");
                String messageType = session.getAttribute("messageType")==null?"red":session.getAttribute("messageType").toString();
                session.setAttribute("message", "");%>
            <p class="<%= messageType.equalsIgnoreCase("green")? "warning-green":"warning"%>"><%= message==null ? "" : message%></p>
            <table>
                <tr>
                    <th>Item Name: </th>
                    <th>Item Price: </th>
                    <th>Item Amount: </th>
                    <th>Actions: </th>
                </tr>

                    <%if(flag){
                    for(Product pro:products){%>
                <tr>
                    <td><%=pro.getName()%></td>
                    <td><%=pro.getPrice()%>TL</td>
                    <td class="addremove">
                        <a href="./CartServlet?ops=decrement&itemid=<%=pro.getId()%>"><i class="fa-solid fa-minus"></i></a>
                        <%=pro.getAmount()%>
                        <a href="./CartServlet?ops=increment&itemid=<%=pro.getId()%>"><i class="fa-solid fa-plus"></i></a>
                     </td>
                    <td><a href="./CartServlet?ops=delete&itemid=<%=pro.getId()%>">Delete</a></td>
                </tr>
                   <% }}%>
                <form action="OrderOpsServlet" method="post">
                    <button type="submit">Buy</button>
                </form>
            </table>
        </div>
       
    </div>
</body>
</html>
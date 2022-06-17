<%@ page import="Database.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dropdown.css">
    <link rel="stylesheet" href="./css/products.css">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
    <style>
        .content{
            flex-direction: row;
            padding-top: 30px;
            justify-content: baseline;
            align-items:flex-start;
        }
        .content .iteminfo{
            padding: 40px;
            width: 400px;
            
        }
        .content .iteminfo{
            display: flex;
            flex-direction: column;
        }
    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedin.jsp" %>
<% Product p = (Product) request.getAttribute("selectedproduct");%>
<div class="content">
    <div><img src="./img/quickbuy.png" alt="">
        <p><%=p.getName()%></p>
        <p><%=p.getPrice()%></p>
        <form action="CartServlet" method="post">
            <% session.setAttribute("addCartProduct", p);
                System.out.println(p.getName());%>
            <button value="Add to cart">Add to cart</button>
        </form>

    </div>
    <div class="iteminfo"><p> <%=p.getDesc()%></p>

    </div>

</div>
</body>
</html>
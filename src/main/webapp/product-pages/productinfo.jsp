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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <style>
        .content{
            flex-direction: row;
            padding-top: 30px;
            justify-content: center;
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
<%@ include file = "../header.jsp" %>
<% Product p = (Product) request.getAttribute("selectedproduct");%>
    <div class="content">
        <div class="iteminfo"> <img src="./img/product_<%=p.getId()%>.jpg?time=<%=System.currentTimeMillis()%>" onerror="this.onerror=null;this.src='./img/quickbuy.png?time=<%=System.currentTimeMillis()%>';"  alt="">

</div>
        <div class="iteminfo"><p> <%=p.getDesc()%></p>
            <br>
            <p>Product Name: <%=p.getName()%></p>
            <br>
            <p>Category: <%=p.getCategory()%></p>
            <br>
            <p>Stock: <%=p.getStock_quantity()%></p>
            <p>Price: <%=p.getPrice()%>TL</p>
            <br>
            <form action="MappingServlet" method="get">
                <button name="pageid" value="login">Add to cart</button></form>
       
    </div>
        
    </div>
</body>
</html>
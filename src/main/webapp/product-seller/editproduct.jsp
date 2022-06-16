<%@ page import="Database.Product" %>
<%@ page import="Database.MongoDBProduct" %>
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
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>
<%
    String pid = request.getParameter("productid");
    Product pro =  MongoDBProduct.MongoGetProduct(pid);

%>
    <div class="content">
<form class="loginform" action="ProductOperationServlet" method="post" width="500px">
    <h3>Update Product</h3>
    <div>
        <input type="text" placeholder="product name" name="pname" value="<%=pro.getName()%>">

    </div>
    <div>Image: </div>
    <div><input type="file" style="width: 200px;"name="image"></div>

    <div>
        <textarea name="desc" cols="40" placeholder="product description" rows="5"><%=pro.getDesc()%></textarea>
    </div>
    <div>
        <input type="text" placeholder="price" name="price" value="<%=pro.getPrice()%>">
        <%System.out.println(pro.getAdd_date());%>
        <input type="text" placeholder="product quantity" name="quantity" value="<%=pro.getStock_quantity()%>">
    </div>
    <div>

        <%System.out.println("add date: "+pro.getAdd_date());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String addDate = dateFormat.format(pro.getAdd_date());
            String exDate = dateFormat.format(pro.getEx_date());
        %>
        <input type="date" placeholder="today's date" name="add_date" value=<%=addDate%>>
        <input type="date" placeholder="expiration date" name="ex_date" value=<%=exDate%>>
        <input type="text" placeholder="category" name="category" value="<%=pro.getCategory()%>">

    </div>
    <input type="hidden" name="productid" value="<%=pid%>">
    <button type="submit" name="action" value="edit-save" ><p>Update product</p></button>

</form>
    </div>
</body>
</html>
<%@ page import="Database.MongoDBProduct" %>
<%@ page import="Database.Commercial" %>
<%@ page import="Database.Product" %>
<%@ page import="java.util.List" %>
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
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>
    <div class="content">

        <form class="loginform" action="FileUploadServlet" method="post" enctype="multipart/form-data" width="500px">
            <h3>Add Product</h3>
            <div>
                <input type="text" placeholder="product name" name="pname">

            </div>
            <div>Image: </div>
            <div><input type="file" style="width: 200px;"name="image"></div>

            <div>
                <textarea name="desc" cols="40" placeholder="product description" rows="5"></textarea>
            </div>
            <div>
                <input type="text" placeholder="price" name="price">
                <input type="text" placeholder="product quantity" name="quantity">
            </div>
            <div>
                <input type="date" placeholder="today's date" name="add_date">
                <input type="date" placeholder="expiration date" name="ex_date">
                <input type="text" placehoder="category" name="category">

            </div>
            <input type="hidden" name="action" value="add-save">
            <button type="submit"><p>Add product</p></button>

        </form>
    </div>
</body>
</html>
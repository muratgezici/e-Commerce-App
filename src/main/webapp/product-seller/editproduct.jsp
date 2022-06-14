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
<%@ include file = "../headerLoggedin.jsp" %>
    <div class="content">
        
        <form class="loginform" action="../products.jsp" width="500px">
            <h3>Update Product</h1>
            <div><input type="text" placeholder="product name" name="pname">
                <input type="text" placeholder="product quantity" name="quantity"></div>
            <div><input type="text" placeholder="price" name="price">
                <input type="text" placeholder="image" name="image"></div>
                <button type="submit"><p>Update product</p></button>
            </div>
        </form>
    </div>
</body>
</html>
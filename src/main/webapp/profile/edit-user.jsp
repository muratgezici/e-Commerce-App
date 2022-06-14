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
        .content{
            width: 500px;
        }
        .content input{
            width: 400px;
        }
        .content div input{
            width: 200px;
        }
       
    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedin.jsp" %>

    <div class="content">
        
        <form class="loginform" action="../products.jsp" width="500px">
            <h3>Edit Info</h1>
            <div><input type="text" placeholder="Name" name="name">
                <input type="text" placeholder="Surname" name="surname"></div>
            <div><input type="text" placeholder="e-mail" name="e-mail">
                <input type="text" placeholder="username" name="username"></div>
                <input type="text" placeholder="address" name="address">
            <div> <input type="password" placeholder="Password" name="password">
                <input type="password" placeholder="Password Again" name="password1"></div>
            <div>
                <button type="submit"><p>Register</p></button>
            </div>
        </form>
    </div>
</body>
</html>
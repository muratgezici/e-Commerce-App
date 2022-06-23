<%@ page import="Database.Commercial" %>
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
        .content .loginform input{
            width: 400px;
        }
        .content .loginform div input{
            width: 200px;
        }
       
    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>
<%
    Commercial comm = (Commercial) session.getAttribute("userObject");
%>
    <div class="content">
        
        <form class="loginform" action="EditInfoServlet" method="post" width="500px">
            <h3>Edit Info</h1>
            <div><input type="text" placeholder="company name" name="name" value="<%=comm.getCname()%>">
                <input type="text" placeholder="company visible Name" name="vname" value="<%=comm.getCshortname()%>"></div>
            <div><input type="text" placeholder="company e-mail" name="e-mail" value="<%=comm.getEmail()%>">
                <input type="text" placeholder="username" name="username" value="<%=comm.getUsername()%>"></div>
                <input type="text" placeholder="company address" name="address" value="<%=comm.getAddress()%>">
            <div> <input type="password" placeholder="password" name="password">
                <input type="password" placeholder="password again" name="password1"></div>
            <div>
                <button type="submit" name="editflag" value="seller_save"><p>Register</p></button>
            </div>
        </form>
    </div>
</body>
</html>
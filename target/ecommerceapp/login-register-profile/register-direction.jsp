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
    <title>Register</title>
    <style>
        .content{
            height: fit-content;
            width: 500px;
        }
        .content  p{
            font-size: 20px;
        }
        .content  p span{
            color:rgb(123, 123, 219);
        }
       .content button{
            width: 200px;
        }
        .content  button:hover{
            color:#7ba6a2;
        }
        .content  button:hover span{
            color:whitesmoke;
            border-radius: 15px;
            
        }
    </style>
</head>
<body>
<%@ include file = "../header.jsp" %>
    <div class="content">
        <form class="loginform" method="post" action="MappingServlet" width="500px">
            <div>
                <button type="submit" name="direct" value="customer"><p>I'm a <span> customer </span></p></button>
                <button type="submit" name="direct" value="seller"><p>I'm a <span> seller </span></p></button>
            </div>
        </form>
    </div>
</body>
</html>
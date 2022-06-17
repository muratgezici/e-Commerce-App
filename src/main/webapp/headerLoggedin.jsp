<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/style.css">
    <link rel="stylesheet" href="./styles/dropdown.css">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
        <title>Home</title>
   
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("name")==null){
        response.sendRedirect("index.jsp");
    }
    else if(session.getAttribute("userType").toString().equalsIgnoreCase("commercial")){
        response.sendRedirect("RedirectServlet");
    }
%>
<header>
    <div class="header">
        <div id="headerleftside">
            <div id="logo"><a href="./SessionMappingServlet?pageid=home"><img src="./img/quickbuy-wide.png" alt=""></a></div>
            <form action="ProductViewServlet" method="post">
                <div id="searchbar"><input type="search" name="searchstring" placeholder="Search...">
                    <button type="submit" name="productfilter" value="exists-U"><i class="fa fa-search fa-xl"></i></button>
                    <button type="submit" name="productfilter" value="none-U"><i class="fa fa-store fa-xl"></i></button>
                </div>
            </form>

        </div>

        <div id="headerrightside">
            <div id="account">
                <div class="nav-container">
                    <ul class="nav-items">
                        <li class="nav-item nav-item-dropdown">
                            <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-user fa-xl"></i><p>My Account</p></button></a>
                            <ul class="dropdown-menu">
                                <a href="./SessionMappingServlet?pageid=profile"> <li class="dropdown-menu-item">
                                    My Profile
                                </li></a>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div id="login">
                <div class="nav-container">
                    <ul class="nav-items">
                        <li class="nav-item nav-item-dropdown">
                            <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-right-to-bracket fa-xl"></i><p>Logout</p></button></a>
                            <ul class="dropdown-menu">
                                <a href="./SessionMappingServlet?pageid=logout"> <li class="dropdown-menu-item">
                                    Logout
                                </li></a>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div>
            <div id="cart">
                <div class="nav-container">
                    <ul class="nav-items">
                        <li class="nav-item nav-item-dropdown">
                            <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-cart-shopping fa-xl"></i><p>My Cart</p></button></a>
                            <ul class="dropdown-menu">
                                <a href="./SessionMappingServlet?pageid=cart"><li class="dropdown-menu-item">
                                    My Cart
                                </li></a>
                                <a href="./SessionMappingServlet?pageid=orders"> <li class="dropdown-menu-item">
                                    Orders
                                </li></a>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>



</header>
    
</body>
</html>
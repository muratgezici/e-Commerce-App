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
<header>
    <div class="header">
        <div id="headerleftside">
            <div id="logo"><a href="./SessionMappingServlet?pageid=home-S"><img src="./img/quickbuy-wide.png" alt=""></a></div>
            <div id="searchbar"><input type="search" placeholder="Search..."> <button type="submit"><i class="fa fa-search fa-xl"></i></button></div>
        </div>

        <div id="headerrightside">
            <div id="account">
                <div class="nav-container">
                    <ul class="nav-items">
                        <li class="nav-item nav-item-dropdown">
                            <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-user fa-xl"></i><p>My Shop</p></button></a>
                            <ul class="dropdown-menu">
                                <a href="./SessionMappingServlet?pageid=profile-S"> <li class="dropdown-menu-item">
                                    Account Information
                                </li></a>
                                <a href="./SessionMappingServlet?pageid=myproducts-S"> <li class="dropdown-menu-item">
                                    Product List
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
                            <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-cart-shopping fa-xl"></i><p>Orders</p></button></a>
                            <ul class="dropdown-menu">
                                <a href="./SessionMappingServlet?pageid=cart"><li class="dropdown-menu-item">
                                    Awaiting Orders
                                </li></a>
                                <a href="./SessionMappingServlet?pageid=orders"> <li class="dropdown-menu-item">
                                    Past Orders
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
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
        <title>Home</title>
   
</head>
<body>
    <header>
        <div class="header">
            <div id="headerleftside">
                <div id="logo"><img src="./img/quickbuy-wide.png" alt=""></div>
                <div id="searchbar"><input type="search" placeholder="Search..."> <button type="submit"><i class="fa fa-search fa-xl"></i></button></div>
            </div>
        
            <div id="headerrightside">
                <div id="account">
                  <div class="nav-container">
                  <ul class="nav-items">
                    <li class="nav-item nav-item-dropdown">
                      <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-user fa-xl"></i><p>My Account</p></button></a>
                      <ul class="dropdown-menu">
                        <li class="dropdown-menu-item">
                          <a href="./MappingServlet?pageid=login">My Profile</a>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </div>
              </div>
                <div id="login">
                  <div class="nav-container">
                    <ul class="nav-items">
                      <li class="nav-item nav-item-dropdown">
                        <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-right-to-bracket fa-xl"></i><p>Login/Register</p></button></a>
                        <ul class="dropdown-menu">
                          <li class="dropdown-menu-item">
                            <a href="./MappingServlet?pageid=login">Login</a>
                          </li>
                          <li class="dropdown-menu-item">
                            <a href="./MappingServlet?pageid=register">Register</a>
                          </li>
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
                          <li class="dropdown-menu-item">
                            <a href="./MappingServlet?pageid=login">My Cart</a>
                          </li>
                          <li class="dropdown-menu-item">
                            <a href="./MappingServlet?pageid=login">Orders</a>
                          </li>
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
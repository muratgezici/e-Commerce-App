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
                <div id="logo"><a href="./MappingServlet?pageid=home"><img src="./img/quickbuy-wide.png" alt=""></a></div>
                <div id="searchbar"><input type="search" placeholder="Search..."> <button type="submit"><i class="fa fa-search fa-xl"></i></button></div>
            </div>
        
            <div id="headerrightside">
                <div id="account">
                  <div class="nav-container">
                  <ul class="nav-items">
                    <li class="nav-item nav-item-dropdown">
                      <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-user fa-xl"></i><p>My Account</p></button></a>
                      <ul class="dropdown-menu">
                          <a href="./MappingServlet?pageid=login"> <li class="dropdown-menu-item">
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
                        <a class="dropdown-trigger" href="#"><button type="submit"><i class="fa fa-right-to-bracket fa-xl"></i><p>Login/Register</p></button></a>
                        <ul class="dropdown-menu">
                            <a href="./MappingServlet?pageid=login"> <li class="dropdown-menu-item">
                          Login
                          </li></a>
                            <a href="./MappingServlet?pageid=register"><li class="dropdown-menu-item">
                           Register
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
                            <a href="./MappingServlet?pageid=login"><li class="dropdown-menu-item">
                           My Cart
                          </li></a>
                            <a href="./MappingServlet?pageid=login"> <li class="dropdown-menu-item">
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
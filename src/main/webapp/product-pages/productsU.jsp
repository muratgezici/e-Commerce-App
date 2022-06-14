<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dropdown.css">
    <link rel="stylesheet" href="./css/products.css">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedin.jsp" %>
    <div class="content">
        <div class="leftmenu">
            <h5>Categories</h5>
            <ul>
                <li>
                    <label for="touch"><span>Spaceships</span></label>               
                    <input type="checkbox" id="touch" class="touch"> 
                    <ul class="slide">
                      <li><a href="#">Lorem1 </a></li> 
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                    </ul></li>
                    <li>
                        <label for="touch1"><span>Cars</span></label>               
                        <input type="checkbox" id="touch1" class="touch"> 
                        <ul class="slide">
                          <li><a href="#">Lorem2 </a></li> 
                          <li><a href="#">Lorem </a></li>
                          <li><a href="#">Lorem </a></li>
                          <li><a href="#">Lorem </a></li>
                        </ul></li>
                    <li>
                    <label for="touch2"><span>Ships</span></label>               
                    <input type="checkbox" id="touch2" class="touch"> 
                    <ul class="slide">
                      <li><a href="#">Lorem3</a></li> 
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                    </ul></li>
                    <li>
                    <label for="touch3"><span>Planes</span></label>               
                    <input type="checkbox" id="touch3" class="touch"> 
                    <ul class="slide">
                      <li><a href="#">Lorem 4</a></li> 
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                    </ul></li>
                    <li>
                    <label for="touch4"><span>Grocery</span></label>               
                    <input type="checkbox" id="touch4" class="touch"> 
                    <ul class="slide">
                      <li><a href="#">Lorem5</a></li> 
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                    </ul></li>
                    <li>
                    <label for="touch5"><span>Armory</span></label>               
                    <input type="checkbox" id="touch5" class="touch"> 
                    <ul class="slide">
                      <li><a href="#">Lorem 6</a></li> 
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                      <li><a href="#">Lorem </a></li>
                    </ul></li>
            </ul>
        </div>

        <div class="products">
            <table>
                <th colspan="3">Products in "x" category</th>
                <tr>
                    <td class="productitem">
                      <a href="./ProductViewServlet?itemid=1&utype=U"><img src="./img/quickbuy.png" alt=""></a>
                       <p>Header</p>
                       <p>Price: 12.32TL</p>
                    </td>
                    <td class="productitem">
                      <img src="quickbuy.png" alt="">
                      <p>Header</p>
                      <p>Price: 12.32TL</p>
                   </td>
                   <td class="productitem">
                    <img src="quickbuy.png" alt="">
                    <p>Header</p>
                    <p>Price: 12.32TL</p>
                 </td>
                 <td class="productitem">
                  <img src="quickbuy.png" alt="">
                  <p>Header</p>
                  <p>Price: 12.32TL</p>
               </td>
                </tr>
        
            </table>
        </div>
    </div>
</body>
</html>
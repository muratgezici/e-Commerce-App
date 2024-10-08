<%@ page import="Database.Product" %>
<%@ page import="java.util.ArrayList" %>
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
                <%
                    String search = request.getParameter("searchstring");
                    String s = (search == null || search.equalsIgnoreCase("") || search.equalsIgnoreCase(" ")) ? "All Products" : "\""+search+"\" related products";
                %>
                <th colspan="3"> <%=s%></th>
                <%
                    ArrayList<Product> pro = (ArrayList<Product>)request.getAttribute("productsAll");
                    int colcounter =0;
                    int rowcounter=0;
                    for(Product p:pro){
                        if(rowcounter%4==0){%><tr><%}%>
                <td class="productitem">
                    <form action="ProductItemViewServlet" method="post">
                        <input type="" name="selectedproduct" value="<%=p.getId()%>" hidden>

                        <button type="submit">
                            <img src="./img/product_<%=p.getId()%>.jpg?time=<%=System.currentTimeMillis()%>" onerror="this.onerror=null;this.src='./img/quickbuy.png?time=<%=System.currentTimeMillis()%>';"  alt="">
                            <p><%=p.getName()%></p>
                            <p>Price: <%=p.getPrice()%></p>
                        </button>
                    </form>


                </td>
                <% rowcounter++; if(rowcounter%4==0){ colcounter++;%></tr><%}%>
                <% }%>
            </table>
        </div>
    </div>
</body>
</html>
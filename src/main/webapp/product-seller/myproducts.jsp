<%@ page import="Database.Commercial" %>
<%@ page import="Database.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Database.MongoDBProduct" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
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
        body{
            display: flex;
            flex-direction: column;
        }
        .content{
            width: fit-content;
           height: fit-content;
        }
        .content div{
            display:flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
           
            
        }
        .content div img{
            width: 50px;
            height: 50px;
            object-fit:cover;
           
            
        }
        .content div img:hover{
            width: fit-content;
            height: fit-content;
            position: fixed;
            left: -10px;
            top:100px;
        }
        .content div button{
            width: 50px;
            padding: 0px;
            margin:1px;
        }
        .content div tr td{
            height: 55px;
            padding-left: 10px;
        }
        .content div tr th{
            height: 55px;
            padding-left: 10px;
        }
      .content .newproduct button{
        width: 125px;
      }

    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>
<%
    Commercial comm = (Commercial) session.getAttribute("userObject");
    String id = comm.getId();
    System.out.println(id);
    ArrayList<Product> products = (ArrayList) MongoDBProduct.mongoViewProductsSeller(id);
%>

    <div class="content">
        <div>
            <div class="newproduct">
                <h3>My Products</h3>
                <form action="ProductOperationServlet" method="post">
                    <button type="submit" name="action" value="add">Add a New Product</button>
                </form>
            </div>
            <table>
                <tr>
                    <th>Product Image(Small)</th>
                    <th>Product Name</th>
                    <th>Product Stock</th>
                    <th>Product Price</th>
                    <th>Add Date</th>
                    <th>Expire Date</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>

                <% for(Product p:products){
                    System.out.println(p.getId());

                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    String addDate = dateFormat.format(p.getAdd_date());
                    String exDate = dateFormat.format(p.getEx_date());
                %>
                <tr>
                    <td> <img src="./img/quickbuy.png" alt=""> </td>
                    <td> <%=p.getName()%> </td>
                    <td> <%=p.getStock_quantity()%> </td>
                    <td> <%=p.getPrice()%> </td>
                    <td> <%=addDate%> </td>
                    <td> <%=exDate%> </td>
                    <td> <%=p.getCategory()%> </td>

                    <td>
                        <form class="actionform" action="ProductOperationServlet" method="post">
                            <input type="hidden" name="productid" value="<%=p.getId()%>">
                            <button name="action" value="delete" type="submit">Delete</button>
                            <button name="action" value="edit" type="submit">Update</button>
                        </form>
                    </td>
                </tr>


               <% }%>


            </table>
        </div>
    </div>
</body>
</html>
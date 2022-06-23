<%@ page import="Database.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Database.Category" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="Database.MongoDBProduct" %>
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
<%
    ArrayList<Product> pro = (ArrayList<Product>)request.getAttribute("productsAll");
    ArrayList<Product> pro1 =(ArrayList<Product>) MongoDBProduct.MongoGetProducts();
%>
    <div class="content">
        <div class="leftmenu">
            <h5>Categories</h5>
            <%
                ArrayList<Category> cats = new ArrayList<Category>();

                for(Product p:pro1) {
                    ArrayList<String> tags = new ArrayList<String>();
                    String[] info = p.getCategory().split(" ");

                    for (int i = 1; i < info.length; i++) {
                        if (!tags.contains(info[i])) {
                            tags.add(info[i]);
                        }
                    }
                    Category cat = new Category(info[0], tags);
                    cats.add(cat);
                }
                ArrayList<Category> cats_unique = new ArrayList<Category>();
                ArrayList<String> tagsUnique = new ArrayList<>();
                for(Category cat:cats) {
                    boolean found =false;

                 for(Category innercat:cats_unique) {
                     if(cat.getName().equalsIgnoreCase(innercat.getName())) {
                         found=true;
                      ArrayList<String> tagsInner = cat.getTags();
                      tagsUnique = innercat.getTags();
                      for(String tinner:tagsInner){
                          if(!tagsUnique.contains(tinner)){
                              tagsUnique.add(tinner);
                              System.out.println("tags uniq: "+tagsUnique);
                          }
                      }
                         System.out.println("this is my cat object before set tags"+cat.toString());
                    cat.setTags(tagsUnique);
                         System.out.println("this is my cat object"+cat.toString());
                     }
                 }
                 if(!found) {
                     cats_unique.add(cat);
                 }

                } %>

             <%   for(Category printcat:cats_unique) { %>
            <ul>
                <li>
                    <label for="touch<%=printcat.getName()%>"><span><%=printcat.getName()%></span></label>
                    <input type="checkbox" id="touch<%=printcat.getName()%>" class="touch">
                    <ul class="slide">
                 <%   for (String printtag : printcat.getTags()) { %>
                     <form action="ProductViewServlet" method="post">
                         <input type="hidden" name="productfilter" value="exists">
                         <input type="hidden" name="searchstring" value="<%=printtag%>">
                         <li> <button class="categorybutton" type="submit"><%=printtag%></button></li>
                     </form>
                        <%   }%>
                    </ul></li>
                <%}
            %>
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
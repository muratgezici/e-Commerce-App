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
    <link rel="stylesheet" href="./css/login.css">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <style>
    .content div{
            flex-direction: column;
            justify-content: space-evenly;
            align-items: flex-start;
            
           
        }
        .addremove button{
            width: 15px;
        }
        
        table{
            padding: 10px;
            
        }
        table tr td{
            padding: 10px;
            padding-left: 20px;
        }

    </style>
    <title>Document</title>

    <script>
        function callJqueryAjax(id, ops){
                    $.ajax({
                        url     : './CartServlet',
                        method     : 'GET',
                        data     : {itemid : id, ops : ops},
                        success    : function(responseText){
                            console.log(responseText);
                           let s = responseText.split(":");
                            if(ops.includes("delete")){
                                console.log('Error not occured removed via button!!');
                                $("tr#" + id).empty();

                            }
                            else if(parseInt(s[0].toString())<1){
                                console.log('Error not occured removed due 0!!');
                                $("tr#" + id).empty();

                            }
                            else{
                                console.log('Error not occured!!');
                                $("tr#" + id + " div.cnt").html(s[0]);
                            }
                            $("#warnmessage").removeClass();
                            console.log(s[2]);
                            $("#warnmessage").addClass(s[2]);
                            $("#warnmessage").html(s[1]);
                        },
                        error : function(jqXHR, exception){
                            console.log('Error occured!! ');

                        }
                    });


        }

    </script>
</head>
<body>
<%@ include file = "../headerLoggedin.jsp" %>

<%
    boolean flag=true;
    ArrayList<Product> products = new ArrayList<Product>();
    if(session.getAttribute("cart")==null){
        flag =false;
    }else{
        products = (ArrayList<Product>) session.getAttribute("cart");
    }

%>


    <div class="content">
        <div>
            <h3>My Items: </h3>
            <% String message = (String) session.getAttribute("message");
                String messageType = session.getAttribute("messageType")==null?"red":session.getAttribute("messageType").toString();
                session.setAttribute("message", "");
                int totalquantity =0;
                double totalprice = 0;%>
            <p id="warnmessage" class="<%= messageType.equalsIgnoreCase("green")? "warning-green":"warning"%>"><%= message==null ? "" : message%></p>
            <table>
                <tr>
                    <th>Item Name: </th>
                    <th>Item Price: </th>
                    <th>Item Amount: </th>
                    <th>Actions: </th>
                </tr>

                    <%if(flag){

                    for(Product pro:products){%>
                <tr id="<%=pro.getId()%>">
                    <td><%=pro.getName()%></td>
                    <td><%=pro.getPrice()%>TL</td>
                    <td class="addremove">

                            <button name="itemid" value="<%=pro.getId()%>" onclick="callJqueryAjax('<%=pro.getId()%>', 'decrement')" id="itemidButtonAjaxDec" ><i class="fa-solid fa-minus"></i></button>

                               <div class="cnt"><%=pro.getAmount()%></div>

                            <button name="itemid" value="<%=pro.getId()%>" onclick="callJqueryAjax('<%=pro.getId()%>', 'increment')" id="itemidButtonAjaxInc" ><i class="fa-solid fa-plus"></i></button>

                    </td>
                    <td>


                        <button name="itemid" value="<%=pro.getId()%>" onclick="callJqueryAjax('<%=pro.getId()%>', 'delete')" id="itemidButtonAjaxDel" >Delete</button>

                    </td>
                </tr>
                   <%  totalprice+= Integer.parseInt(pro.getAmount())*Double.parseDouble(pro.getPrice());
                     totalquantity += Integer.parseInt(pro.getAmount());
                    }}%>
                <form action="OrderOpsServlet" method="post">
                    <button type="submit">Buy</button>
                </form>

            </table>
        </div>
       
    </div>


</body>
</html>
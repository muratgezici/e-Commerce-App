<%@ page import="Database.Commercial" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://use.fontawesome.com/releases/v6.1.0/css/all.css" rel="stylesheet"  type='text/css'>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dropdown.css">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/profile.css">
    <title>Document</title>
</head>
<body>
<%@ include file = "../headerLoggedinSeller.jsp" %>
    <div class="content">
        <div class="img-edit">
          <form action="">
            
              <button>
                <img src="./img/quickbuy_small.png" alt=""><div><i class="fa fa-pen fa-2xl"> </i></div>
              </button>
           
          </form>
        </div>
        <%
       Commercial comm = (Commercial) session.getAttribute("userObject");
        %>
        <div class="userinfo">
          <p>Company Name: <%=comm.getCname()%></p>
          <p>Company Short Name: <%=comm.getCshortname()%></p>
          <p>Username: <%=comm.getUsername()%></p>
          <p>e-mail: <%=comm.getEmail()%></p>
          <p>Address:
              <%=comm.getAddress()%></p>
            <form action="EditInfoServlet" method="post">
                <button type="submit" name="editflag" value="seller_edit">Edit Information</button>
            </form>
        </div>
      </div>
</body>
</html>
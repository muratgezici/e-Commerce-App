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
</head>
<body>
<%@ include file = "../headerLoggedin.jsp" %>
    <div class="content">
        <div>
            <h3>My Items: </h3>
            <table>
                <tr>
                    <th>Item Name: </th>
                    <th>Item Price: </th>
                    <th>Item Amount: </th>
                    <th>Actions: </th>
                </tr>
                <tr>
                    <td>Nerf Gun</td>
                    <td>227TL</td>
                    <td class="addremove"> <form action="">
                        <button><i class="fa-solid fa-minus"></i></button>2<button><i class="fa-solid fa-plus"></i></button>
                    </form> </td>
                    <td><a href="">Delete</a></td>
                </tr>
            </table>
        </div>
       
    </div>
</body>
</html>
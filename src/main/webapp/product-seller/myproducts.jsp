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
<%@ include file = "../headerLoggedin.jsp" %>
    <div class="content">
        <div>
            <div class="newproduct">
                <h3>My Products</h3><button>Add a New Product</button>
            </div>
            <table>
                <tr>
                    <th>Product Image(Small)</th>
                    <th>Product Name</th>
                    <th>Product Stock</th>
                    <th>Product Price</th>
                    <th>Actions</th>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>
                <tr>
                    <td> <img src="../img/quickbuy.png" alt=""> </td>
                    <td> Nerf Gun </td>
                    <td> 21 </td>
                    <td> 21.11.21 </td>
                    <td>
                        <form class="actionform" action="">
                            <button name="delete" value="0" type="submit">Delete</button>
                            <button name="edit" value="1" type="submit">Edit</button>
                        </form> 
                         </td>
                </tr>

            </table>
        </div>
    </div>
</body>
</html>
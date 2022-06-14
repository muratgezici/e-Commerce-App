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
    <style>
        .content{
            flex-direction: row;
            padding-top: 30px;
            justify-content: baseline;
            align-items:flex-start;
        }
        .content .iteminfo{
            padding: 40px;
            width: 400px;
            
        }
        .content .iteminfo{
            display: flex;
            flex-direction: column;
        }
    </style>
    <title>Document</title>
</head>
<body>
<%@ include file = "../header.jsp" %>
    <div class="content">
        <div><img src="./img/quickbuy.png" alt="">
        <p>Placeholder item header</p>
        <p>Price: 15.00TL</p>
        <button value="Add to cart">Add to cart</button>
</div>
        <div class="iteminfo"><p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Magnam consequuntur ipsam, eum reiciendis obcaecati reprehenderit, accusantium nesciunt saepe molestias voluptate facilis cumque delectus repellat veritatis. Repellat officiis exercitationem ea aliquam?
        Debitis molestiae quisquam explicabo maiores impedit ullam placeat dicta consequuntur odio quibusdam numquam, cum a nobis reiciendis enim delectus nesciunt obcaecati neque adipisci possimus consequatur? Assumenda iure nesciunt neque magnam.
        Quaerat doloremque eius nobis molestias cumque voluptatum aliquid, pariatur impedit fugit veniam totam sit facere delectus quam. Natus atque magnam porro molestias eligendi fugit ipsum corporis modi, rem, exercitationem eaque.</p>
       
    </div>
        
    </div>
</body>
</html>
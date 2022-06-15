<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dropdown.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div><jsp:include page="../header.jsp" /></div>
    <div class="content">
        <form class="loginform" action="MappingServlet" method="post" width="500px">
            <h3>Login</h3>
            <input type="text" placeholder="Username or e-Mail address" name="username">
            <input type="text" placeholder="Password" name="password">
            <div class="checkbox">
                <input type="checkbox" id="usertypeFlag" name="usertypeFlag"><label for="usertypeFlag">Commercial Login</label>
            </div>
            <div>
                <button type="submit" name="direct" value="login"><p>Login</p></button>
                <button type="submit" name="direct" value="register"><p>Register</p></button>
            </div>
        </form>
    </div>
</body>
</html>
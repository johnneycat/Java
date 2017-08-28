<%-- 
    Document   : login
    Created on : Aug 27, 2017, 8:05:14 PM
    Author     : wlw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        
        <form action="doLogin" method="post">
            User Name: <input type="text" name="userName" value="User Name"/>
            <br>
            User PassWord: <input type="password" name="userPwd" />
            <br>
            <input type="submit" name="sb" value="login" />
            
        </form>
    </body>
</html>

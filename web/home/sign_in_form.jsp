<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/sign_in?action=sign_in">
    <table border="1 solid">
        <tr>
            <td>account name:<input type="text"name="userName" placeholder="account name"></td>
        </tr>
        <tr>
            <td>password :<input type="text" name="password" placeholder="password"></td>
        </tr>
    </table>
    <input type="submit">
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/7/2020
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/sign_up?action=sign_up">
    <table border="1 solid">
        <tr>
            <td>account name:<input type="text"name="account" placeholder="account name" required></td>
        </tr>
        <tr>
            <td>password :<input type="text" name="password" placeholder="password" required></td>
        </tr>
        <tr>
            <td>email :<input type="text" name="email" placeholder="email" required></td>
        </tr>
        <tr>
            <td>phone: <input type="number" name="phone" placeholder="phone" required></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>

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
<form method="post">
    <table border="1 solid">
        <tr>
            <td>account name:<input type="text"name="account" placeholder="account name"></td>
        </tr>
        <tr>
            <td>password :<input type="text" name="password" placeholder="password"></td>
        </tr>
        <tr>
            <td>email :<input type="text" name="email" placeholder="email"></td>
        </tr>
        <tr>
            <td>phone: <input type="text" name="phone" placeholder="phone"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>

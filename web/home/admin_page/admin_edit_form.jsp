<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/8/2020
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit product</h2>
<form method="post">
    <table border="1">
        <tr>
            <td>Product`name</td>
            <td>Product`Id</td>
            <td>Product`price</td>
            <td>Product`description</td>
            <td>Product`amount</td>

        </tr>
        <tr>
            <td><input name="name" value="${requestScope["list"].getName()}">   </td>
            <td><input name="id" value="${requestScope["list"].getId()}" type="hidden"> </td>
            <td><input name="price" value="${requestScope["list"].getPrice()}"> </td>
            <td><input name="description" value="${requestScope["list"].getDescription()}"> </td>
            <td><input name="amount" value="${requestScope["list"].getAmount()}">   </td>
        </tr>
    </table>
</form>
<input type="submit" value="Save">
</body>
</html>

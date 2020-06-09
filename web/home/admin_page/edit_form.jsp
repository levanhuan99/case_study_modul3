<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/9/2020
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post" action="/Admin?action=edit">
    <table border="1">
        <tr>
            <td>Product`name</td>
            <td>Product`Id</td>
            <td>Product`price</td>
            <td>Product`description</td>
            <td>Product`amount</td>
            <td>Product`image</td>

        </tr>
        <tr>
            <td><input name="name" value="${requestScope["product1"].getName()}"></td>
            <td><input name="id" value="${requestScope["product1"].getId()}" type="number"></td>
            <td><input name="price" value="${requestScope["product1"].getPrice()}"></td>
            <td><input name="description" value="${requestScope["product1"].getDescription()}"></td>
            <td><input name="amount" value="${requestScope["product1"].getAmount()}"></td>
            <td><input name="image" value="${requestScope["product1"].getImage()}"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/8/2020
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>

<a href="...">Thêm sản phẩm</a>
<table style="border: 1px solid; text-align: center">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>description</td>
        <td>amount</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="list" var="products">
        <tr>
            <td>${requestScope["products"].getName()}</td>
            <td>${requestScope["products"].getPrice()}</td>
            <td>${requestScope["products"].getDescription()}</td>
            <td>${requestScope["products"].getAmount()}</td>
        </tr>
    </c:forEach>


</table>
</body>
</html>

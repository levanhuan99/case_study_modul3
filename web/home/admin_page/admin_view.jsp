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
<form method="get" action="/Edit">
    <table style="border: 1px solid; text-align: center">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>description</td>
            <td>amount</td>
            <td>edit</td>
            <td>delete</td>
        </tr>
        <c:forEach items='${requestScope["list"]}' var="products">
            <tr>
                <td>${products.getName()}</td>
                <td>${products.getPrice()}</td>
                <td>${products.getDescription()}</td>
                <td>${products.getAmount()}</td>
                <td><a href="/Edit?action=edit&id=${products.getId()}" >edit</a></td>
                <td><a href="/Delete?action=delete&id=${products.getId()}">delete</a></td>

            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>

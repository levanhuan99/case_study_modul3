<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/9/2020
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<h2><a href="/Admin?action=add">thêm sản phẩm</a></h2>
<form>
    <table class="table">
        <thead>
        <tr>
            <td scope="col">Product name</td>
            <td scope="col">Product id</td>
            <td scope="col">Product price</td>
            <td scope="col">Product description</td>
            <td scope="col">Product amount</td>
            <td scope="col">File image</td>
            <td scope="col">Edit</td>
            <td scope="col">Delete</td>
        </tr>
        </thead>
        <c:forEach items="${list}" var="product">
        <tr>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getDescription()}"></c:out></td>
            <td><c:out value="${product.getAmount()}"></c:out></td>
            <td><c:out value="${product.getImage()}"></c:out></td>
            <td><a href="/Admin?action=edit&&id=${product.getId()}">edit</a></td>
            <td><a href="/Admin?action=delete&&id=${product.getId()}">delete</a></td>
            </c:forEach>
        </tr>
    </table>

</form>

</body>
</html>

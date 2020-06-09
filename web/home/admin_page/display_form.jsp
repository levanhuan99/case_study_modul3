<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="get" action="/Admin?action=display">
    <table>
        <tr>
            <td>Product name</td>
            <td>Product id</td>
            <td>Product price</td>
            <td>Product description</td>
            <td>Product amount</td>
            <td>File image</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getDescription()}"></c:out></td>
            <td><c:out value="${product.getAmount()}"></c:out></td>
            <td><c:out value="${product.getImage()}"></c:out></td>
            <td ><a href="">edit</a> </td>
            <td><a href="">delete</a> </td>
        </c:forEach>



        </tr>
    </table>

</form>

</body>
</html>

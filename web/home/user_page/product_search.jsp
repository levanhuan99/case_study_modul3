<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/9/2020
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<table>
    <tr>
        <td> Product id </td>
        <td> Product name </td>
        <td> Product price </td>
        <td> Product description </td>
    </tr>
    <c:forEach items="search_list" var="product">
        <tr>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getDescription()}"></c:out></td>
            <td><input type="submit" value="đặt hàng"></td>
        </tr>

    </c:forEach>


</table>
</body>
</html>

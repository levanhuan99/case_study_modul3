<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<table class="table">
    <thead>
    <tr>
        <th scope="col"> Product id</th>
        <th scope="col">Product name</th>
        <th scope="col">Product price</th>
        <th scope="col">Product description</th>
    </tr>
    </thead>
<%--    <tbody>--%>
    <c:forEach items="${search_list}" var="product1">
    <tr>
        <td><c:out value="${product1.getId()}"></c:out></td>
        <td><c:out value="${product1.getName()}"></c:out></td>
        <td><c:out value="${product1.getPrice()}"></c:out></td>
        <td><c:out value="${product1.getDescription()}"></c:out></td>
        <td><input type="submit" value="đặt hàng"></td>
    </tr>

    </c:forEach>
</table>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td> Product id </td>--%>
<%--        <td> Product name </td>--%>
<%--        <td> Product price </td>--%>
<%--        <td> Product description </td>--%>
<%--    </tr>--%>
<%--<c:forEach items="${search_list}" var="product1">--%>
<%--    <tr>--%>
<%--        <td><c:out value="${product1.getId()}"></c:out></td>--%>
<%--        <td><c:out value="${product1.getName()}"></c:out></td>--%>
<%--        <td><c:out value="${product1.getPrice()}"></c:out></td>--%>
<%--        <td><c:out value="${product1.getDescription()}"></c:out></td>--%>
<%--        <td><input type="submit" value="đặt hàng"></td>--%>
<%--    </tr>--%>

<%--</c:forEach>--%>
<%--</table>--%>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/10/2020
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>

        <td>your account name</td>
        <td>your email</td>
        <td>your phone</td>
    </tr>
    <tr>
        <td><c:out value='${requestScope["userInfor"].getAccount()}'></c:out></td>
        <td><c:out value='${requestScope["userInfor"].getEmail()}'></c:out></td>
        <td><c:out value='${requestScope["userInfor"].getPhone()}'></c:out></td>
    </tr>
</table>
</body>
</html>

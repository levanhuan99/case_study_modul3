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
<form method="get">
    <table>
        <tr>

            <td>tên tài khoản</td>
            <td>mật khẩu</td>
            <td>email</td>
            <td>số điện thoại</td>
            <td>sửa thông tin</td>

        </tr>
        <tr>
            <td><c:out value='${requestScope["accountInfor"].getAccount()}'></c:out></td>
            <td><c:out value='${requestScope["accountInfor"].getPassword()}'></c:out></td>
            <td><c:out value='${requestScope["accountInfor"].getEmail()}'></c:out></td>
            <td><c:out value='${requestScope["accountInfor"].getPhone()}'></c:out></td>
            <td><a href="/User?action=edit_user_information&&idEdit=${requestScope["accountInfor"].getId()}">sửa</a></td>
        </tr>
    </table>
</form>

</body>
</html>

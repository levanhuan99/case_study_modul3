<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/11/2020
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit information</title>
</head>
<body>

<form method="post" action="/User?action=edit_information&&idUpdate=${requestScope["user3"].getId()}">
    <table>
        <tr>
            <td>tên tài khoản  </td>
            <td>mật khẩu </td>
            <td>email </td>
            <td>số điện thoại </td>
        </tr>
        <tr>
            <td><input name="account" value="${requestScope["user3"].getAccount()}"></td>
            <td><input name="password" value="${requestScope["user3"].getPassword()}"></td>
            <td><input name="email" value="${requestScope["user3"].getEmail()}"></td>
            <td><input name="phone" value="${requestScope["user3"].getPhone()}"></td>
        </tr>
    </table>
    <input type="submit" value="sửa">
</form>
</body>
</html>

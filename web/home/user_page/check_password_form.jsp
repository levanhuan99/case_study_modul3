<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/11/2020
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check password</title>
</head>
<body>
<form method="post" action="/User?action=check_password&&idToCheck=${requestScope["informationToCheck"].getId()}">
    <table>
        <tr>
            <td><input type="text" name="password" ></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>

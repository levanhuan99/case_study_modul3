<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/9/2020
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h4><a href="admin-view">back to admin page</a> </h4>
<h3>Nhập id của sản phẩm</h3>
<form method="post" action="/Admin?action=delete">
    <input name="id" type="number" placeholder="nhập id ">
    <input type="submit" value="delete" >
</form>

</body>
</html>

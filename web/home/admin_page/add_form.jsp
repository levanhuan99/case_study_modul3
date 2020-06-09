<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/9/2020
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<form method="post" action="/Admin?action=add">
    <table>
        <tr>
            <td>Product name</td>
            <td>Product id</td>
            <td>Product price</td>
            <td>Product description</td>
            <td>Product amount</td>
            <td>File image</td>
        </tr>
        <tr>
            <td><input name="name" type="text"></td>
            <td><input name="id" type="number"></td>
            <td><input name="price" type="text"></td>
            <td><input name="description" type="text"></td>
            <td><input name="amount" type="number"></td>
            <td><input name="image" type="text"></td>

        </tr>
    </table>
    <input type="submit">
</form>


</body>
</html>

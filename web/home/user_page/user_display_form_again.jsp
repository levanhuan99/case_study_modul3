<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css"
          integrity="sha256-46r060N2LrChLLb5zowXQ72/iKKNiw/lAmygmHExk/o=" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <div class="row header">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Trang trủ</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Facebook <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giảm giá</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false">Sản phẩm các loại</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#one">one</a>
                            <a class="dropdown-item" href="#two">two</a>
                            <div role="separator" class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#three">three</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Bản Đồ Cửa Hàng</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" method="post" action="/User?action=search">
                    <input class="form-control mr-sm-2" name="search" placeholder="Tìm Kiếm" aria-label="Search">
                    <input type="submit" value="tìm kiếm">

                </form>
                <%--                <button type="button" class="btn btn-success">Đăng nhập</button>--%>
                <%--                <button type="button" class="btn btn-success">Đăng ký</button>--%>
                <%--                <a href="/sign_in?action=sign_in" style="color:black ">Đăng nhập</a>--%>
                <%--                <a href="/sign_up?action=sign_up" style="color:black ">Đăng ký</a> để thêm phần tên của khách hàng TODO--%>
            </div>
        </nav>
    </div>
    <!--    //header finished-->

    <!--    phần thân hình ảnh-->
    <div class="row">
        <div class="col-sm-9">
            <div class="row">
                <c:forEach items='${requestScope["productList"]}' var="product">
                    <div class="card-group col-sm-4">
                        <div class="card">
                            <img class="card-img-top" src="${product.getImage()}" alt="Card image cap">
                            <div class="card-body">
                                <form method="post" action="/User?action=show_detail&id=${product.getId()}">
                                    <p>${product.getName()}</p><br>
                                    <p>${product.getPrice()}</p><br>
                                    <a href="/AddToCart?productId=${product.getId()}">Đặt hàng</a>
                                    <button type="submit">chi tiết</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="col-sm-3" id="sidebar">

            <div class="list-group">
                <button type="button" class="list-group-item list-group-item-action active">
                </button>
                <button type="button" class="list-group-item list-group-item-action">Danh mục
                </button>
                <button type="button" class="list-group-item list-group-item-action">Rau ăn sống
                </button>
                <button type="button" class="list-group-item list-group-item-action">Rau nấu canh
                </button>
                <button type="button" class="list-group-item list-group-item-action">Rau ăn gỏi
                </button>
                <button type="button" class="list-group-item list-group-item-action">Các loại rau khác
                </button>
            </div>
            <div class="list-group">

                <button type="button" class="list-group-item list-group-item-action active">
                </button>
                <form method="get">
                    <a href="/User?action=customer_information&&customerID=${requestScope["customer2"].getId()}">thông tin
                        tài khoản</a><br>
                    <a href="/User?action=account&&customerID=${requestScope["customer2"].getId()}"> tài khoản</a><br>
                    <a href="/CartController?action=cart&&customerID=${requestScope["customer2"].getId()}">giỏ hàng</a>
                </form>

            </div>
        </div>
    </div>


    <!--    phần thân sidebar-->
    <div class="row">
        <div class="col-sm-12">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>


    <!--footer-->
    <div class="row">
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item active">Về chúng tôi</li>
                <li class="list-group-item">Giới thiệu chung</li>
                <li class="list-group-item">Làm việc với chúng tôi</li>
                <li class="list-group-item">Hoạt động cộng đồng</li>
                <li class="list-group-item">Đối tác</li>
            </ul>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item active">Dịch vụ</li>
                <li class="list-group-item">Tặng quà và gửi quà</li>
                <li class="list-group-item">Chuyển hàng nhanh</li>
                <li class="list-group-item">Tải app trên điện thoại</li>

            </ul>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item active">Hỗ trợ khách hàng</li>
                <li class="list-group-item">Câu hỏi thường gặp</li>
                <li class="list-group-item">Khách hàng thân thiết</li>
                <li class="list-group-item">Thông tin giao hàng</li>
                <li class="list-group-item">Phàn nàn-Khiếu nại</li>
                <li class="list-group-item">Hình thức thanh toán</li>
                <li class="list-group-item">Chính sách đổi trả</li>
                <li class="list-group-item">Chính sách bảo mật thông tin</li>
            </ul>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item active">Thông tin hữu ích</li>
                <li class="list-group-item">Món ăn ngon</li>
                <li class="list-group-item">Một số cách chế biến</li>
                <li class="list-group-item">Cách rửa rau củ quả sạch khuẩn</li>
                <li class="list-group-item">Cách trang trí món ăn ngon</li>
                <li class="list-group-item">Góc nội trợ</li>
            </ul>
        </div>
    </div>

</div>
</body>
</html>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css" integrity="sha256-46r060N2LrChLLb5zowXQ72/iKKNiw/lAmygmHExk/o=" crossorigin="anonymous" />
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
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Sản phẩm các loại</a>
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
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Tìm Kiếm" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit"
                            style="color: white ;border: black">Tìm Kiếm
                    </button>
                </form>
                <button type="button" class="btn btn-success">Đăng nhập</button>
                <button type="button" class="btn btn-success">Đăng ký</button>
            </div>
        </nav>
    </div>
    <!--    //header finished-->

    <!--    phần thân hình ảnh-->
    <div class="row">
        <div class="col-sm-9">
            <div class="card-group">
                <div class="card">
                    <img class="card-img-top" src="download 1.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau húng chó phù hợp cho ăn sống .Thường được sử dụng để ăn với thịt vịt ngan... rất thơm</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 2.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau tía tô thường được sử dụng để ăn sống ,có thể dùng để nấu đậu hoặ 1 số loại canh khác...</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 3.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau canh giới thường được sử dụng để ăn sống,rất mát và thơm phù hợp cho ngày hè nóng lực</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>

                    </div>
                </div>
            </div>
            <div class="card-group">
                <div class="card">
                    <img class="card-img-top" src="download 4.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau dăm thường sử dụng để ăn với trứng vịt lộn hoặc để làm rau gia vị để nấu canh có vị hơi cay rất đặc trưng</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 5.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau ngót dùng để nấu canh vị rất mát và thanh rất vitamin C</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 6.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau thơm vị bạc hà mát lạnh sảng khoái</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>

                    </div>
                </div>
            </div>
            <div class="card-group">
                <div class="card">
                    <img class="card-img-top" src="download 7.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau mùng tơi dùng để nấu canh rất tốt cho tiêu hóa nếu nấu cùng 1 số loại rau canh khác sẽ rất ngon </p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 8.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau muống dùng để nấu rất mát rất phù hợp và ngày hè thêm sấu hoặc tranh vào nước canh thì tuyệt vời</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="download 9.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p>Rau mùi dùng để ăn sống rất dễ ăn và mát</p>
                        <button type="button" class="btn btn-success">Đặt hàng</button>

                    </div>
                </div>
            </div>

        </div>

        <div class="col-sm-3" id="sidebar">

            <div class="list-group" >
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
            <div class="list-group" >
                <button type="button" class="list-group-item list-group-item-action active">
                </button>
                <button type="button" class="list-group-item list-group-item-action">Thông tin cá nhân
                </button>
                <button type="button" class="list-group-item list-group-item-action">Tài khoản
                </button>
                <button type="button" class="list-group-item list-group-item-action">Giỏ hàng
                    <i class="fas fa-shopping-cart"></i>
                </button>
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
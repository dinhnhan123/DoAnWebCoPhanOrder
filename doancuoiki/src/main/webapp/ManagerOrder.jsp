<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <title>Login Form</title>
</head>
<body>
        <div class="container">
            <h2 class="text-center my-4">DANH SÁCH ĐƠN HÀNG</h2>
            <table class="table table-dark table-striped">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Mã đơn hàng</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Số sản phẩm</th>
                    <th scope="col">Tổng giá </th>
                    <th scope="col">Trạng thái </th>
                    <th scope="col">Chi tiết </th>
                </tr>
                </thead>
                <tbody>
                <c:set var="counter" value="0" />
            <c:forEach items="${list}" var="o">
                <c:set var="counter" value="${counter + 1}" />
                <tr>
                    <th scope="row">${counter}</th>
                    <td>#${o.order_code}</td>
                    <td>${o.fullname}</td>
                    <td>${o.total_product_quantity}</td>
                    <td>${o.total_amount}</td>
                    <td>${o.order_status}</td>
                    <td><a href="detailOrder?cid=${o.order_id}">Chi tiết</a></td>

                </tr>
              </c:forEach>
                </tbody>
            </table>
            <a href="http://localhost:8080/doancuoiki/homeControl" style="text-decoration: underline">Trang chủ</a>
        </div>
</body>
</html>


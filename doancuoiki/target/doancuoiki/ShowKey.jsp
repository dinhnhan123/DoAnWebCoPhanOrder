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
    <h2 class="text-center my-4">DANH SÁCH KHÁCH HÀNG</h2>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col">Public Key</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="word-break: break-all !important; width: 800px; white-space: normal !important;">${acc.publicKey}</td>
            <td>${acc.status ? "Hoạt động" : "Vô hiệu hóa"}</td>
            <td>
                <button class="btn btn-success" id="copyButton" onclick="copyToClipboard()">Copy Private Key</button>
            </td>

        </tr>
        </tbody>
    </table>
    <a href="http://localhost:8080/doancuoiki/homeControl" style="text-decoration: underline">Trang chủ</a>
</div>
<script>
    function copyToClipboard() {
        var textarea = document.createElement("textarea");
        textarea.value = "${acc.privateKey}";
        document.body.appendChild(textarea);
        textarea.select();
        document.execCommand('copy');
        document.body.removeChild(textarea);
        var copyButton = document.getElementById("copyButton");
        copyButton.innerHTML = "Copied!";
        setTimeout(function() {
            copyButton.innerHTML = "Copy Private Key";
        }, 2000);
    }
</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN OPERATIONS</title>
<link href="AO.css" rel="stylesheet">
</head>
<body>
<% String name=(String)session.getAttribute("name"); %>
<img src="http://jurnal.id/wp-content/uploads/2018/12/28.-Produk.jpg" 
         alt="Product Image" 
         class="product-img">
<div class="main">
        <div class="head">
            <h1 class="name"><%=name %></h1>
        </div>
        <div class="body">
            <button class="an"><a href="addProduct">Add product</a></button>
            <button class="an"><a href="showproducts">AllProduct Details</a></button>
        </div>
    </div>

</body>
</html>
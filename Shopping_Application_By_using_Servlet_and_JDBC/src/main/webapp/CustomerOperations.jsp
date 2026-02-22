<%@page import="com.DTO.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Shopping</title>
<link href="CO.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
	<%int cId=(int)session.getAttribute("cId");
		String name=(String)session.getAttribute("customer");
		List<Product> list=(List)session.getAttribute("ListOfAllProducts");
		int items=(int)session.getAttribute("cartItems");
		///items-------------------------------------------------------------------------------
		
	%>
	  <div class="decorative-bubbles">
        <div class="bubble" style="background-image: url('https://cdn.pixabay.com/photo/2016/08/14/16/48/internet-1593358_1280.jpg')"></div>
        <div class="bubble" style="background-image: url('https://cdn.pixabay.com/photo/2018/03/27/10/03/online-store-3265497_1280.jpg')"></div>
    </div>

    <div class="main-container">
        <!-- Welcome Section with Animated Background -->
        <div class="hero-section">
            <div class="hero-background"></div>
            <div class="animated-background">
                <div class="floating-image"></div>
                <div class="floating-image"></div>
            </div>
            <div class="hero-content">
                <h1 class="welcome-text">Welcome <%=name %></h1>
                <div class="cart-container">
                    <button class="cart-button">
    	<i class="fas fa-shopping-cart cart-icon"></i>
    	<a href="cartItems?caId=<%=cId %>" class="cart-link">My Cart</a>
    	<span class="cart-counter"><%=items %></span>
		</button>
                </div>
            </div>
        </div>

        <div class="products-table">
            <table class="animated-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Brand</th>
                        <th>Discount</th>
                        <th>Category</th>
                        <th>Stock</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Product p:list){ %>
                    <tr class="product-row">
                        <td><%=p.getpId()%></td>
                        <td><%=p.getpName()%></td>
                        <td><%=p.getpPrice()%></td>
                        <td><%=p.getpBrand()%></td>
                        <td><%=p.getpDiscount()%>%</td>
                        <td><%=p.getpCategory()%></td>
                        <td><%=p.getQuantity()%></td>
                        <td>
                            <div class="action-buttons">
                                <a href='buy?pid=<%=p.getpId()%>' class="buy-button">Buy Now</a>
                                <a href='addtocart?pid=<%=p.getpId()%>' class="cart-add-button">Add Cart</a>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
<%@page import="com.DTO.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL PRODUCT DETAILS</title>
<link href="APD.css" rel="stylesheet">
</head>
<body>
<% List<Product> products=
	(List<Product>)session.getAttribute("ListOfAllProduct") ;%>
	
	<img src="https://icon-library.com/images/e-commerce-icon-png/e-commerce-icon-png-16.jpg" 
     class="ecom-icon" alt="E-commerce Icon">

    
	
	<center>
	
	<div class="mainCon">
		<div class="head">
			<h1>All Product details</h1>
		</div>
		<div class="body">
			<div class="fil">
				<form action="filter">
					<input type="text" placeholder="Enter" name="field"><input class="sub" type="submit">
				</form>
			</div>
			<div class="but">
				<button class="button"><a class="add" href="addproductByAdmin">AddProduct</a></button>
			</div>
			<div class="tab">
				<table>
		                 <tr>
		                 <th hidden="true">PRODUCTID</th>
		                 <th>PRODUCTNAME</th>
		                 <th>PRODUCTPRICE</th>
		                 <th>PRODUCTBRAND</th>
		                 <th>PRODUCTDISCOUNT</th>
		                 <th>PRODUCTCATEGORY</th>
		                 <th>PRODUCTQUANTITY</th>
		                 <th>ACTION</th>
		                 </tr>
		                 <%
		                for(Product p:products){
			                out.print("<tr>");
			                out.print("<td hidden>"+p.getpId()+"</td>");
			                out.print("<td>"+p.getpName()+"</td>");
			                out.print("<td>"+p.getpPrice()+"</td>");
			                out.print("<td>"+p.getpBrand()+"</td>");
			                out.print("<td>"+p.getpDiscount()+"</td>");
			                out.print("<td>"+p.getpCategory()+"</td>");
			                out.print("<td>"+p.getQuantity()+"</td>");
			                out.print("<td><button><a href='update?id="+p.getpId()+"'>Update</button><button><a href='delete?id="+p.getpId()+"'>Delete</button></td>");
			                out.print("</tr>");
		                }
		                %>
		                </table>
			</div>
			
		</div>
		<!-- https://www.pngmart.com/files/11/Online-Portal-E-Commerce-PNG-Clipart.png -->
	</center>
</body>
</html>
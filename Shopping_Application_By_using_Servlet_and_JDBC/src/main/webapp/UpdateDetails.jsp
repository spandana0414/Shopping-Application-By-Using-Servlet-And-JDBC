<%@page import="com.DTO.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE PRODUCT DETAILS</title>\
<link href="UPD.css" rel="stylesheet">
</head>
<body>
	<%Product product=(Product)session.getAttribute("productDetails");
	%>
	 <div class="main-container">
        <div class="product-image-container">
            <img src="https://manuals.plus/wp-content/uploads/2024/03/MOONCOOL-Collapsible-Garden-Wagon-Cart-product.png" 
                 alt="Product Image"
                 class="product-image">
        </div>
        
        <div class="form-container">
            <div class="header">
                <h1>UPDATE PRODUCT DETAILS</h1>
            </div>
            
            <form class="update-form" action="updateDetails">
                <table>
                    <tr>
                        <td><label>PRODUCT NAME:</label></td>
                        <td>
                            <input type="text" placeholder="Enter Product name" 
                                   name="name" value="<%=product.getpName()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>PRODUCT PRICE:</label></td>
                        <td>
                            <input type="number" placeholder="Enter Product Price" 
                                   name="price" value="<%=product.getpPrice()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>PRODUCT BRAND:</label></td>
                        <td>
                            <input type="text" placeholder="Enter Product Brand" 
                                   name="brand" value="<%=product.getpBrand()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>PRODUCT DISCOUNT:</label></td>
                        <td>
                            <input type="number" placeholder="Enter Product Discount" 
                                   name="discount" value="<%=product.getpDiscount()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>PRODUCT CATEGORY:</label></td>
                        <td>
                            <input type="text" placeholder="Enter Product Category" 
                                   name="category" value="<%=product.getpCategory()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>PRODUCT QUANTITY:</label></td>
                        <td>
                            <input type="number" placeholder="Enter Product quantity" 
                                   name="quantity" value="<%=product.getQuantity()%>">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="submit-btn" value="Update Product">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
<%@page import="com.DTO.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buying Products</title>
<link href="BP.css" rel="stylesheet">
</head>
<body>
	<% Product product=
	(Product)session.getAttribute("product") ;%>
	<div class="mainCon">
    <img src="https://png.pngtree.com/png-vector/20240701/ourmid/pngtree-shopping-cart-product-png-image_12951851.png" 
     class="background-deco deco1" alt="cart decoration">
<img src="https://image.freepik.com/free-vector/robot-human-pushing-trolley-carts-full-groceries-robotic-character-vs-man-standing-together-grocery-shop-artificial-intelligence-technology-shopping-concept-flat-full-length-horizontal_48369-23102.jpg" 
     class="background-deco deco2" alt="robot illustration">
    <div class="head">PRODUCT DETAILS</div>
    
    <div class="product-container">
        <div class="product-image">
            <img src="https://friendlystock.com/wp-content/uploads/2020/05/8-black-woman-paying-with-cash-cartoon-clipart.jpg" 
                 alt="Product Image">
        </div>
        
        <div class="product-info">
            <table>
                <tr>
                    <td>PRODUCT NAME:</td>
                    <td><%=product.getpName() %></td>
                </tr>
                <tr>
                    <td>PRODUCT PRICE:</td>
                    <td><%=product.getpPrice() %></td>
                </tr>
                <tr>
                    <td>PRODUCT BRAND:</td>
                    <td><%=product.getpBrand() %></td>
                </tr>
                <tr>
                    <td>PRODUCT DISCOUNT:</td>
                    <td><%=product.getpDiscount() %>%</td>
                </tr>
                <tr>
                    <td>PRODUCT CATEGORY:</td>
                    <td><%=product.getpCategory() %></td>
                </tr>
                <tr  class="amount-payable">
                    <td>AMOUNT PAYABLE:</td>
                    <td>
                        <% double amountPay=product.getpPrice()-(product.getpPrice()*(product.getpDiscount())/100);
                            session.setAttribute("ammountpay", amountPay);
                            session.setAttribute("pQuant", product.getQuantity());
                            session.setAttribute("prodId", product.getpId());
                        %>
                        <%=amountPay %>
                    </td>
                </tr>
            </table>
       </div>
       </div>
       

        <div class="payment-form">
        <form action="ammount">
            <table class="form-table">
                    <tr>
                        <td>ENTER AMOUNT:</td>
                        <td><input type="number" placeholder="Enter Amount" name="ammount" required></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="sub" value="Proceed to Payment"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT DETAILS</title>
<link href="PD.css" rel="stylesheet">
</head>
<body>
	<img src="https://5.imimg.com/data5/TestImages/DQ/QD/DB/SELLER-1595812/e-commerce-shopping-cart-application-services-500x500.png" 
     class="deco-image deco1" alt="Cart decoration">
<img src="https://i.pinimg.com/originals/4e/59/ab/4e59aba6c690660ebf496c87d490fe9e.jpg" 
     class="deco-image deco2" alt="Truck decoration">
        <div class="head">
            <h1>ENTER PRODUCT DETAILS</h1>
        </div>
        <div class="body">
            <form class="form" action="productDetails">
                <table>
                    <tr>
                        <td>PRODUCT NAME:</td>
                        <td><input type="text" placeholder="Enter Product name" name="name"></td>
                    </tr>
                    <tr>
                        <td>PRODUCT PRICE:</td>
                        <td><input type="number" placeholder="Enter Product Price" name="price"></td>
                    </tr>
                    <tr>
                        <td>PRODUCT BRAND:</td>
                        <td><input type="text" placeholder="Enter Product Brand" name="brand"></td>
                    </tr>
                    <tr>
                        <td>PRODUCT DISCOUNT:</td>
                        <td><input type="number" placeholder="Enter Product Discount" name="discount"></td>
                    </tr>
                    <tr>
                        <td>PRODUCT CATEGORY:</td>
                        <td><input type="text" placeholder="Enter Product Category" name="category"></td>
                    </tr>
                    <tr>
                        <td>PRODUCT QUANTITY:</td>
                        <td><input type="number" placeholder="Enter Product quantity" name="quantity"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input class="sub" type="submit" value="Submit Product">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
	
</body>
</html>
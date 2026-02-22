<%@page import="java.util.ArrayList"%>
<%@page import="com.DTO.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy the Products</title>
<link href="CPB.css" rel="stylesheet">
</head>
<body>
 <div class="mainCon">
        <form action="checkTotalAmmount">
            <table class="cart-table">
                <tr>
                    <th>PRODUCTNAME</th>
                    <th>PRODUCTPRICE</th>
                    <th>PRODUCTBRAND</th>
                    <th>PRODUCTDISCOUNT</th>
                    <th>PRODUCTCATEGORY</th>
                    <th>PRODUCTQUANTITY</th>
                    <th>PRODUCTPRICE</th>
                </tr>
                <% 
                double totalAmmount=0;
                List<Product> listOfProductsInCart= 
                (List<Product>)session.getAttribute("listOfProductsInCart");
                int cId=(int)session.getAttribute("cId");
                List<Integer>pids=new ArrayList<Integer>();
                for(Product p:listOfProductsInCart){
                    if(p.getQuantity()>0){
                out.print("<tr>");
                pids.add(p.getpId());
                out.print("<td>"+p.getpName()+"</td>");
                out.print("<td>"+p.getpPrice()+"</td>");
                out.print("<td>"+p.getpBrand()+"</td>");
                out.print("<td>"+p.getpDiscount()+"</td>");
                out.print("<td>"+p.getpCategory()+"</td>");
                out.print("<td>"+p.getQuantity()+"</td>");
                double ammountPay=p.getpPrice()-(p.getpPrice()*(p.getpDiscount())/100);
                    totalAmmount+=ammountPay;
                out.print("<td>"+ammountPay+"</td>");
                out.print("</tr>");
                    }
                }
                %>
            </table>

            <div class="total-section">
                <div class="total-amount">
                    TOTALAMMOUNT: <%=totalAmmount %>
                </div>
                <div>
                    <input type="number" 
                           name="totalAmmount" 
                           placeholder="Enter ammount"
                           required>
                </div>
            </div>

            <% session.setAttribute("tA", totalAmmount); 
                session.setAttribute("cId", cId);
                session.setAttribute("pIds", pids);
            %>
            <input type="submit" class="sub" value="Confirm Payment">
        </form>
    </div>
	
</body>
</html>
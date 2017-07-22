<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:useBean id="product" class="test.beans.Product" scope="session"></jsp:useBean>
	<jsp:useBean id="customer" class="test.beans.Customer" scope="session"></jsp:useBean>
	<jsp:useBean id="creditCard" class="test.beans.CreditCard" scope="session"></jsp:useBean>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirmation Page</title>
	</head>
	<body>
		<h1>Confirmation Page</h1>
		<form NAME="Confirmation" ACTION="/ProjectSales/PurchasingServlet" METHOD="POST">
			<table style="float: left;">
				<tr>
					<th>Customer Information</th>
				</tr>
				<tr>
					<td>Name</td>
					<td><jsp:getProperty name="customer" property="name"/></td>
				</tr>
				<tr>
					<td>Street Address</td>
					<td><jsp:getProperty name="customer" property="address"/></td>
				</tr>
				<tr>
					<td>City</td>
					<td><jsp:getProperty name="customer" property="city"/></td>
				</tr>
				<tr>
					<td>State</td>
					<td><jsp:getProperty name="customer" property="state"/></td>
				</tr>
				<tr>
					<td>Zipcode</td>
					<td><jsp:getProperty name="customer" property="zipcode"/></td>
				</tr>
			</table>
			
			<table style="float: left;">
				<tr>
					<th>Product Information</th>
				</tr>
				<tr>
					<td>Product ID</td>
					<td><jsp:getProperty name="product" property="productId"/></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><jsp:getProperty name="product" property="productName"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><jsp:getProperty name="product" property="price"/></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><jsp:getProperty name="product" property="quantity"/></td>
				</tr>
				<tr>
					<td>Total Price</td>
					<td><b><jsp:getProperty name="product" property="totalPrice"/></b></td>
				</tr>
			</table>
			
			<table style="float: left;">
				<tr>
					<th>Credit Card Information</th>
				</tr>
				<tr>
					<td>Credit Card Number</td>
					<td><jsp:getProperty name="creditCard" property="ccNumber"/></td>
				</tr>
				<tr>
					<td>Expiration Date</td>
					<td><jsp:getProperty name="creditCard" property="expirationDate"/></td>
				</tr>
				<tr>
					<td>Billing Address</td>
					<td><jsp:getProperty name="creditCard" property="billingAddress"/></td>
				</tr>
				<tr>
					<td>Billing City</td>
					<td><jsp:getProperty name="creditCard" property="billingCity"/></td>
				</tr>
				<tr>
					<td>Billing State</td>
					<td><jsp:getProperty name="creditCard" property="billingState"/></td>
				</tr>
				<tr>
					<td>Billing Zipcode</td>
					<td><jsp:getProperty name="creditCard" property="billingZipcode"/></td>
				</tr>
				<tr>
					<td>Security Code</td>
					<td><jsp:getProperty name="creditCard" property="securityCode"/></td>
				</tr>
				<tr>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="CC Return"></TD>
				</tr>
			</table>
		</form>
	</body>
</html>
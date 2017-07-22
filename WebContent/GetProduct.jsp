<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:useBean id="product" class="test.beans.Product" scope="session"></jsp:useBean>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product</title>
	</head>
	<body>
		<h1>Product Page</h1>
		<FORM NAME="GetProduct" ACTION="/ProjectSales/PurchasingServlet" METHOD="POST">
			<TABLE>
				<TR ALIGN="left">
					<TH>Product ID:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="productId" VALUE="<%= product.getProductId() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Product Name:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="productName" VALUE="<%= product.getProductName() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Price:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="price" VALUE="<%= product.getPrice() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Quantity:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="quantity" VALUE="<%= product.getQuantity() %>"></TD>
				</TR>
				<TR>
					<TR ALIGN=left>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="Purchase"></TD>
				</TR>
			</TABLE>
		</FORM>
	</body>
</html>
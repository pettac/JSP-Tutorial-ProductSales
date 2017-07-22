<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:useBean id="customer" class="test.beans.Customer" scope="session"></jsp:useBean>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer</title>
	</head>
	<body>
		<h1>Customer Page</h1>
		<FORM NAME="GetCustomer" ACTION="/ProjectSales/PurchasingServlet" METHOD="POST">
			<TABLE>
				<TR ALIGN="left">
					<TH>Name:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="name" VALUE="<%= customer.getName() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Address:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="address" VALUE="<%= customer.getAddress() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>City:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="city" VALUE="<%= customer.getCity() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>State:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="state" VALUE="<%= customer.getState() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Zipcode:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="zipcode" VALUE="<%= customer.getZipcode() %>"></TD>
				</TR>
				<TR>
					<TR ALIGN=left>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="Accept Customer"></TD>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="Product Return"></TD>
				</TR>
			</TABLE>
		</FORM>
	</body>
</html>
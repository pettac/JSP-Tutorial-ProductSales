<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:useBean id="creditCard" class="test.beans.CreditCard" scope="session"></jsp:useBean>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Credit Card</title>
	</head>
	<body>
		<h1>Credit Card Page</h1>
		<FORM NAME="GetCCData" ACTION="/ProjectSales/PurchasingServlet" METHOD="POST">
			<TABLE>
				<TR ALIGN="left">
					<TH>Credit Card Number:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="ccNumber" VALUE="<%= creditCard.getCcNumber() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Expiration Date:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="expirationDate" VALUE="<%= creditCard.getExpirationDate() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Billing Address:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="billingAddress" VALUE="<%= creditCard.getBillingAddress() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Billing City:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="billingCity" VALUE="<%= creditCard.getBillingCity() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Billing State:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="billingState" VALUE="<%= creditCard.getBillingState() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Billing Zipcode:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="billingZipCode" VALUE="<%= creditCard.getBillingZipcode() %>"></TD>
				</TR>
				<TR ALIGN="left">
					<TH>Security Code:</TH>
					<TD><INPUT TYPE="text" SIZE="20" MAXLENGTH="30" NAME="securityCode" VALUE="<%= creditCard.getSecurityCode() %>"></TD>
				</TR>
				<TR>
					<TR ALIGN=left>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="Bill CC"></TD>
					<TD><INPUT TYPE="submit" NAME="action" VALUE="Customer Return"></TD>
				</TR>
			</TABLE>
		</FORM>
	</body>
</html>
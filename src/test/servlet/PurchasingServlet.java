package test.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.beans.CreditCard;
import test.beans.Customer;
import test.beans.Product;

/**
 * Servlet implementation class PurchasingServlet
 */
@WebServlet("/PurchasingServlet")
public class PurchasingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchasingServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		writeGetProductHtml(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//form input is used to read the data in the form and return it
		Properties formInput = getFormInput(request);
		HttpSession session = request.getSession(true);
		//check if there is already a session
		if (session == null) {
			request.setAttribute("msg", "Could not find or create Session");
			writeErrorHtml(request, response);
		} else {
			//create empty objects
			Customer customer = null;
			Product product = null;
			CreditCard creditCard = null;
			
			//checks if the Purchase button was pressed on the GetProduct.jsp page. action is the id of the 
			//button and Purchase is the name of the button
			if (formInput.getProperty("action").equals("Purchase")) {
				//calls parseProduct method and passes formInput. parseProduct takes the data from the
				//formInput and places them in the set methods of the beans
				product = parseProduct(formInput);
				//checks if the object returned from parseProduct has data or is null. If it is null then it will 
				//create an error message and call Error.jsp
				if (product == null) {
					request.setAttribute("msg", "The input form has no Product!");
					writeErrorHtml(request, response);
				} else {	//if not null then the product attributes are set for the session
					session.setAttribute("product", product);
					//create and call Customer.jsp
					writeGetCustomerHtml(request, response);
				}
				//handles accept customer button from Customer.jsp
			} else if (formInput.getProperty("action").equals("Accept Customer")) {
				customer = parseCustomer(formInput);
				if (customer == null) {
					request.setAttribute("msg", "The input form has no Customer!");
					writeErrorHtml(request, response);
				} else {
					session.setAttribute("customer", customer);
					writeGetCCDataHtml(request, response);
				}
				//handles product return button on Customer.jsp
			} else if (formInput.getProperty("action").equals("Product Return")) {
				writeGetProductHtml(request, response);
				//handles Bill CC button on CreditCard.jsp
			} else if (formInput.getProperty("action").equals("Bill CC")) {
				creditCard = parseCreditCard(formInput);
				if (creditCard == null) {
					request.setAttribute("msg",
							"The input form has no CreditCard!");
					writeErrorHtml(request, response);
				} else {
					session.setAttribute("creditCard", creditCard);
					writeConfirmationHtml(request, response);
				}
				//handles Customer Return button on CreditCard.jsp
			} else if (formInput.getProperty("action").equals("Customer Return")) {
				writeGetCustomerHtml(request, response);
				//handles CC Return button on Confirmation.jsp
			} else if (formInput.getProperty("action").equals("CC Return")) {
				writeGetCCDataHtml(request, response);
			}
		}
	}

	private void writeConfirmationHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
	}

	private void writeGetProductHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/GetProduct.jsp").forward(request, response);
	}

	private void writeGetCCDataHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/CreditCard.jsp").forward(
				request, response);
		;
	}

	private void writeGetCustomerHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Customer.jsp").forward(
				request, response);
	}

	private void writeErrorHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Error.jsp").forward(request,
				response);
	}

	/*
	 * The parse methods receive a formInput of type Properties.
	 * formInput contains the data that the user typed into the form.
	 * First each if loop will check that the field is not null and that
	 * the length is greater than zero. Then it access the set methods
	 * from the javabeans and sets the value. This is done for each row from
	 * the table. Finally the object gets returned to the method call
	 */
	private Product parseProduct(Properties formInput) {

		Product product = new Product();
		boolean containsData = false;

		String productID = formInput.getProperty("productId");
		if ((productID != null) && (productID.length() > 0)) {
			product.setProductId(productID);
			containsData = true;
		}

		String productName = formInput.getProperty("productName");
		if ((productName != null) && (productName.length() > 0)) {
			product.setProductName(productName);
			containsData = true;
		}

		String price = formInput.getProperty("price");
		if ((price != null) && (price.length() > 0)) {
			product.setPrice(price);
			containsData = true;
		}

		String quantity = formInput.getProperty("quantity");
		if ((quantity != null) && (quantity.length() > 0)) {
			product.setQuantity(quantity);
			containsData = true;
		}
		
		product.setTotalPrice();

//		String totalPrice = formInput.getProperty("totalPrice");
//		if ((totalPrice != null) && (totalPrice.length() > 0)) {
//			product.setTotalPrice();
//			containsData = true;
//		}

		if (!containsData)
			product = null;

		return product;
	}

	private Customer parseCustomer(Properties formInput) {

		Customer customer = new Customer();
		boolean containsData = false;

		String name = formInput.getProperty("name");
		if ((name != null) && (name.length() > 0)) {
			customer.setName(name);
			containsData = true;
		}

		String address = formInput.getProperty("address");
		if ((address != null) && (address.length() > 0)) {
			customer.setAddress(address);
			containsData = true;
		}

		String city = formInput.getProperty("city");
		if ((city != null) && (city.length() > 0)) {
			customer.setCity(city);
			containsData = true;
		}

		String state = formInput.getProperty("state");
		if ((state != null) && (state.length() > 0)) {
			customer.setState(state);
			containsData = true;
		}

		String zipcode = formInput.getProperty("zipcode");
		if ((zipcode != null) && (zipcode.length() > 0)) {
			customer.setZipcode(zipcode);
			containsData = true;
		}

		if (!containsData)
			customer = null;

		return customer;
	}

	private CreditCard parseCreditCard(Properties formInput) {

		CreditCard creditCard = new CreditCard();
		boolean containsData = false;

		String cCNumber = formInput.getProperty("ccNumber");
		if ((cCNumber != null) && (cCNumber.length() > 0)) {
			creditCard.setCcNumber(cCNumber);
			containsData = true;
		}

		String expirationDate = formInput.getProperty("expirationDate");
		if ((expirationDate != null) && (expirationDate.length() > 0)) {
			creditCard.setExpirationDate(expirationDate);
			containsData = true;
		}

		String billingAddress = formInput.getProperty("billingAddress");
		if ((billingAddress != null) && (billingAddress.length() > 0)) {
			creditCard.setBillingAddress(billingAddress);
			containsData = true;
		}

		String billingCity = formInput.getProperty("billingCity");
		if ((billingCity != null) && (billingCity.length() > 0)) {
			creditCard.setBillingCity(billingCity);
			containsData = true;
		}

		String billingState = formInput.getProperty("billingState");
		if ((billingState != null) && (billingState.length() > 0)) {
			creditCard.setBillingState(billingState);
			containsData = true;
		}

		String billingZipCode = formInput.getProperty("billingZipCode");
		if ((billingZipCode != null) && (billingZipCode.length() > 0)) {
			creditCard.setBillingZipcode(billingZipCode);
			containsData = true;
		}

		String securityCode = formInput.getProperty("securityCode");
		if ((securityCode != null) && (securityCode.length() > 0)) {
			creditCard.setSecurityCode(securityCode);
			containsData = true;
		}

		if (!containsData)
			creditCard = null;

		return creditCard;
	}
	
	/*
	 * getFormInput receives the Http request and uses it to assign
	 * the paramater names and values by enumerating over the input
	 * fields of the form
	 */
	private Properties getFormInput(HttpServletRequest request) {
		Properties formInput = new Properties();
		Enumeration<String> e = request.getParameterNames();
		String paramName = null;
		String paramValue = null;
		while (e.hasMoreElements()) {
			paramName = (String) e.nextElement();
			paramValue = (String) request.getParameter(paramName);
			formInput.put(paramName, paramValue);
		}

		return formInput;

	}

}

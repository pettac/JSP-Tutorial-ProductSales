package test.beans;

import java.io.Serializable;

public class CreditCard implements Serializable {
	
	private String ccNumber;
	private String expirationDate;
	private String billingAddress;
	private String billingCity;
	private String billingState;
	private String billingZipCode;
	private String securityCode;
	
	public CreditCard() {
		
	}
	
	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZipcode() {
		return billingZipCode;
	}

	public void setBillingZipcode(String billinbZipcode) {
		this.billingZipCode = billinbZipcode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	


}

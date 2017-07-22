package test.beans;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
	
	private String productId;
	private String productName;
	private String price;
	private String quantity;
	private String totalPrice;

	public Product() {
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		double priceMath = Double.parseDouble(this.price)*Double.parseDouble(this.quantity);
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		this.totalPrice = formatter.format(priceMath);
	}

}

package com.example.orders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OrderRequestDTO {		

    @NotBlank(message = "customerName must not be blank")
    @Size(min = 3)
    private String customerName;

    @NotBlank(message = "email must not be blank")
    @Email
    private String email;

    @NotBlank(message = "productName must not be blank")
    private String productName;

    @Min(value = 1, message = "quantity must be greater than 0")
    private int quantity;

    @Min(value = 1, message = "pricePerUnit must be greater than 0")
    private double pricePerUnit;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

    
    
}

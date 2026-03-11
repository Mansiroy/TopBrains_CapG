package com.cg.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

//We can add the dependencies of lombok so, we can't add getters setters constructor manually. this dependencies give all the functions.

@Entity
@Table(name = "product_table")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
	@Id
	private int pid;
	private String name;
	private int qty;
	private int price;
	private LocalDate mfd;
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", qty=" + qty + ", price=" + price + ", mfd=" + mfd + "]";
	}
	
	
	
}

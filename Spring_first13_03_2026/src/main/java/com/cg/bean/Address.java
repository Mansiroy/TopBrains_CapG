//package com.cg.bean;
//
//public class Address {
//	private String city;
//	private String country;
//	private long zip;
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public long getZip() {
//		return zip;
//	}
//
//	public void setZip(long zip) {
//		this.zip = zip;
//	}
//
//}

package com.cg.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Value("${emp.city}")
    private String city;

    public String getCity() {
        return city;
    }
    
    @Value("${emp.country}")
    private String country;

    public String getCountry() {
        return country;
    }
    
    @Value("${emp.zip}")
    private String zip;

    public String getZip() {
        return zip;
    }
}
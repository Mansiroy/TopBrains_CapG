package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("cng")
public class CNGEngine implements IEngine {
	 public String getBHP() {
		  return "110 BHP";
}
}
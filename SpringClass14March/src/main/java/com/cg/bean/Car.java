package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

//LOOSE COUPLING is always achieve by interfaces.


@Component
//@Service
//@Repository
public class Car {
	@Value("${carname}")
	private String name;
//	private IEngine Engine;
//	private ITyre Tyre;

	@Autowired
	@Qualifier("cng")
	private IEngine cng;
	
	@Autowired // here it is by default bytype autowiring, so it will look for the IEngine type and inject the dependency.
	private ITyre mrf;
	
//	private PetrolEngine petrolEngine;
//	private MrfTyre mrfTyre;
	
	 public Car() {}

//	    public Car(IEngine engine, ITyre tyre) {
//	    	super();
//	    	this.Engine = engine;
//	    	this.Tyre = tyre;
//	    }

//	 @Autowired  // Constructor-based dependency injection, it will by default use the bytype autowiring to inject the dependencies, written on the constructor when we don't write the @Autwire on the 
	 public Car(@Qualifier("cng") IEngine cng, @Qualifier("jk")  ITyre mrf) {
	    	super();
	        this.cng = cng;
	        this.mrf = mrf;
	    }
//	 @Autowired  // Constructor-based dependency injection, it will by default use the bytype autowiring to inject the dependencies.
//	 public Car(@Qualifier("cng") IEngine cng, @Qualifier("jk")  ITyre mrf) {
//		 super();
//		 this.cng = cng;
//		 this.mrf = mrf;
//	 }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

//	    public IEngine getEngine() {
//	        return Engine;
//	    }
//
//	    public void setEngine(IEngine engine) {
//	        this.Engine = engine;
//	    }

	    public IEngine getCNG() {
	        return cng;
	    }

	    public void setCNG(IEngine cng) {
	        this.cng = cng;
	    }

//	    public ITyre getTyre() {
//	        return Tyre;
//	    }
//
//	    public void setTyre(ITyre tyre) {
//	        this.Tyre = tyre;
//	    }

	    public ITyre getMRF() {
	        return mrf;
	    }

	    public void setMRF(ITyre mrf) {
	        this.mrf = mrf;
	    }

	    public void printCar() {
	        System.out.println("Car Name: " + name);
	        System.out.println("Engine BHP: " + cng.getBHP());
	        System.out.println("Tyre Details: " + mrf.getTyreDetails());
	    }
	
	
}
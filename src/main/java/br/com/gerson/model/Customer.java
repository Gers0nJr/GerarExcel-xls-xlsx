package br.com.gerson.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
	
	  private Long id;
	  
	  private String name;
	  
	  private String address;
	  
	  private int age;
	 
	  public Customer() {
	  }
	 
	  public Customer(Long id, String name, String address, int age) {
	    this.id = id;
	    this.name = name;
	    this.address = address;
	    this.age = age;
	  }
	 
	  @Override
	  public String toString() {
	    return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	  }
	 
	}
package com.spring.model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CategoryTable")
public class Category implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 @OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="category")
	 
	 private Set<Product> product=new HashSet<Product>(0);
	
	 
	

} 


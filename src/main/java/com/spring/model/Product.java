package com.spring.model;

import java.io.Serializable;


import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Product  implements Serializable
{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
private int pid;
private String pname;
private String pdescription;
private double price;
private int pstock;
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="cid")
private Category category;

 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="sid")
 private Supplier supplier;
 @Transient
 MultipartFile pimage;
private String imgName;
public int getPid() {
	return pid;
}
public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPdescription() {
	return pdescription;
}
public void setPdescription(String pdescription) {
	this.pdescription = pdescription;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getPstock() {
	return pstock;
}
public void setPstock(int pstock) {
	this.pstock = pstock;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public String getImgName() {
	return imgName;
}
public void setImgName(String imgName) {
	this.imgName = imgName;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
} 

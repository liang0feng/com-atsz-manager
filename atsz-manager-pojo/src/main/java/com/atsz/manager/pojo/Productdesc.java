package com.atsz.manager.pojo;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "productdesc")
public class Productdesc implements Serializable {
	
	@Id// 对应product表中的id
	@Column(name = "id")
	private Long id;

	@Column(name = "productdesc")
	private String productdesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
}

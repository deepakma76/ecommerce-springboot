package com.ecommerce.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "orderitemid", nullable = false, unique = true)
	private Long orderitemid;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "orderid", nullable = false) private Orders orders;
	 */

	@Column(name = "orderid", nullable = false)
	private Long orderid;

	@Column(name = "product", nullable = false)
	private String product;

	public Long getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(Long orderitemid) {
		this.orderitemid = orderitemid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}

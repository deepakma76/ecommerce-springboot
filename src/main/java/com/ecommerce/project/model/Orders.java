package com.ecommerce.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
//@SecondaryTable(name = "orderitems", pkJoinColumns = @PrimaryKeyJoinColumn(name = "orderid"))
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "orderid", nullable = false, unique = true)
	private Long orderid;

	@Column(name = "name")
	private String name;

	@Column(name = "phone", nullable = false, length = 10)
	private String phone;

	@Column(name = "address")
	private String address;

	/*
	 * @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, orphanRemoval =
	 * false) private List<OrderItems> orderitemlist = new ArrayList<>();
	 */

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

}

package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	int cid;
	String cname;
	String ccountry;
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
	public String getCcountry() {
		return ccountry;
	}
	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}
	public Currency(int cid, String cname, String ccountry) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ccountry = ccountry;
	}
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Currency [cid=" + cid + ", cname=" + cname + ", ccountry=" + ccountry + "]";
	}

}

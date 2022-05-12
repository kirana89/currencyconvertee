package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tid;
	private double initAmt;
	private String fromcurrency;
	private String tocurrency;
	private double finalAmt;
	public Transaction(long tid, double initAmt, String fromcurrency, String tocurrency, double finalAmt) {
		super();
		this.tid = tid;
		this.initAmt = initAmt;
		this.fromcurrency = fromcurrency;
		this.tocurrency = tocurrency;
		this.finalAmt = finalAmt;
	}
	public Transaction() {
		super();
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public double getInitAmt() {
		return initAmt;
	}
	public void setInitAmt(double initAmt) {
		this.initAmt = initAmt;
	}
	public String getFromcurrency() {
		return fromcurrency;
	}
	public void setFromcurrency(String fromcurrency) {
		this.fromcurrency = fromcurrency;
	}
	public String getTocurrency() {
		return tocurrency;
	}
	public void setTocurrency(String tocurrency) {
		this.tocurrency = tocurrency;
	}
	public double getFinalAmt() {
		return finalAmt;
	}
	public void setFinalAmt(double finalAmt) {
		this.finalAmt = finalAmt;
	}
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", initAmt=" + initAmt + ", fromcurrency=" + fromcurrency + ", tocurrency="
				+ tocurrency + ", finalAmt=" + finalAmt + "]";
	}
	
	
	
	

}

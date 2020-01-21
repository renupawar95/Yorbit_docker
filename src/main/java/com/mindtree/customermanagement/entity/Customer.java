package com.mindtree.customermanagement.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private double PhoneNum;
	private Date checkInDate;
	private Date checkOutDate;
	private String roomType;
	private String hobby;
	private String gender;
	private String comments;
	private String emailId;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Hotel hotel;

	public Customer() {
		super();
	}

	public Customer(int customerId, @UniqueElements String customerName, double phoneNum, Date checkInDate,
			Date checkOutDate, String roomType, String hobby, String gender, String comments, String emailId,
			Hotel hotel) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		PhoneNum = phoneNum;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.hobby = hobby;
		this.gender = gender;
		this.comments = comments;
		this.emailId = emailId;
		this.hotel = hotel;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(double phoneNum) {
		PhoneNum = phoneNum;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}

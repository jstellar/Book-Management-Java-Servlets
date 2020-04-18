package com.user;

import java.util.Date;

public class User {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private Date departureDate;
	private Date arrivalDate;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	public User(Integer userId, String firstName, String lastName, Date dob, Date departureDate, Date arrivalDate,
			String phoneNumber, String email, String username, String password) {

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User(String firstName, String lastName, Date dob, Date departureDate, Date arrivalDate, String phoneNumber,
			String email, String username, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User() {

	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}	
	
	
}

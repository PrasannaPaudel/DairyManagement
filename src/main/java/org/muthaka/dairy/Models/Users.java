package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
@Entity @Table(name = "users") public class Users implements Serializable {

	@Id @Column(name = "userId") private int UserId;
	@Column(name = "userUuid") private String userUuid;
	@Column(name = "firstname") private String firstname;
	@Column(name = "secondname") private String secondname;
	@Column(name = "lastname") private String lastname;
	@Column(name = "gender") private String gender;
	@Column(name = "idnumber") private int idnumber;
	@Column(name = "residence") private String residence;
	@Column(name = "phonenumber") private int phonenumber;
	@Column(name = "email") private String email;
	@Column(name = "dateOfBirth") private String dateOfBirth;
	@Column(name = "nextOfKinFirstname") private String nextOfKinFirstname;
	@Column(name = "nextOfKinSecondname") private String nextOfKinSecondname;
	@Column(name = "nextOfKinContacts") private int nextOfKinContacts;
	@Column(name = "dateCreated") private String dateCreated;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNextOfKinFirstname() {
		return nextOfKinFirstname;
	}

	public void setNextOfKinFirstname(String nextOfKinFirstname) {
		this.nextOfKinFirstname = nextOfKinFirstname;
	}

	public String getNextOfKinSecondname() {
		return nextOfKinSecondname;
	}

	public void setNextOfKinSecondname(String nextOfKinSecondname) {
		this.nextOfKinSecondname = nextOfKinSecondname;
	}

	public int getNextOfKinContacts() {
		return nextOfKinContacts;
	}

	public void setNextOfKinContacts(int nextOfKinContacts) {
		this.nextOfKinContacts = nextOfKinContacts;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}

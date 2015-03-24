package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity @Table(name = "cowRegistration") public class CowRegistration implements Serializable {
	@Id @Column(name = "cowNo") private int cowNo;
	@Id @Column(name = "cowId") private String cowId;
	//    @Column(name = "cowUuid") private Integer cowUuid;
	@Column(name = "breed") private String breed;
	@Column(name = "gender") private String gender;
	@Column(name = "dob") private String dob;
	@Column(name = "relatedTo") private String relatedTo;
	@Column(name = "relationship") private String relationship;
	@Column(name = "Status") private String status;
	@Column(name = "date") private String date;


	//    public Integer getCowUuid() {
	//        return cowUuid;
	//    }
	//
	//    public void setCowUuid(Integer cowUuid) {
	//        this.cowUuid = cowUuid;
	//    }

	public int getCowNo() {
		return cowNo;
	}

	public void setCowNo(int cowNo) {
		this.cowNo = cowNo;
	}

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRelatedTo() {
		return relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

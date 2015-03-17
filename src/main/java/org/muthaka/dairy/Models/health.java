package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity @Table(name = "healthRecords") public class Health implements Serializable {
	@Id @Column(name = "healthId") private int healthId;
	@Column(name = "cowId") private int cowId;
	@Column(name = "diseaseType") private String diseaseType;
	@Column(name = "symptoms") private String symptoms;
	@Column(name = "medicine") private String medicine;
	@Column(name = "treatmentCost") private String treatmentCost;
	@Column(name = "date") private String date;

	public int getHealthId() {
		return healthId;
	}

	public void setHealthId(int healthId) {
		this.healthId = healthId;
	}

	public int getCowId() {
		return cowId;
	}

	public void setCowId(int cowId) {
		this.cowId = cowId;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getTreatmentCost() {
		return treatmentCost;
	}

	public void setTreatmentCost(String treatmentCost) {
		this.treatmentCost = treatmentCost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

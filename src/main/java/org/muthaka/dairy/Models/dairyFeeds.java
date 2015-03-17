package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity @Table(name = "dairyFeeds") public class DairyFeeds implements Serializable {

	@Id @Column(name = "dairyId") private int dairyId;
	@Column(name = "cowId") private String cowId;
	@Column(name = "mealType") private String mealType;
	@Column(name = "quantity") private String quantity;
	@Column(name = "date") private String date;

	public Integer getDairyId() {
		return dairyId;
	}

	public void setDairyId(Integer dairyId) {
		this.dairyId = dairyId;
	}

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

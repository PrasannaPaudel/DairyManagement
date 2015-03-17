package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity @Table(name = "milkProduction") public class MilkProduction implements Serializable {

	@Id @Column(name = "milkId") private int milkId;
	//    @Column(name = "milkProductionUuid") private String milkProductionUuid;
	@Column(name = "cowId") private int cowId;
	@Column(name = "time") private String time;
	@Column(name = "amountProduced") private String amountProduced;
	@Column(name = "date") private String date;

	public int getMilkId() {
		return milkId;
	}

	public void setMilkId(int milkId) {
		this.milkId = milkId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//    public String getBreedUuid() {
	//        return milkProductionUuid;
	//    }
	//
	//    public void setBreedUuid(String breedUuid) {
	//        this.milkProductionUuid = breedUuid;
	//    }

	public int getCowId() {
		return cowId;
	}

	public void setCowId(int cowId) {
		this.cowId = cowId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmountProduced() {
		return amountProduced;
	}

	public void setAmountProduced(String amountProduced) {
		this.amountProduced = amountProduced;
	}

}

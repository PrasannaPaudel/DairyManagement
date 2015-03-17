package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity @Table(name = "workers") public class Workers implements Serializable {
	@Id @Column(name = "workerId") private int workerId;
	@Column(name = "workerUuid") private int workerUuid;
	@Column(name = "userId") private String userId;
	@Column(name = "amountPaid") private int amountPaid;
	@Column(name = "duty") private String duty;
	@Column(name = "paymentDate") private String paymentDate;

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getWorkerUuid() {
		return workerUuid;
	}

	public void setWorkerUuid(int workerUuid) {
		this.workerUuid = workerUuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

}

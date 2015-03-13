package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Entity
@Table(name = "customers") public class Customers implements Serializable{


    @Id @Column(name = "customerId") private int customerId;
    @Column(name = "customerName") private String customerName;
    @Column(name = "customerType") private String customerType;
    @Column(name = "date") private String date;

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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

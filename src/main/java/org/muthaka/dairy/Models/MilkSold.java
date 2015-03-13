package org.muthaka.dairy.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MUTHAKA on 3/10/2015.
 */
@Entity
@Table(name = "milkSold") public class MilkSold implements Serializable {

    @Id
    @Column(name = "sellId") private int sellId;
    @Column(name = "customerId") private int customerId;
    @Column(name = "time") private String time;
    @Column(name = "quantity") private int quantity;
    @Column(name = "cost") private int cost;
    @Column(name = "total") private int total;
    @Column(name = "date") private String date;

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

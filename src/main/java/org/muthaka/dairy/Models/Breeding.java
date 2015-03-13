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
@Table(name = "breeding") public class Breeding implements Serializable{

    @Id
    @Column(name = "breedId") private int breedId;
    @Column(name = "cowId") private int cowId;
    @Column(name = "semenType") private String semenType;
    @Column(name = "breedingCost") private String breedingCost;
    @Column(name = "nameOfSeminator") private String nameOfSeminator;
    @Column(name = "date") private String date;

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public String getSemenType() {
        return semenType;
    }

    public void setSemenType(String semenType) {
        this.semenType = semenType;
    }

    public String getBreedingCost() {
        return breedingCost;
    }

    public void setBreedingCost(String breedingCost) {
        this.breedingCost = breedingCost;
    }

    public String getNameOfSeminator() {
        return nameOfSeminator;
    }

    public void setNameOfSeminator(String nameOfSeminator) {
        this.nameOfSeminator = nameOfSeminator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

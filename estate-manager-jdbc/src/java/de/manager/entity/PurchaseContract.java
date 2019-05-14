package de.manager.entity;
import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "PURCHASE_CONTRACT")
public class PurchaseContract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CONTRACT_NO")
    private String contractNumber;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "FK_ID_PERSON")
    private int personID;

    @Column(name = "FK_ID_HOUSE")
    private int houseID;

    @Column(name = "NO_OF_INSTALLMENTS")
    private int noOfInstallments;

    @Column(name = "INTREST_RATE")
    private int intrestRate;

    public PurchaseContract(int id, String contractNumber, Date date, String place, int personID, int houseID, int noOfInstallments, int intrestRate) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.date = date;
        this.place = place;
        this.personID = personID;
        this.houseID = houseID;
        this.noOfInstallments = noOfInstallments;
        this.intrestRate = intrestRate;
    }

    public PurchaseContract() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public int getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(int noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    public int getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(int intrestRate) {
        this.intrestRate = intrestRate;
    }

    @Override
    public String toString() {
        return "PurchaseContract{" +
                "id=" + id +
                ", contractNumber=" + contractNumber +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", personID=" + personID +
                ", houseID=" + houseID +
                ", noOfInstallments=" + noOfInstallments +
                ", intrestRate=" + intrestRate +
                '}';
    }
}

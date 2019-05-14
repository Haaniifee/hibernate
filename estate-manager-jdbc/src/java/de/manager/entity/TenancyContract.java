package de.manager.entity;
import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "TENANCY_CONTRACT")
public class TenancyContract {

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

    @Column(name = "FK_ID_APARTMENT")
    private int apartmentID;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "ADDITIONAL_COSTS")
    private int additionalCosts;

    public TenancyContract() {}

    public TenancyContract(int id, String contractNumber, Date date, String place, int personID, int apartmentID, Date startDate, int duration, int additionalCosts) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.date = date;
        this.place = place;
        this.personID = personID;
        this.apartmentID = apartmentID;
        this.startDate = startDate;
        this.duration = duration;
        this.additionalCosts = additionalCosts;
    }

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

    public int getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAdditionalCosts() {
        return additionalCosts;
    }

    public void setAdditionalCosts(int additionalCosts) {
        this.additionalCosts = additionalCosts;
    }

    @Override
    public String toString() {
        return "TenancyContract{" +
                "id=" + id +
                ", contractNumber=" + contractNumber +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", personID=" + personID +
                ", apartmentID=" + apartmentID +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", additionalCosts=" + additionalCosts +
                '}';
    }
}

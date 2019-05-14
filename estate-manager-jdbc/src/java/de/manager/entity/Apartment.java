package de.manager.entity;
import javax.persistence.*;

@Entity
@Table(name = "APARTMENT")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // estate specific attributes
    @Column(name = "FK_ID_ESTATE_AGENT")
    private int estateAgentId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "STREET")
    private String street;

    @Column(name = "STREET_NUMBER")
    private String number;

    @Column(name = "SQUARE_AREA")
    private String squareArea;

    // apartment specific attributes
    @Column(name = "FLOOR")
    private int floor;

    @Column(name = "RENT")
    private double rent;

    @Column(name = "ROOMS")
    private int room;

    @Column(name = "BALCONY")
    private int balcony;

    @Column(name = "BUILT_IN_KITCHEN")
    private int kitchen;

    public Apartment(int estateAgentId, String city, String postalCode, String street, String number, String squareArea, int floor, double rent, int room, int balcony, int kitchen) {
        this.estateAgentId = estateAgentId;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.squareArea = squareArea;
        this.floor = floor;
        this.rent = rent;
        this.room = room;
        this.balcony = balcony;
        this.kitchen = kitchen;
    }

    public Apartment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstateAgentId() {
        return estateAgentId;
    }

    public void setEstateAgentId(int estateAgentId) {
        this.estateAgentId = estateAgentId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSquareArea() {
        return squareArea;
    }

    public void setSquareArea(String squareArea) {
        this.squareArea = squareArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", estateAgentId=" + estateAgentId +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", squareArea='" + squareArea + '\'' +
                ", floor=" + floor +
                ", rent=" + rent +
                ", room=" + room +
                ", balcony=" + balcony +
                ", kitchen=" + kitchen +
                '}';
    }
}

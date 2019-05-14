package de.manager.entity;
import javax.persistence.*;

@Entity
@Table(name = "HOUSE")
public class House {

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

    // house specific attributes
    @Column(name = "FLOORS")
    private int floors;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "GARDEN")
    private int garden;

    public House(int estateAgentId, String city, String postalCode, String street, String number, String squareArea, int floors, double price, int garden) {
        this.estateAgentId = estateAgentId;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.squareArea = squareArea;
        this.floors = floors;
        this.price = price;
        this.garden = garden;
    }

    public House() {}

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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGarden() {
        return garden;
    }

    public void setGarden(int garden) {
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", estateAgentId=" + estateAgentId +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", squareArea='" + squareArea + '\'' +
                ", floors=" + floors +
                ", price=" + price +
                ", garden=" + garden +
                '}';
    }
}

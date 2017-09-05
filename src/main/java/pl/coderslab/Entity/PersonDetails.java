package pl.coderslab.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.coderslab.Entity.Publisher;
@Entity
@Table(name = "persondetails")
public class PersonDetails {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    public PersonDetails() {
        super();
    }
    @Override
    public String toString() {
        return "PersonDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetNumber="
                + streetNumber + ", street=" + street + ", city=" + city + ", person=" + person + "]";
    }
    public PersonDetails(String firstName, String lastName, String streetNumber, String street, String city,
                         Person person) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.person = person;
    }
    public PersonDetails(String firstName, String lastName, String streetNumber, String street, String city) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
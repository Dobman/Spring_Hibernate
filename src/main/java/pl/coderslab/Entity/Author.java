package pl.coderslab.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
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

    public Author(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Author() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }


}
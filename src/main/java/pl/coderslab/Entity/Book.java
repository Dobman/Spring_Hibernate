package pl.coderslab.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    private List<Author> author = new ArrayList<Author>();
    @Column(scale=2, precision=4)
    private BigDecimal rating;
    @ManyToOne(cascade={CascadeType.ALL})
    private Publisher publisher;
    private String description;



    public Book(String title, List<Author> author, double rating, Publisher publisher, String description) {
        super();
        this.title = title;
        this.author = author;
        this.rating = new BigDecimal(rating);
        this.publisher = publisher;
        this.description = description;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Transactional
    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author.toString() + ", rating=" + rating + ", publisher="
                + publisher.toString() + ", description=" + description + "]";
    }



}
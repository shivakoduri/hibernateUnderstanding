package com.myprojects.examples.hibernate.demo9.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name="uuid_gen_strategy_class",
                            value="org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;

    @Version
    private int version;

    private String title;

    private Double price;

    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    @ManyToMany
    @JoinTable(
            name = "BookAuthor",
            joinColumns = {@JoinColumn(name="bookId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")}
    )
    private List<Author> authors = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (title != null && !title.trim().isEmpty())
            result += "title: " + title;
        return result;
    }
}

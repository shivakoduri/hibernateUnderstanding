package com.myprojects.examples.hibernate.demo2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Version
    private int version;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object obj) {
      if(this == obj) {
          return  true;
      }
      if(!(obj instanceof Author)){
          return false;
      }
      Author other = (Author) obj;
      if(id != null){
          if(!id.equals(other.id)){
              return false;
          }
      }
      return  true;
     }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if(firstName != null && !firstName.trim().isEmpty())
            result += "firstName:" + firstName;
        if(lastName != null && !lastName.trim().isEmpty())
            result += ", lastName:" + lastName;
        return result;
    }
}

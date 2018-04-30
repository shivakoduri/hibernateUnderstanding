package com.myprojects.examples.hibernate.demo4.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", updatable = false, nullable = false)
    private Long id;

    @Version
    private int version;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @Formula(value = "date_part('year', age(dateOfBirth))")
    private int age;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author other = (Author) obj;
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
        if (firstName != null && !firstName.trim().isEmpty())
            result += "firstName: " + firstName;
        if (lastName != null && !lastName.trim().isEmpty())
            result += ", lastName: " + lastName;
        return result;
    }
}

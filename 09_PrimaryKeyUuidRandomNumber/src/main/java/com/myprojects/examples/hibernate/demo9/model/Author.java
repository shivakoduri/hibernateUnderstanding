package com.myprojects.examples.hibernate.demo9.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Author {

    @Id
    @GeneratedValue
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;

    @Version
    private int version;

    private String firstName;

    private String lastName;

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

    @Override
    public boolean equals(Object obj) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Author author = (Author) o;
//        return version == author.version &&
//                Objects.equals(id, author.id) &&
//                Objects.equals(firstName, author.firstName) &&
//                Objects.equals(lastName, author.lastName);
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

//        return Objects.hash(id, version, firstName, lastName);
        return 31;
    }

    @Override
    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", version=" + version +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';

        String result = getClass().getSimpleName() + " ";
        if (firstName != null && !firstName.trim().isEmpty()) {
            result += "firstName: " + firstName;
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            result += ", lastName: " + lastName;
        }
        return result;
    }
}

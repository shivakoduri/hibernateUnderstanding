package com.myprojects.examples.hibernate.demo8.model;

import org.apache.log4j.Logger;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class Author implements Comparable<Author>{

    @Transient
    private Logger log = Logger.getLogger(Author.class.getSimpleName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", updatable = false, nullable = false)
    private Long id;

    @Version
    private int version;

    private String name;

    @ManyToMany(mappedBy = "authors")
    @SortComparator(SortById.class)
    private SortedSet<Book> books = new TreeSet<>();

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Book> getBooks() {
        return this.books;
    }

    public void setBooks(final SortedSet<Book> books) {
        this.books = books;
    }

    public void addBook(Book b) {
        this.books.add(b);
        b.getAuthors().add(this);
    }

    public void removeBook(Book b) {
        this.books.remove(b);
        b.getAuthors().remove(this);
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
        return "Author [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Author o) {
        log.info("compare");
        return name.compareTo(o.name);
    }
}

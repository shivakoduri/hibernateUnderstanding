package com.myprojects.examples.hibernate.demo2.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public class TestQueryPagination {


    Logger log = Logger.getLogger(this.getClass().getName());

    private EntityManagerFactory emf;

    @Before
    public void init(){
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    @After
    public void close(){
        emf.close();
    }

    @Test
    public void first5Authors(){
        log.info("..first 5 Authors..");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Author> authors = em.createQuery("SELECT a from Author a ORDER BY a.id desc ", Author.class)
                .setMaxResults(5)
                .setFirstResult(0)
                .getResultList();
        Assert.assertEquals("Expected a list of 5 authors", 5, authors.size());
        authors.forEach(a->log.info("Author Name:"+ a.getFirstName()+" "+a.getLastName()));

        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void next5Authors(){
        log.info("..first 5 Authors..");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Author> authors = em.createQuery("SELECT a from Author a ORDER BY a.id desc ", Author.class)
                .setMaxResults(5)
                .setFirstResult(5)
                .getResultList();
        Assert.assertEquals("Expected a list of 5 authors", 5, authors.size());
        authors.forEach(a->log.info("Author Name:"+ a.getFirstName()+" "+a.getLastName()));

        em.getTransaction().commit();
        em.close();

    }

}

package com.myprojects.examples.hibernate.demo8.model;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSortVsOrder {

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
    public void sortBooks(){
        log.info("..testPersist...");
    }

}

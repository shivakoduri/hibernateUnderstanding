package com.myprojects.examples.hibernate.demo8.model;

import org.apache.log4j.Logger;

import java.util.Comparator;

public class SortById implements Comparator<Book>{

    Logger log = Logger.getLogger(SortById.class.getSimpleName());

    @Override
    public int compare(Book o1, Book o2) {
        log.info("SortId.compare");
        return o1.getId().compareTo(o2.getId());
    }
}

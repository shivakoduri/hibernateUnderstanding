package com.myprojects.examples.hibernate.demo13.model;

import org.apache.log4j.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    Logger log = Logger.getLogger(LocalDateConverter.class.getSimpleName());

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        log.info("Convert to java.sql.Date");
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        log.info("Convert to java.time.LocalDate");
        return dbData.toLocalDate();
    }
}


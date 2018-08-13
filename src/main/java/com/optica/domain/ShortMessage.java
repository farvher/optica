package com.optica.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ShortMessage {


    @Id
    @GeneratedValue
    private Long id;

    Long userId;

    @Length(min = 10 ,  max = 160)
    String message;

    LocalDate creation;

    @Length(min = 10 ,  max = 15)
    String toNumber;

    @Override
    public String toString() {
        return  "Sms: '" + message + '\'' +
                " #: '" + toNumber + '\'' ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }
}

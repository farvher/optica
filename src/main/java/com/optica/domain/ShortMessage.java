package com.optica.domain;


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

    String message;

    LocalDate creation;




}

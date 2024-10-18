package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "T_ANAG_CLIENTI")
public class UserDetails {

    @Id
    @Column(name = "ID_CLIENTE", length = 10)
    private String id;

    @Column(name = "NOM_CLIENTE", length = 200)
    private String name;

    @Column(name = "COD_FISCALE", length = 16)
    private String fiscalCode;

    @Column(name = "DATA_NASCITA", columnDefinition = "DATE")
    private Date birthDate;

    @Column(name = "NOM_CITTA", length = 50)
    private String city;

    @Column(name = "NOM_INDIRIZZO", length = 200)
    private String address;

    @Column(name = "SESSO", length = 2)
    private String sex;

    @Column(name = "ID_SPORT", length = 10)
    private String sportId;

    @Column(name = "ID_ABBONAMENTO", length = 10)
    private String subscriptionId;

    @Column(name = "DATA_INIZIO", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "DATA_FINE", columnDefinition = "DATE")
    private Date endDate;

    @Column(name = "DATA_DISDETTA", columnDefinition = "DATE")
    private Date removalDate;

}
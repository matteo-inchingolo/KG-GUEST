package com.example.model;

import com.example.enumerations.ResultType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "T_IDONEITA_AGO")
public class Certificate {

    @Id
    @Column(name = "ID_CLIENTE", length = 10)
    private String userId;

    @Column(name = "COD_ESITO", length = 200)
    private String result;

    @Column(name = "DAT_VISITA", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "DAT_SCADENZA", columnDefinition = "DATE")
    private Date endDate;

}

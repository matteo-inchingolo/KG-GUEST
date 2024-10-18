package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_ABBONAMENTI")
public class Subscription
{

    @Id
    @Column(name = "ID_ABBONAMENTO", length = 10)
    private String id;

    @Column(name = "NOM_ABBONAMENTO", length = 50)
    private String name;

    @Column(name = "DES_ABBONAMENTO", length = 1000)
    private String description;

    @Column(name = "IMP_ABBONAMENTO")
    private BigDecimal cost;

}

package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_SPORT")
public class Sport {

    @Id
    @Column(name = "ID_SPORT", length = 10)
    private String id;

    @Column(name = "NOM_SPORT", length = 200)
    private String name;

    @Column(name = "DES_SPORT", length = 1000)
    private String description;

}

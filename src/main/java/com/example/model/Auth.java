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
@Table(name = "T_AUTENTICAZIONE")
public class Auth {

    @Id
    @Column(name = "ID_CLIENTE", length = 10)
    private String id;

    @Column(name = "COD_MAIL", length = 100)
    private String mail;

    @Column(name = "COD_PASSWORD", length = 30)
    private String password;

    @Column(name = "NOM_CLIENTE", length = 50)
    private String name;

}

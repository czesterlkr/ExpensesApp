package com.expenses.entity;

import com.expenses.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gnester on 2015-10-29.
 */
@Entity
@Getter
@Setter
@Table(name = "userXXX")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    private Person person;
}

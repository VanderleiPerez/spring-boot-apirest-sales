package com.empresa.mitosales.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Por id
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRole;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean enable;
}

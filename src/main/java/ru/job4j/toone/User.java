package ru.job4j.toone;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author: Egor Bekhterev
 * @date: 11.03.2023
 * @project: job4j_tracker
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "j_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

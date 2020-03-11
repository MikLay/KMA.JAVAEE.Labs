package com.example.practice6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(query = "select u from UserEntity  u where u.email = :email", name = UserEntity.FIND_BY_EMAIL)
})
@NoArgsConstructor
@Data
public class UserEntity {

    public static final String FIND_BY_EMAIL = "UserEntity.FIND_BY_EMAIL";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}

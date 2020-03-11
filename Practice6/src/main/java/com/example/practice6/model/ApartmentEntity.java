package com.example.practice6.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@ToString
public class ApartmentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private String number;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private List<BillingEntity> billings;

}

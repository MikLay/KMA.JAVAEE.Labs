package com.example.practice6.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "billing")
@Getter
@Setter
@ToString(exclude = "apartment")
public class BillingEntity {
    @EmbeddedId
    private ApartmentBillingId id;

    @Column(name = "bill")
    private double bill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id", insertable = false, updatable = false)
    private ApartmentEntity apartment;
}

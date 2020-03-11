package com.example.practice6.service;

import com.example.practice6.model.ApartmentBillingId;
import com.example.practice6.model.ApartmentEntity;
import com.example.practice6.model.BillingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BillingService {
    private final EntityManager entityManager;

    @Transactional
    public void createBilling(int apartmentId, LocalDate period, double bill) {
        BillingEntity billingEntity = new BillingEntity();
        billingEntity.setId(ApartmentBillingId.of(apartmentId, period));
        billingEntity.setBill(bill);

        entityManager.merge(billingEntity);
    }

    @Transactional
    public BillingEntity getBillingById(ApartmentBillingId apartmentBillingId) {
        return entityManager.find(BillingEntity.class, apartmentBillingId);
    }
}

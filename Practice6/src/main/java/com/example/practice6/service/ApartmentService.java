package com.example.practice6.service;

import com.example.practice6.model.ApartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final EntityManager entityManager;


    @Transactional
    public int createApartment(final String apartmentNumber) {
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setNumber(apartmentNumber);

        ApartmentEntity savedApartment = entityManager.merge(apartmentEntity);
        return savedApartment.getId();
    }

    @Transactional
    public List<ApartmentEntity> findAllApartmentsWithoutFetch() {
        return entityManager.createQuery("select a from ApartmentEntity a", ApartmentEntity.class).getResultList();
    }

    @Transactional
    public List<ApartmentEntity> findAllApartmentsWithFetch() {
        return entityManager.createQuery("select distinct a from ApartmentEntity a left join fetch a.billings", ApartmentEntity.class).getResultList();
    }
}

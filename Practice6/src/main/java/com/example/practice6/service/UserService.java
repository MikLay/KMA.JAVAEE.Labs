package com.example.practice6.service;

import com.example.practice6.model.ApartmentEntity;
import com.example.practice6.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return entityManager.merge(user);
    }

    @Transactional
    public UserEntity getUserById(int id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("select  a FROM UserEntity a", UserEntity.class).getResultList();
    }

    @Transactional
    public long countUsers() {
        return entityManager.createQuery("SELECT count(u) from UserEntity u", Long.class).getSingleResult();
    }

    @Transactional
    public UserEntity findByEmail(String email) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_EMAIL, UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    }

}

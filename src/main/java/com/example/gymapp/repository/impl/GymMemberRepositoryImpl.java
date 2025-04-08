package com.example.gymapp.repository.impl;

import com.example.gymapp.entity.GymMember;
import com.example.gymapp.repository.GymMemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GymMemberRepositoryImpl implements GymMemberRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public GymMember save(GymMember gymMember) {
        entityManager.persist(gymMember);
        return gymMember;
    }

    @Override
    public Optional<GymMember> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(GymMember.class,id));
    }

    @Override
    public List<GymMember> findAll() {
        return entityManager.createQuery("FROM GymMember",GymMember.class).getResultList();
    }

    @Override
    public GymMember update(GymMember gymMember) {
        return entityManager.merge(gymMember);
    }

    @Override
    public GymMember partialUpdate(Integer id, GymMember partialData) {
        GymMember existing = entityManager.find(GymMember.class,id);
        if(existing == null) return null;

        if(partialData.getName() != null) existing.setName(partialData.getName());
        if(partialData.getAge() != null) existing.setAge(partialData.getAge());
        if(partialData.getMembershipType() != null ) existing.setMembershipType(partialData.getMembershipType());
        if(partialData.getJoinDate() != null) existing.setJoinDate(partialData.getJoinDate());

        return null;
    }

    @Override
    public void deleteById(Integer id) {
        GymMember gymMember = entityManager.find(GymMember.class,id);
        if(gymMember != null) {
            entityManager.remove(gymMember);
        }
    }
}

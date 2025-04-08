package com.example.gymapp.repository;

import com.example.gymapp.GymappApplication;
import com.example.gymapp.entity.GymMember;

import java.util.List;
import java.util.Optional;

public interface GymMemberRepository {
    GymMember save(GymMember gymMember);
    Optional<GymMember> findById(Integer id);
    List<GymMember> findAll();
    GymMember update(GymMember gymMember);
    GymMember partialUpdate(Integer id, GymMember gymMember);
    void deleteById(Integer id);
}

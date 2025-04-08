package com.example.gymapp.service;

import com.example.gymapp.entity.GymMember;

import java.util.List;
import java.util.Optional;

public interface GymMemberService {
    GymMember addMember(GymMember member);
    GymMember getMember(Integer id);
    List<GymMember> getAllMembers();
    GymMember updateMember(Integer id, GymMember updated);
    GymMember partialUpdateMember(Integer id, GymMember partial);
    void deleteMember(Integer id);
}

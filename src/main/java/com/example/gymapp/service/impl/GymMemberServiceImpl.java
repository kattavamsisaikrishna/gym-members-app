package com.example.gymapp.service.impl;

import com.example.gymapp.exception.MemberNotFoundException;
import com.example.gymapp.entity.GymMember;
import com.example.gymapp.repository.GymMemberRepository;
import com.example.gymapp.service.GymMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberServiceImpl implements GymMemberService {

    private final GymMemberRepository repository;

    public GymMemberServiceImpl(GymMemberRepository repository) {
        this.repository  = repository;
    }


    @Override
    public GymMember addMember(GymMember member) {
        return repository.save(member);
    }

    @Override
    public GymMember getMember(Integer id) {
        return repository.findById(id).orElseThrow(()->new MemberNotFoundException("Member not found with Id : "+id));
    }

    @Override
    public List<GymMember> getAllMembers() {
        return repository.findAll();
    }

    @Override
    public GymMember updateMember(Integer id, GymMember updated) {
        GymMember existing = getMember(id);
        updated.setId(existing.getId());
        return repository.update(updated);
    }

    @Override
    public GymMember partialUpdateMember(Integer id, GymMember partial) {
        GymMember updated = repository.partialUpdate(id,partial);
        if(updated == null)
            throw new MemberNotFoundException("Member can't be updated, Member not found with Id : "+ id);
        return updated;
    }

    @Override
    public void deleteMember(Integer id) {
        getMember(id);
        repository.deleteById(id);
    }
}

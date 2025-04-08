package com.example.gymapp.controller;

import com.example.gymapp.entity.GymMember;
import com.example.gymapp.service.GymMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class GymMemberController {
    private final GymMemberService service;

    public GymMemberController(GymMemberService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GymMember> addMember(@RequestBody GymMember member) {
        return ResponseEntity.ok(service.addMember(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymMember> getMember(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getMember(id));
    }

    @GetMapping
    public ResponseEntity<List<GymMember>> getAllMembers() {
        return ResponseEntity.ok(service.getAllMembers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymMember> updateMember(@PathVariable Integer id,@RequestBody GymMember member) {
        return ResponseEntity.ok(service.updateMember(id,member));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GymMember> partialUpdate(@PathVariable Integer id, GymMember member) {
        return ResponseEntity.ok(service.partialUpdateMember(id,member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        service.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.goodjobtelegrambot.repository;

import com.example.goodjobtelegrambot.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
}

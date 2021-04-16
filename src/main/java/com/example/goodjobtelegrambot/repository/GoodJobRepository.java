package com.example.goodjobtelegrambot.repository;

import com.example.goodjobtelegrambot.model.GoodJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodJobRepository extends JpaRepository<GoodJob, Integer> {
}

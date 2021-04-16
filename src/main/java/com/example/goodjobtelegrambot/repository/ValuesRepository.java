package com.example.goodjobtelegrambot.repository;

import com.example.goodjobtelegrambot.model.Values;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuesRepository extends JpaRepository<Values, Integer> {
}

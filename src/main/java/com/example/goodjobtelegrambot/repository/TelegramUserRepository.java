package com.example.goodjobtelegrambot.repository;

import com.example.goodjobtelegrambot.model.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser,Integer>{
}

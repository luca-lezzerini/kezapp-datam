package com.example.kezapp00.repository;

import com.example.kezapp00.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends
        JpaRepository<Chat, Long> {

    Chat findByNickname(String nn);
}

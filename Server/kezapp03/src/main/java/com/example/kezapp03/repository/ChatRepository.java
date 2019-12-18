/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp03.repository;

import com.example.kezapp03.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utente
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat findByNickname(String nn);

    Chat findBySessione(String ss);

}

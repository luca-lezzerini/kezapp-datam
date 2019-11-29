/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp03.dto;

import com.example.kezapp03.model.Chat;
import com.example.kezapp03.model.Messaggio;
import java.util.List;

/**
 *
 * @author utente
 */
public class RegistrazioneDto {
    
    List<Chat> contatti;
    List<Messaggio> messaggi;
    String sessione; 

    public List<Chat> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
    
}

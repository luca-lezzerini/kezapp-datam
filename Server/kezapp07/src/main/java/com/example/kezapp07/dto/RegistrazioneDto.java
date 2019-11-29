package com.example.kezapp07.dto;

import com.example.kezapp07.model.Chat;
import com.example.kezapp07.model.Messaggio;
import java.util.List;

public class RegistrazioneDto {
    private List <Chat> contatti;
    private List <Messaggio> messaggi;
    private String sessione;

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

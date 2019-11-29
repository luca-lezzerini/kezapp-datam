package com.example.kezapp07.controller.service.impl;

import com.example.kezapp07.controller.service.KezappService;
import com.example.kezapp07.dto.InviaMessaggioDto;
import com.example.kezapp07.dto.RegistrazioneDto;
import com.example.kezapp07.dto.RichiediRegistrazioneDto;
import com.example.kezapp07.model.Chat;
import com.example.kezapp07.model.Messaggio;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl implements KezappService{

    private List<Chat> chats = new ArrayList<>();
    private List<Messaggio> msgs = new ArrayList<>();
    
    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto dto) {
        String nn = dto.getNickname();
        for (Chat chat: chats){
            if (chat.getNickname().equalsIgnoreCase(nn)){
                RegistrazioneDto r = new RegistrazioneDto();
                r.setSessione("Nickname già presente");
                return r;
            }
        }
    //do {
    Random rnd = new Random();
    long elle = rnd.nextLong();
    String sx = String.valueOf(elle);
    //} while (true);
    // Crea una nuova chat
    Chat cc = new Chat();
    cc.setNickname(nn);
    cc.setSessione(sx);
    chats.add(cc);
    
    
    RegistrazioneDto dx = new RegistrazioneDto();
    dx.setSessione(sx);
    dx.setContatti(chats);
    // TODO: impostare i messaggi (da fare)
    return dx;
    }
     
    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        String ss = dto.getSessione();
    // Verifico che esiste la sessione
        for (Chat chat: chats){
            if (chat.getSessione().equals(ss)){
                Messaggio msg = new Messaggio();
                msg.setAliasDestinatario(null);
                msg.setAliasMittente(chat.getNickname());
                msg.setTesto(dto.getMessaggio());
                msgs.add(msg);
                RegistrazioneDto reg = new RegistrazioneDto();
                reg.setContatti(chats);
                reg.setMessaggi(msgs);
                return reg;
            }
        }
        //Se non esiste la sessione ritorno messaggio vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;
    // Se esiste creo messaggio e lo salvo
    //ritorno tutti i contatti ed i messaggio
    }
    
}

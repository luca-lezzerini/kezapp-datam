/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp03.service.impl;

import com.example.kezapp03.dto.InviaMessaggioDto;
import com.example.kezapp03.dto.RegistrazioneDto;
import com.example.kezapp03.dto.RichiediRegistrazioneDto;
import com.example.kezapp03.model.Chat;
import com.example.kezapp03.model.Messaggio;
import com.example.kezapp03.service.KezappService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author utente
 */
@Service
public class KezappServiceImpl implements KezappService {

    private List<Chat> chats = new ArrayList<>();
    private List<Messaggio> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto registazione(RichiediRegistrazioneDto dto) {
        // cerca il nickname

        String nn = dto.getNickname();
        for (Chat chat : chats) {
            //se lo trova ritorna stringa  null
            if (chat.getNickname().equalsIgnoreCase(nn)) {
                RegistrazioneDto r = new RegistrazioneDto();
                r.setSessione("");
                return r;
            }
        }
        //se non lo trova genera una sessione casuale
        //do {
        Random rnd = new Random();
        long elle = rnd.nextLong();
        String sx = String.valueOf(elle);

        //verifica che non esita già.... ma non lo facciamo
        // } while (true); 
        //crea una nuova chat
        Chat cc = new Chat();
        cc.setNickname(nn);
        cc.setSessione(sx);
        chats.add(cc);

        RegistrazioneDto dx = new RegistrazioneDto();
        dx.setSessione(sx);
        dx.setContatti(chats);
        //TODO: impostare i messaggio

        //ritorna la sessione
        return dx;

    }

    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        //verifico che la sessione esiste
        String ss = dto.getSessione();
        for (Chat chat : chats) {

            if (chat.getSessione().equals(ss)) {
                //se esiste creo un messaggio e lo salvo
                Messaggio msg = new Messaggio();
                msg.setAliasDestinatario(null);
                msg.setAliasMittente(chat.getNickname());
                msg.setTesto(dto.getMessaggio());
                msgs.add(msg);
                //ritorno tutti i contatti e i messaggi
                RegistrazioneDto reg = new RegistrazioneDto();
                reg.setContatti(chats);
                reg.setMessaggi(msgs);
                return reg;
            }

        }
        //se non esiste la sessione ritorna un dto vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;

    }
}

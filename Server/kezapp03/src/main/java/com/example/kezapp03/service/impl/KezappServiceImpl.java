package com.example.kezapp03.service.impl;

import com.example.kezapp03.dto.InviaMessaggioDto;
import com.example.kezapp03.dto.RegistrazioneDto;
import com.example.kezapp03.dto.RichiediMessaggioDto;
import com.example.kezapp03.dto.RichiediRegistrazioneDto;
import com.example.kezapp03.model.Chat;
import com.example.kezapp03.model.Messaggio;
import com.example.kezapp03.repository.ChatRepository;
import com.example.kezapp03.repository.MessaggioRepository;
import com.example.kezapp03.service.KezappService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl implements KezappService {

    private List<Chat> chats = new ArrayList<>();
    private List<Messaggio> msgs = new ArrayList();

    @Autowired
    ChatRepository chatRepository;
    @Autowired
    MessaggioRepository messaggioRepository;

    @Override
    public RegistrazioneDto registrazione(
            RichiediRegistrazioneDto dto) {
        String nn = dto.getNickname();
        // cerca il nickname ...
        Chat cc = chatRepository.findByNickname(nn);
        // se lo trova, ritorna sessione vuota
        if (cc != null) {
            RegistrazioneDto r = new RegistrazioneDto();
            r.setSessione("");
            return r;
        }

        // se non lo trova genera una sessione casuale
//        do {
        Random rnd = new Random();
        long elle = rnd.nextLong();
        String sx = String.valueOf(elle);

        // verifica che non esista già
        // ma non lo facciamo
//        } while (true);
        // crea una nuova chat
        Chat cc2 = new Chat();

        cc2.setNickname(nn);

        cc2.setSessione(sx);

        chatRepository.save(cc2);

        // ritorna la sessione
        RegistrazioneDto dx = new RegistrazioneDto();

        dx.setSessione(sx);

        dx.setContatti(chatRepository.findAll());
        // TODO: impostare i messaggi
        return dx;
    }

    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        String ss = dto.getSessione();
        // verifico che la sessione esiste
        Chat cs = chatRepository.findBySessione(ss);
        if (cs != null) {
            // se esiste creo un messaggio e lo salvo
            Messaggio msg = new Messaggio();
            msg.setAliasDestinatario(null);
            msg.setAliasMittente(cs.getNickname());
            msg.setTesto(dto.getMessaggio());
            messaggioRepository.save(msg);
            // ritorno tutti i contatti e i messaggi
            RegistrazioneDto reg = new RegistrazioneDto();
            reg.setContatti(chatRepository.findAll());
            reg.setMessaggi(messaggioRepository.findAll());
            return reg;
        }

        // se non esiste la sessione
        // ritorna un dto vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;
    }

    @Override
    public RegistrazioneDto inviaUno(InviaMessaggioDto dto) {
        String ss = dto.getSessione();
        // verifico che la sessione esiste
        for (Chat chat : chats) {
            if (chat.getSessione().equals(ss)) {
                // se esiste creo un messaggio e lo salvo
                Messaggio msg = new Messaggio();
                msg.setAliasDestinatario(dto.getDestinatario());
                msg.setAliasMittente(chat.getNickname());
                msg.setTesto(dto.getMessaggio());
                msgs.add(msg);
                // ritorno tutti i contatti e i messaggi
                RegistrazioneDto reg = new RegistrazioneDto();
                reg.setContatti(chats);
                reg.setMessaggi(msgs);
                return reg;
            }
        }
        // se non esiste la sessione
        // ritorna un dto vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;
    }

    @Override
    public RegistrazioneDto aggiorna(RichiediMessaggioDto dto) {
        String ss = dto.getSessione();
        // verifico che la sessione esiste
        for (Chat chat : chats) {
            if (chat.getSessione().equals(ss)) {
                // se esiste la sessione 
                // ritorno tutti i contatti e i messaggi
                RegistrazioneDto reg = new RegistrazioneDto();
                reg.setContatti(chats);
                reg.setMessaggi(msgs);
                return reg;
            }
        }
        // se non esiste la sessione
        // ritorna un dto vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;
    }

}

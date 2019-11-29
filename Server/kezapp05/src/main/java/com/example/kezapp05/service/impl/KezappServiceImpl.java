package com.example.kezapp05.service.impl;

import com.example.kezapp05.dto.InviaMessaggioDto;
import com.example.kezapp05.dto.RegistrazioneDto;
import com.example.kezapp05.dto.RichiediRegistrazioneDto;
import com.example.kezapp05.model.Chat;
import com.example.kezapp05.model.Messaggio;
import com.example.kezapp05.service.KezappService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl implements KezappService {
    private List<Chat> chats = new ArrayList<>();
    private List<Messaggio> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto dto) {
        String nn = dto.getNickname();
        //Cerca il Nickname...
        for (Chat chat : chats) {
            //Cerca il Nickname, se c'è ritorna sessione vuota
            if (chat.getNickname().equalsIgnoreCase(nn)) {
                RegistrazioneDto r = new RegistrazioneDto();
                r.setSessione("");
                return r;
            }
        }
        //Se non c'è genera Sessione casuale
//*        do {
        Random rnd = new Random();
        Long elle = rnd.nextLong();
        String sx = String.valueOf(elle);
        // Verifica che non esista
        //} while (true)
        
        //Crea una nuova Chat
        Chat cc = new Chat();
        cc.setNickname(nn);
        cc.setSessione(sx);
        chats.add(cc);
        
        //Ritorna Sessione
        RegistrazioneDto dx = new RegistrazioneDto();
        dx.setSessione(sx);
        dx.setContatti(chats);
        //TODO: Impostare i Messaggi
        return dx;
    }

    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        String ss = dto.getSessione();
        //Verificare che la Sessione esista
        for (Chat chat : chats) {
            if (chat.getSessione().equals(ss)) {
            // Se esiste creo un Messaggio e lo salvo        
                Messaggio msg = new Messaggio();
                msg.setAliasDestinatario(null);
                msg.setAliasMittente(chat.getNickname());
                msg.setTesto(dto.getMessaggio());
                msgs.add(msg);
                //Restituisco tutti i Contatti e i Messaggi
                RegistrazioneDto reg = new RegistrazioneDto();
                reg.setMessaggi(msgs);
                reg.setContatti(chats);
                return reg;
            }
        }
        //Se non esiste la Sessione restituisce un Dto vuoto
        RegistrazioneDto rr = new RegistrazioneDto();
        return rr;
    }
    
}

package com.example.kezapp00.service;

import com.example.kezapp00.dto.InviaMessaggioDto;
import com.example.kezapp00.dto.RegistrazioneDto;
import com.example.kezapp00.dto.RichiediMessaggiDto;
import com.example.kezapp00.dto.RichiediRegistrazioneDto;

public interface KezappService {

    // FIXME: mancano due metodi
    RegistrazioneDto registrazione(
            RichiediRegistrazioneDto dto);

    RegistrazioneDto inviaTutti(
            InviaMessaggioDto dto);

    RegistrazioneDto inviaUno(
            InviaMessaggioDto dto);
    
    RegistrazioneDto aggiorna(
            RichiediMessaggiDto dto);
    
    
}

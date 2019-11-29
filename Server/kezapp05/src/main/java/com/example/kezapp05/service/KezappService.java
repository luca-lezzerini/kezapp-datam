package com.example.kezapp05.service;

import com.example.kezapp05.dto.InviaMessaggioDto;
import com.example.kezapp05.dto.RegistrazioneDto;
import com.example.kezapp05.dto.RichiediRegistrazioneDto;

public interface KezappService {
    //FIXME: Mancano tre Metodi
    RegistrazioneDto registrazione (
            RichiediRegistrazioneDto dto);
    
    RegistrazioneDto inviaTutti (
            InviaMessaggioDto dto);
}

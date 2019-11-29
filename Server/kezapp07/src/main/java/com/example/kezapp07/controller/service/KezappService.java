package com.example.kezapp07.controller.service;

import com.example.kezapp07.dto.InviaMessaggioDto;
import com.example.kezapp07.dto.RegistrazioneDto;
import com.example.kezapp07.dto.RichiediRegistrazioneDto;

public interface KezappService {
    
    RegistrazioneDto registrazione(RichiediRegistrazioneDto dto);
    
    RegistrazioneDto inviaTutti(InviaMessaggioDto dto);
        
        
    
    
}

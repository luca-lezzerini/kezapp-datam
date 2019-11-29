/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp03.service;

import com.example.kezapp03.dto.InviaMessaggioDto;
import com.example.kezapp03.dto.RegistrazioneDto;
import com.example.kezapp03.dto.RichiediRegistrazioneDto;

/**
 *
 * @author utente
 */
public interface KezappService {

    //FIXME: mancano tre metodi
    RegistrazioneDto registazione(RichiediRegistrazioneDto dto);

    RegistrazioneDto inviaTutti(InviaMessaggioDto dto);

}

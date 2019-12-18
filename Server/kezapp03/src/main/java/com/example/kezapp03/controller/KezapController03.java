/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp03.controller;

import com.example.kezapp03.dto.InviaMessaggioDto;
import com.example.kezapp03.dto.RegistrazioneDto;
import com.example.kezapp03.dto.RichiediRegistrazioneDto;
import com.example.kezapp03.service.KezappService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author utente
 */
@CrossOrigin("*")
@Controller
public class KezapController03 {

    @Autowired
    KezappService kezappService;

    @RequestMapping(value = {"/registrazione03"})
    @ResponseBody

    public RegistrazioneDto registrazione(@RequestBody RichiediRegistrazioneDto dto) {

        return kezappService.registrazione(dto);

    }

    @RequestMapping(value = {"/invia-tutti03"})
    @ResponseBody

    public RegistrazioneDto inviaTutti(@RequestBody InviaMessaggioDto dto) {

        return kezappService.inviaTutti(dto);

    }

}

package com.example.kezapp00.controller;

import com.example.kezapp00.dto.InviaMessaggioDto;
import com.example.kezapp00.dto.RegistrazioneDto;
import com.example.kezapp00.dto.RichiediMessaggiDto;
import com.example.kezapp00.dto.RichiediRegistrazioneDto;
import com.example.kezapp00.service.KezappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class KezappController00 {

    @Autowired
    KezappService kezappService;

    @RequestMapping(value = {"/registrazione00"})
    @ResponseBody
    public RegistrazioneDto registrazione(
            @RequestBody RichiediRegistrazioneDto dto
    ) {
        return kezappService.registrazione(dto);
    }

    @RequestMapping(value = {"/invia-tutti00"})
    @ResponseBody
    public RegistrazioneDto inviaTutti(
            @RequestBody InviaMessaggioDto dto
    ) {
        return kezappService.inviaTutti(dto);
    }
    
    @RequestMapping(value = {"/invia-uno00"})
    @ResponseBody
    public RegistrazioneDto inviaUno(
            @RequestBody InviaMessaggioDto dto
    ) {
        return kezappService.inviaUno(dto);
    }

    @RequestMapping(value = {"/aggiorna00"})
    @ResponseBody
    public RegistrazioneDto aggiorna(
            @RequestBody RichiediMessaggiDto dto
    ) {
        return kezappService.aggiorna(dto);
    }

}

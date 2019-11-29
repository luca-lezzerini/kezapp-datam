package com.example.kezapp05.controller;

import com.example.kezapp05.dto.InviaMessaggioDto;
import com.example.kezapp05.dto.RegistrazioneDto;
import com.example.kezapp05.dto.RichiediRegistrazioneDto;
import com.example.kezapp05.service.KezappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class KezappController05 {
    @Autowired
    KezappService kezappService;
    
    @RequestMapping(value = {"/registrazione05"})
    @ResponseBody
    public RegistrazioneDto registrazione (
            @RequestBody RichiediRegistrazioneDto dto) {
        return kezappService.registrazione(dto);
    }
    
    @RequestMapping(value = {"/invia-tutti05"})
    @ResponseBody
    public RegistrazioneDto inviaTutti (
            @RequestBody InviaMessaggioDto dto) {
        return kezappService.inviaTutti(dto);
    }
}

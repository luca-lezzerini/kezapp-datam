package com.example.kezapp07.controller;

import com.example.kezapp07.controller.service.KezappService;
import com.example.kezapp07.dto.InviaMessaggioDto;
import com.example.kezapp07.dto.RegistrazioneDto;
import com.example.kezapp07.dto.RichiediRegistrazioneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class KezappController07 {
    @Autowired
    KezappService kezappService;
    
    @RequestMapping(value = {"/registrazione07"})
    @ResponseBody
    public RegistrazioneDto registrazione(
        @RequestBody RichiediRegistrazioneDto dto) 
        {
          return kezappService.registrazione(dto); 
        }
    
    @RequestMapping(value = {"/invia-tutti07"})
    @ResponseBody
    public RegistrazioneDto inviaTutti(
        @RequestBody InviaMessaggioDto dto) 
        {
          return kezappService.inviaTutti(dto); 
        }
}

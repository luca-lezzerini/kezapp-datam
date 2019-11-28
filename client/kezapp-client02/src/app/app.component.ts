import { Chat, Messaggio } from './contatti';
import { Component } from '@angular/core';

import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione.-dto';
import { HttpClient } from '@angular/common/http';
import { InviaMessaggioDto } from './invia-messaggio-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickname: string = "";
  messaggio: string = "";
  contatti: Chat[] = [];
  messaggi: Messaggio[] = [];
  sessione: string = "";

  readonly url: string = "http://localhost:8080";
  readonly postfix: string = "02";

  constructor(private http: HttpClient) { };

  registrazione() {
    let dto = new RichiediRegistrazioneDto();
    dto.nickname = this.nickname;

    // prepara la richiesta http
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "registrazione" + this.postfix,
        dto
      );

    // invoca il servizio Web
    ox.subscribe(
      r => {
        this.contatti = r.contatti;
        this.messaggi = r.messaggi;
        this.sessione = r.sessione;

      }

    );
  }

  InviaTutti() {
    let dto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.sessione = this.sessione;
    dto.destinatario = null;

    // prepara la richiesta http
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "invia-tutti" + this.postfix,
        dto
      );

    // invoca il servizio Web
    ox.subscribe(
      r => {
        this.contatti = r.contatti;
        this.messaggi = r.messaggi;
      }
    );
  }
}

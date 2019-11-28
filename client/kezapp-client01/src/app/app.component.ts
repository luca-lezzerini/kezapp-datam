import { Component } from '@angular/core';
import { Messaggio, Chat } from './contatti';
import { Observable } from 'rxjs';

import { RegistrazioneDto } from './registrazione-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { HttpClient } from '@angular/common/http';

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

  readonly url: string = "http:localhost:8080/";
  readonly postfix: string = "00";

  constructor(private http: HttpClient) { };

  registrazione() {
    //prepara la registrazione sul server
    let dto = new RichiediRegistrazioneDto();
    dto.nickname = this.nickname;

    //prepara la richiesta http
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "registrazione" + this.postfix,
        dto
      );

      //invoca il servizio web
      ox.subscribe(
        r =>{
          this.contatti = r.contatti;
          this.messaggi = r.messaggi;
          this.sessione = r.sessione;

        }  
      )
  }
}

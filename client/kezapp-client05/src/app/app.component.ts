import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { RegistrazioneDto } from './registrazione-dto';
import { Chat, Messaggio } from './contatti';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


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

  readonly url: string = "http://localhost:8080/";
  readonly postfix: string = "05";

  constructor(private http: HttpClient) { }

  registrazione() {
    // preparo le informazioni da mandare al server
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
        r =>{
          this.contatti = r.contatti;
          this.messaggi = r.messaggi;
          this.sessione = r.sessione;
        }
      );
  }

  inviaTutti() {
    // preparo le informazioni da mandare al server
    let dto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.destinatario = null;
    dto.sessione = this.sessione;

    // prepara la richiesta http
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "invia-tutti" + this.postfix,
        dto
      );

      // invoca il servizio Web
      ox.subscribe(
        r =>{
          this.contatti = r.contatti;
          this.messaggi = r.messaggi;
        }
      );
  }
}
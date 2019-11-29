import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { RegistrazioneDto } from './registrazione-dto';
import { Messaggio } from './messaggio';
import { Component } from '@angular/core';
import { Chat } from './contatti';
import { Observable } from 'rxjs';
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
  contatti: Chat[] = []; //* inizializzo l'array a vuoto
  messaggi: Messaggio[] = [];
  sessione: string = '';

  readonly url: string = "http://localhost:8080/";
  readonly postfix: string = '03';

  constructor(private http: HttpClient) { }
  registrazione() {
    // preparo le informazioni da mandare al server
    let dto = new RichiediRegistrazioneDto();
    dto.nickname = this.nickname;
    console.log(dto);
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "registrazione" + this.postfix,
        dto
      );
    ox.subscribe(
      r => {
        this.contatti = r.contatti;
        this.messaggi = r.messaggi;
        this.sessione = r.sessione;
      }
    )

  }
  inviaTutti() {
    // preparo le informazioni da mandare al server
    let mdto = new InviaMessaggioDto();
    mdto.messaggio = this.messaggio;
    mdto.sessione = this.sessione;
    mdto.destinatario = null;
    console.log(mdto);

    // preparo la chiamata http
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>(
        this.url + "invia-tutti" + this.postfix,
        mdto
      );
      //invoca il servizio web
    ox.subscribe(
      r => {
        console.log(r);
        this.contatti = r.contatti;
        this.messaggi = r.messaggi;
      }
    )

  }


}


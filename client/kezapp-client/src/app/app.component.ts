import { RegistrazioneDto } from './registrazione-dto';
import { Chat, Messaggio } from './contatti';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickname: string = "";
  messaggio: string = "";
  contatti:Chat[] = [];
  messaggi:Messaggio[] = [];

  readonly url:string ="http://localhost:8080/";
  readonly postfix: string = "00";

  constructor(private http: HttpClient){}

  registrazione(){
    let ox: Observable<RegistrazioneDto> =

  }
}

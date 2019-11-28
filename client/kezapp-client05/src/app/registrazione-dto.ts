import { Chat, Messaggio } from './contatti';

export class RegistrazioneDto {
    contatti: Chat[] = [];
    messaggi: Messaggio[] = [];
    sessione: string;
}
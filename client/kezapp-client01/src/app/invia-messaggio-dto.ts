import { Messaggio } from './contatti';
export class InviaMessaggioDto {
    messaggio: string;
    sessione: string;
    destinatario: string; 
}
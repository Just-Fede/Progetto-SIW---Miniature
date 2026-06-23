export interface Utente {
  id: number
  bio?: string
  urlFotoProfilo?: string
  credenziali?: {
    username: string
  }
}
export interface Immagine {
  id: number;
  url: string; // oppure il nome del campo esatto che usi su Java per salvare il nome del file (es: nome, percorsoc, ecc.)
  copertina?: boolean;
}
export interface Post {
  id: number
  titolo: string
  descrizione: string
  data: string
  utente: Utente
  immagini: Immagine[];
}
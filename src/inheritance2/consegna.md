# 2 - Aggiusteria Agricola
All'aggiusteria agricola possono essere riparati tre tipi di apparecchiature: 
- Motozappe, 
- Decespugliatori, 
- Tosaerba. 

## Dati comuni 
- Un numero intero che indica il numero d'ordine della lavorazione. *Ogni volta che una macchina viene consegnata riceve un nuovo numero d'ordine, anche se quella macchina è già stata lì in precedenza.*
- La marca dell'apparecchio. 
- Il totale del costo di riparazione.

## Dati differenti
- Per i tosaerba e le motozappe va specificato il numero di ruote della macchina.
- Per i decespugliatori bisogna specificare se l'accensione è elettronica oppure no.
  
## TO DO
- Costruire una opportuna gerarchia di classi, strutturando correttamente la base dei dati.
- Il massimo numero di macchine che possonono essere simultaneamente in lavorazione è 10 perché questi sono i posti in officina.
- Ad ogni macchina riparata, deve essere associata una lista delle lavorazioni effettuate e del loro costo, la cui somma costituisce il totale del costo della riparazione .
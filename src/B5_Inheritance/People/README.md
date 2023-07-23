# People List

## Scrivere la classe **Persona** 
Dotata dei campi CodiceFiscale, Nome, Cognome e dei metodi per impostare e leggere tali valori. 
La classe inoltre dovrà essere dotata del metodo toString().

## Scrivere la classe **Studente**
Che estende la classe Persona; i campi aggiuntivi di Studente rispetto a Persona sono matricola e università. Inoltre la classe Studente dovrà avere i metodi per impostare e leggere tali campi e dovrà sovrascrivere il metodo toString(). 

## Scrivere la classe **Docente** 
Che estende Persona con campi aggiuntivi materia e salario. Anche in questo caso la classe dovrà avere metodi per leggere e impostare i vari attributi e dovrà sovrascrivere il metodo toString().

## Scrivere la classe **ElencoPersone**
Le cui istanze rappresentano elenchi di persone. La classe avrà i seguenti metodi:
 - Un costruttore per creare una lista specificando il numero massimo di persone che è possibile inserire nell'elenco;
 - Un metodo aggiungi(Persona p) che aggiunge p all'elenco;
 - Un metodo toString() che stampa la lista delle persone nell'elenco.
  
## Scrivere la classe **ElencoPersoneTester**
Con il solo metodo main che crea una lista di persone la cui dimensione è scelta dall'utente; chiede poi ripetutamente all'utente di inserire, a sua scelta, una Persona, uno Studente o un Docente, chiedendo i dati opportuni; infine stampa la lista delle persone inserite.
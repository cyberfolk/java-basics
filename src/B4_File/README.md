# File
## `BufferedReader` VS `FileReader`
- `BufferedReader` = Può leggere riga per riga guadagnando velocità
- `FileReader` = Legge solo carattere per carattere

## `BufferedWriter` VS `FileWriter`
- Se devono scrivere la stessa quantità di caratterei in una volta solo hanno la stessa efficacia.
- Se devono scrivere scrivere più volte sullo stesso file, il BufferedWriter è più efficente, perchè prima riempie il buffer e poi lo trascrive sul file in una volta sola. *Si da per assodato che accedere e scrivere sul file è molto più lento che scrivere nel buffer*

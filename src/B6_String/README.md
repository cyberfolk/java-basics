# `String` vs `StringBuffer` vs `StringBuilder`
- `String` è immutabile mentre `StringBuffer` e `StringBuilder` sono classi mutabili.
- `StringBuffer` è thread-safe e sincronizzato mentre `StringBuilder` non lo è.
- Per questo motivo `StringBuilder` è più veloce di `StringBuffer`.
- L'operatore di concatenazione di stringhe **(+)** usa internamente StringBuffer o StringBuilder.
- Per manipolare stringhe in un ambiente mono-thread, è meglio usare `StringBuilder`.

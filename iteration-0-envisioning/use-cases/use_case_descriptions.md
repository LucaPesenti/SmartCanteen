# Descrizione dei casi d’uso – SmartCanteen

Questo documento descrive i principali casi d’uso del sistema SmartCanteen, identificati durante l’Iterazione 0 (Envisioning) del processo AMDD.  
Le descrizioni testuali sono coerenti con il diagramma dei casi d’uso UML e con i requisiti funzionali definiti nel documento `requirements.md`.

---

## UC1 – Check-in del dipendente

### Attori principali
- Employee

### Attori secondari
- Sistema SmartCanteen

### Descrizione
Il caso d’uso descrive il processo mediante il quale un dipendente effettua il check-in alla mensa utilizzando il badge aziendale.  
Il check-in consente al sistema di registrare l’accesso del dipendente e di creare un ticket che rappresenta il diritto a consumare un pasto nel turno corrente.

### Precondizioni
- Il dipendente è in possesso di un badge aziendale valido.
- Il turno di accesso alla mensa è attivo.
- Il sistema SmartCanteen è operativo.

### Postcondizioni
- Un ticket è stato creato ed è associato al dipendente e al turno corrente.
- Il ticket si trova nello stato `OPEN`.

### Flusso principale
1. Il dipendente si presenta all’ingresso della mensa.
2. Il dipendente utilizza il badge aziendale per effettuare il check-in.
3. Il sistema identifica il dipendente associato al badge.
4. Il sistema verifica che il turno di accesso sia valido.
5. Il sistema crea un ticket in stato `OPEN`.
6. Il sistema conferma l’avvenuto check-in.

### Flussi alternativi
- **A1 – Badge non valido**  
  Se il badge non è riconosciuto dal sistema, il check-in viene rifiutato e non viene creato alcun ticket.

- **A2 – Turno non valido**  
  Se il dipendente tenta il check-in al di fuori del proprio turno di accesso, il sistema segnala l’impossibilità di effettuare il check-in.

- **A3 – Sistema non disponibile**  
  Se il sistema non è operativo, il check-in non può essere completato.

---


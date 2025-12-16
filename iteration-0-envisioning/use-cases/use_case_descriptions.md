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

## UC2 – Servizio del pasto

### Attori principali
- Staff Mensa

### Attori secondari
- Employee  
- Sistema SmartCanteen

### Descrizione
Il caso d’uso descrive il processo mediante il quale lo staff della mensa registra il servizio del pasto a un dipendente che ha effettuato il check-in.  
Durante il servizio vengono selezionati i piatti consumati, verificati i vincoli previsti e completata la registrazione del pasto nel sistema.

### Precondizioni
- Il dipendente ha effettuato correttamente il check-in.
- Esiste un ticket associato al dipendente in stato `OPEN`.
- Il sistema SmartCanteen è operativo.

### Postcondizioni
- Il pasto è stato registrato correttamente.
- Il ticket è aggiornato allo stato `SERVED`.
- Le informazioni relative al pasto sono memorizzate nel sistema.

### Flusso principale
1. Lo staff mensa identifica il ticket del dipendente.
2. Lo staff seleziona i piatti serviti al dipendente.
3. Il sistema verifica il rispetto dei vincoli sul numero di piatti per tipologia.
4. Il sistema verifica la disponibilità degli ingredienti necessari.
5. Il sistema registra il pasto servito.
6. Il sistema aggiorna lo stato del ticket a `SERVED`.
7. Il sistema conferma il completamento del servizio.

### Flussi alternativi
- **A1 – Ticket non valido**  
  Se il ticket non è in stato `OPEN`, il servizio del pasto non può essere completato.

- **A2 – Violazione dei vincoli sui piatti**  
  Se viene superato il numero massimo di piatti consentiti per tipologia, il sistema segnala l’errore e richiede una modifica della selezione.

- **A3 – Ingredienti non disponibili**  
  Se uno o più ingredienti non sono disponibili in quantità sufficiente, il sistema segnala l’impossibilità di completare il servizio.

- **A4 – Errore di sistema**  
  In caso di errore durante la registrazione del pasto, il sistema annulla l’operazione e il ticket rimane in stato `OPEN`.

---

## UC3 – Gestione del menu giornaliero

### Attori principali
- Chef

### Attori secondari
- Staff Mensa  
- Sistema SmartCanteen

### Descrizione
Il caso d’uso descrive la gestione del menu giornaliero della mensa.  
Il menu definisce l’insieme dei piatti disponibili per uno specifico giorno e può includere piatti del giorno e piatti sempre disponibili.

### Precondizioni
- L’utente è autenticato ed è autorizzato alla gestione del menu.
- Il sistema SmartCanteen è operativo.

### Postcondizioni
- Il menu giornaliero è aggiornato e memorizzato nel sistema.
- Il menu è disponibile per la consultazione durante il servizio.

### Flusso principale
1. Lo Chef accede alla funzionalità di gestione del menu.
2. Lo Chef seleziona la data per la quale gestire il menu.
3. Lo Chef definisce l’elenco dei piatti disponibili.
4. Il sistema valida la composizione del menu.
5. Il sistema salva il menu giornaliero.
6. Il sistema rende il menu disponibile agli utenti autorizzati.

### Flussi alternativi
- **A1 – Utente non autorizzato**  
  Se l’utente non dispone dei permessi necessari, l’accesso alla funzionalità è negato.

- **A2 – Dati non validi**  
  Se il menu non rispetta i vincoli previsti, il sistema segnala l’errore e richiede una correzione.

---


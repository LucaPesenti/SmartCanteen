# Diagrammi di Sequenza – Iterazione 1

Questo documento descrive i diagrammi di sequenza realizzati durante l’Iterazione 1 del progetto SmartCanteen, con l’obiettivo di dettagliare il comportamento dinamico del sistema per i casi d’uso core.

In questa iterazione l’attenzione è focalizzata sul caso d’uso UC2 – Servizio del pasto, in quanto rappresenta il cuore funzionale del sistema.

---

## Diagramma di sequenza UC2 – Servizio del pasto

### Caso d’uso di riferimento
**UC2 – Servizio del pasto**

Il diagramma di sequenza associato a UC2 descrive il flusso principale di erogazione del pasto a un dipendente, a partire dalla selezione del ticket fino alla conferma del servizio.

---

### Attori e partecipanti

Il diagramma coinvolge i seguenti partecipanti:

- **Staff Mensa**: attore che avvia il servizio del pasto.
- **Terminale Mensa**: interfaccia utilizzata dallo staff per interagire con il sistema.
- **Meal Service**: componente di controllo che coordina l’intero processo.
- **Ticket Service**: responsabile della validazione e dell’aggiornamento dello stato del ticket.
- **Inventory Service**: gestisce la verifica e l’aggiornamento delle scorte di ingredienti.
- **Accounting Service**: registra le operazioni contabili associate al pasto.
- **Database**: persistenza dei dati gestita dai servizi applicativi.

---

### Flusso principale

Il flusso principale del diagramma si articola come segue:

1. Lo Staff Mensa seleziona un ticket tramite il Terminale Mensa.
2. Il Terminale Mensa invia una richiesta di servizio pasto al Meal Service.
3. Il Meal Service richiede al Ticket Service la validazione del ticket.
4. Il Meal Service richiede all’Inventory Service la verifica della disponibilità degli ingredienti necessari.
5. In caso di esito positivo, l’Inventory Service aggiorna le scorte.
6. Il Meal Service richiede all’Accounting Service la registrazione della voce contabile.
7. Il Ticket Service aggiorna lo stato del ticket a “servito”.
8. Il sistema invia la conferma del servizio al Terminale Mensa.

Questo flusso rappresenta il comportamento standard del sistema in condizioni normali.

---

### Flussi alternativi

Il diagramma include due flussi alternativi principali, rappresentati tramite un costrutto `alt`:

- **Ticket non valido**  
  Se la validazione del ticket fallisce, il sistema interrompe il processo e segnala l’errore al Terminale Mensa.

- **Ingredienti insufficienti**  
  Se gli ingredienti necessari non sono disponibili in quantità sufficiente, il sistema blocca il servizio del pasto e notifica l’errore.

I flussi alternativi consentono di modellare le condizioni di errore più rilevanti senza appesantire eccessivamente il diagramma.

---

### Considerazioni progettuali

Il diagramma di sequenza di UC2 evidenzia come:
- il Meal Service svolga il ruolo di coordinatore del processo;
- le responsabilità siano correttamente distribuite tra i diversi servizi;
- le interazioni siano coerenti con l’architettura definita in Iterazione 0.

Il diagramma costituisce la base per la modellazione del dominio e per le successive iterazioni di progettazione e implementazione.

# Analisi statica del codice - Iterazione 3

L’obiettivo dell’analisi statica è valutare la qualità strutturale del codice sorgente del sistema *SmartCanteen*, individuando eventuali criticità architetturali, problemi di accoppiamento, complessità e manutenibilità, senza eseguire il software.

L’analisi è stata condotta dopo la fase di implementazione iniziale, in coerenza con il processo AMDD adottato, per verificare la corrispondenza tra il design definito nelle iterazioni precedenti e il codice effettivamente realizzato.

---

## Tool utilizzato

L’analisi statica è stata effettuata tramite **CodeMR**, plugin di analisi statica integrato in Eclipse, che fornisce metriche quantitative e qualitative a livello di:

- package
- classi
- metodi

Le metriche analizzate includono, tra le altre:

- Coupling (CBO)
- Complessità (WMC, RFC)
- Dimensione (LOC)
- Coesione (LCOM, LCAM)
- Indicatori sintetici di qualità

---

## Visione d’insieme dei risultati

L’analisi evidenzia una **qualità complessiva del codice buona**, con:

- prevalenza di indicatori **verdi**
- alcune segnalazioni **gialle localizzate**
- **assenza di criticità gravi** o strutturali

Non sono stati rilevati:

- cicli di dipendenza tra package
- classi monolitiche (“God Class”)
- violazioni dell’architettura a strati
- accoppiamenti diretti impropri (es. controller ↔ repository)

Questo indica una corretta applicazione dei principi di progettazione definiti in fase di design.

---

## Analisi per layer architetturale

### Layer Controller (`application.controller`)

Le classi controller presentano:

- bassa complessità
- basso accoppiamento
- responsabilità ben definite

Il `GlobalExceptionHandler` mostra metriche leggermente superiori alla media, in particolare per RFC e numero di metodi.  
Tale comportamento è **atteso e giustificato**, in quanto si tratta di una classe trasversale incaricata della gestione centralizzata delle eccezioni applicative.

Nel complesso, il layer di presentazione risulta coerente con il design RESTful e correttamente isolato dalla logica di persistenza.

---

### Layer Service (`application.service`)

Il layer dei servizi applicativi rappresenta il cuore della logica di business.

In particolare:

- `MealService` presenta valori di complessità e risposta (RFC) più elevati rispetto alle altre classi
- ciò è coerente con il suo ruolo di **servizio orchestratore** del caso d’uso UC2 (Servizio del pasto)

Le metriche osservate restano comunque entro limiti accettabili e indicano una complessità **funzionale**, non accidentale.

Le classi di eccezione (`EmployeeNotFoundException`, `InvalidTicketException`, ecc.) mostrano alcune segnalazioni di complessità media, dovute a limitazioni del tool nel valutare classi molto piccole.  
Tali segnalazioni non hanno impatto architetturale né manutentivo.

---

### Layer Repository (`application.repository`)

Il layer di persistenza presenta:

- metriche completamente verdi
- basso accoppiamento
- responsabilità singola per classe

I repository risultano correttamente utilizzati esclusivamente dal layer service, senza accessi diretti dai controller, confermando il rispetto dell’architettura a strati.

---

### Modello di dominio (`application.model`)

Le classi di dominio mostrano:

- alta coesione
- complessità molto bassa
- struttura dati chiara e leggibile

Questo è un forte indicatore di un buon design orientato agli oggetti, con entità che rappresentano correttamente i concetti del dominio applicativo.

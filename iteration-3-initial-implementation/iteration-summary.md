# Iterazione 3 – Implementazione Iniziale

## Obiettivi dell’iterazione

L’obiettivo dell’Iterazione 3 è stato realizzare una prima implementazione funzionante del sistema SmartCanteen, validando le principali decisioni architetturali e progettuali emerse nelle iterazioni precedenti attraverso codice eseguibile e attività di verifica.

In particolare, l’iterazione mirava a:
- verificare la correttezza del modello di dominio in fase di implementazione;
- validare il flusso Controller → Service → Repository;
- confermare la coerenza delle API REST definite in Iterazione 2;
- introdurre attività di analisi dinamica e statica del codice;
- validare le API tramite strumenti di test esterni.

---

## Funzionalità implementate

Durante questa iterazione sono state implementate le seguenti componenti principali:

- Struttura completa del progetto Spring Boot
- Controller REST per:
  - check-in del dipendente;
  - servizio del pasto;
  - gestione dei ticket
- Service layer con logica di business associata
- Repository in-memory per la gestione dei dati
- Gestione centralizzata delle eccezioni tramite `GlobalExceptionHandler`
- DTO per la comunicazione REST
- Inizializzazione dei dati di esempio tramite `SampleDataFactory`

---

## Analisi dinamica (JUnit + EclEmma)

Sono stati implementati ed eseguiti test di integrazione utilizzando Spring Boot Test e JUnit:

- `SmartcanteenApplicationTests`
- `EmployeeControllerIntegrationTest`
- `TicketControllerIntegrationTest`
- `MealServiceIntegrationTest`

Risultati dell’esecuzione:
- Test eseguiti: 7
- Fallimenti: 0
- Errori: 0
- Build: SUCCESS

È stata inoltre effettuata l’analisi di copertura del codice tramite **EclEmma**, ottenendo una copertura soddisfacente delle classi principali di Controller e Service.

L’analisi ha confermato:
- la corretta inizializzazione del contesto Spring;
- l’esecuzione dei flussi principali dei casi d’uso UC1 e UC2;
- una buona copertura della logica applicativa.

---

## Analisi statica del codice

È stata eseguita un’analisi statica del codice utilizzando **CodeMR**, focalizzata su:

- complessità ciclomatica;
- accoppiamento tra classi;
- dimensione e responsabilità dei componenti;
- dipendenze strutturali.

L’analisi ha evidenziato:
- alcune classi con responsabilità multiple;
- margini di miglioramento nella separazione delle logiche;
- una struttura complessiva comunque coerente con un’implementazione iniziale.

I risultati sono considerati accettabili per una fase di **initial implementation** e forniscono indicazioni utili per eventuali refactoring futuri.

---

## Validazione API REST (Postman)

Le API REST implementate sono state validate tramite **Postman Desktop Application**, eseguendo test end-to-end sui principali casi d’uso:

- UC1 – Check-in del dipendente
- UC2 – Servizio del pasto

Per ciascun caso d’uso sono state eseguite più richieste POST, verificando:
- la raggiungibilità degli endpoint;
- la corretta elaborazione delle richieste;
- la coerenza delle risposte REST.

I test hanno confermato il corretto funzionamento delle API in esecuzione locale e la conformità alle specifiche definite in Iterazione 2.

---

## Decisioni architetturali validate

L’iterazione ha permesso di validare concretamente:
- l’uso di Spring Boot come framework applicativo;
- l’architettura a strati (Controller, Service, Repository);
- la separazione tra dominio, DTO e API;
- la robustezza delle scelte di design effettuate;
- l’efficacia dell’integrazione tra progettazione e implementazione.

---

## Limiti dell’iterazione

Consapevolmente, in questa iterazione:
- non è stata implementata persistenza su database reale;
- non sono state introdotte funzionalità di sicurezza/autenticazione;
- non è stato implementato un client grafico;
- non è stato completato l’intero set di casi d’uso a livello implementativo.

Tali limiti sono coerenti con l’obiettivo di una **implementazione iniziale**, volta a validare l’architettura e le scelte progettuali fondamentali.

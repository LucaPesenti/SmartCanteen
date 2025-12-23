# Iterazione 3 – Implementazione Iniziale

## Obiettivi dell’iterazione
L’obiettivo dell’Iterazione 3 era realizzare una prima implementazione funzionante del sistema SmartCanteen, validando le principali decisioni architetturali e progettuali emerse nelle iterazioni precedenti attraverso codice eseguibile e test di integrazione.

In particolare, l’iterazione mirava a:
- verificare la correttezza del modello di dominio in fase di implementazione;
- validare il flusso Controller → Service → Repository;
- confermare la coerenza delle API REST definite in Iterazione 2;
- predisporre una base stabile per l’estensione futura del sistema.

---

## Funzionalità implementate
Durante questa iterazione sono state implementate le seguenti componenti principali:

- Struttura completa del progetto Spring Boot
- Controller REST:
  - gestione del check-in del dipendente;
  - servizio del pasto;
  - gestione dei ticket
- Service layer con logica di business associata
- Repository in-memory per la gestione dei dati
- Gestione centralizzata delle eccezioni tramite `GlobalExceptionHandler`
- DTO per le risposte delle API
- Inizializzazione dati di esempio tramite `SampleDataFactory`

---

## Test e validazione
Sono stati implementati ed eseguiti con successo test di integrazione tramite Spring Boot Test e MockMvc:

- `SmartcanteenApplicationTests`
- `EmployeeControllerIntegrationTest`
- `TicketControllerIntegrationTest`
- `MealServiceIntegrationTest`

Risultato dell’esecuzione dei test:
- Test eseguiti: 7
- Fallimenti: 0
- Errori: 0
- Build: SUCCESS

Questi risultati confermano la corretta inizializzazione del contesto Spring e il corretto funzionamento delle principali funzionalità implementate.

---

## Decisioni architetturali validate
L’iterazione ha permesso di validare concretamente:
- l’organizzazione dei package con un package root `application`;
- l’uso di Spring Boot come framework principale;
- l’adozione di un’architettura a strati (Controller, Service, Repository);
- la separazione tra modello di dominio e DTO;
- l’efficacia dei test di integrazione come strumento di validazione.

---

## Limiti dell’iterazione
Consapevolmente, in questa iterazione:
- non è stata implementata persistenza su database reale;
- non sono state introdotte funzionalità di sicurezza/autenticazione;
- non sono stati sviluppati test end-to-end;
- non è stato completato l’intero set di casi d’uso a livello implementativo.

Queste scelte sono coerenti con l’obiettivo di una **initial implementation**.

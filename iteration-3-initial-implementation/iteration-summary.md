# Iterazione 3 – Implementazione Iniziale

## Obiettivi dell’iterazione

L’obiettivo dell’Iterazione 3 è stato realizzare una **prima implementazione funzionante** del sistema SmartCanteen, al fine di validare tramite codice eseguibile le principali decisioni architetturali e progettuali definite nelle iterazioni precedenti.

In particolare, questa iterazione ha mirato a:

* verificare la correttezza del modello di dominio in fase di implementazione;
* validare il flusso architetturale Controller → Service → Repository;
* confermare la coerenza delle API REST progettate in Iterazione 2;
* introdurre attività di verifica tramite analisi dinamica e statica;
* testare le API REST tramite strumenti di validazione esterni.

---

## Attività svolte

Durante l’Iterazione 3 sono state svolte attività di **implementazione iniziale**, focalizzate sulla traduzione del design dettagliato in codice funzionante.

Le principali attività hanno incluso:

* creazione della struttura del progetto Spring Boot;
* implementazione dei controller REST;
* sviluppo del service layer con logica di business;
* realizzazione di repository in-memory;
* gestione centralizzata delle eccezioni;
* scrittura di test di integrazione;
* esecuzione di analisi dinamiche e statiche del codice.

---

## Artefatti prodotti

Nel corso dell’Iterazione 3 sono stati realizzati i seguenti artefatti implementativi e di verifica:

* **Progetto Spring Boot**

  * Struttura completa dell’applicazione backend.

* **Controller REST**

  * Endpoint per:

    * UC1 – Check-in del dipendente;
    * UC2 – Servizio del pasto;
    * gestione dei ticket.

* **Service layer**

  * Implementazione della logica di business associata ai casi d’uso principali.

* **Repository in-memory**

  * Gestione dei dati in assenza di persistenza su database reale.

* **DTO e gestione delle eccezioni**

  * Utilizzo di Data Transfer Object per la comunicazione REST.
  * Gestione centralizzata degli errori tramite `GlobalExceptionHandler`.

* **Dati di esempio**

  * Inizializzazione del sistema tramite `SampleDataFactory`.

---

## Copertura dei casi d’uso

L’implementazione realizzata in questa iterazione copre i seguenti casi d’uso principali:

* UC1 – Check-in del dipendente
* UC2 – Servizio del pasto

I restanti casi d’uso risultano parzialmente coperti a livello strutturale oppure rimandati alle iterazioni successive, in linea con l’obiettivo di una **implementazione iniziale**.

---

## Attività di verifica e validazione

### Analisi dinamica (JUnit + EclEmma)

Sono stati implementati ed eseguiti test di integrazione utilizzando Spring Boot Test e JUnit:

* `SmartcanteenApplicationTests`
* `EmployeeControllerIntegrationTest`
* `TicketControllerIntegrationTest`
* `MealServiceIntegrationTest`

Risultati:

* Test eseguiti: 7
* Fallimenti: 0
* Errori: 0
* Build: SUCCESS

È stata inoltre effettuata un’analisi di copertura del codice tramite **EclEmma**, ottenendo una copertura soddisfacente delle classi principali di Controller e Service.

L’analisi ha confermato:

* la corretta inizializzazione del contesto Spring;
* l’esecuzione dei flussi principali dei casi d’uso UC1 e UC2;
* una copertura adeguata della logica applicativa.

### Analisi statica del codice

È stata eseguita un’analisi statica del codice tramite **CodeMR**, focalizzata su:

* complessità ciclomatica;
* accoppiamento tra classi;
* responsabilità dei componenti;
* dipendenze strutturali.

L’analisi ha evidenziato:

* alcune classi con responsabilità multiple;
* margini di miglioramento nella separazione delle logiche;
* una struttura complessivamente coerente con una fase di implementazione iniziale.

### Validazione API REST (Postman)

Le API REST implementate sono state validate tramite **Postman Desktop Application**, eseguendo test end-to-end per:

* UC1 – Check-in del dipendente
* UC2 – Servizio del pasto

I test hanno verificato:

* la raggiungibilità degli endpoint;
* la corretta elaborazione delle richieste;
* la coerenza delle risposte REST rispetto alle specifiche progettuali.

---

## Considerazioni progettuali

L’Iterazione 3 ha permesso di validare concretamente:

* l’adozione di Spring Boot come framework applicativo;
* l’architettura a strati;
* la separazione tra dominio, DTO e API;
* la coerenza tra design UML e codice implementato;
* l’efficacia dell’approccio incrementale previsto da AMDD.

---

## Stato del progetto al termine dell’iterazione

Al termine dell’Iterazione 3, il progetto SmartCanteen dispone di:

* un backend REST funzionante;
* una prima implementazione dei casi d’uso principali;
* un’architettura validata tramite codice eseguibile;
* attività di test e analisi già integrate nel processo di sviluppo.

Consapevolmente, in questa fase:

* non è stata implementata persistenza su database reale;
* non sono state introdotte funzionalità di sicurezza;
* non è stato ancora sviluppato un client grafico;
* non è stato completato l’intero insieme dei casi d’uso.

Tali limitazioni sono coerenti con lo scopo dell’Iterazione 3, che rappresenta una **fase di implementazione iniziale**, propedeutica alle iterazioni successive.

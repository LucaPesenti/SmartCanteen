# Iterazione 2 – Design dettagliato

## Obiettivo dell’iterazione

L’obiettivo dell’Iterazione 2 è stato quello di trasformare i modelli concettuali e funzionali definiti nelle iterazioni precedenti in una progettazione tecnica dettagliata, pronta per l’implementazione.

In questa fase il focus è stato posto sul **design architetturale e di dettaglio**, chiarendo:
- la struttura statica del sistema,
- l’organizzazione dei componenti software,
- le modalità di distribuzione a runtime,
- e la logica algoritmica dei principali casi d’uso.

---

## Artefatti prodotti

Durante l’Iterazione 2 sono stati realizzati i seguenti artefatti:

- **Diagramma delle classi**
  - Descrive la struttura statica del sistema, le principali entità di dominio, i servizi applicativi e le loro relazioni.

- **Specifica delle API REST**
  - Definizione formale degli endpoint REST, delle risorse esposte, dei payload JSON, dei codici di risposta e del modello di gestione degli errori.

- **Component Diagram**
  - Rappresenta la scomposizione del sistema in componenti logici (Controller, Service, Repository, Domain Model) e le loro dipendenze.
  - Evidenzia la separazione delle responsabilità e l’aderenza a un’architettura a strati.

- **Deployment Diagram**
  - Descrive la configurazione del sistema a runtime, includendo:
    - nodo applicativo (Spring Boot),
    - database relazionale,
    - client esterni (Postman / browser).
  - Chiarisce le interazioni tra nodi fisici e artefatti software.

- **Design algoritmico (design in piccolo)**
  - Documentazione degli algoritmi dei principali casi d’uso, espressi in pseudocodice e corredati da analisi della complessità temporale.
  - In particolare, è stato dettagliato il flusso completo del caso d’uso UC2 – Servizio del Pasto, cuore del sistema SmartCanteen.

---

## Copertura dei casi d’uso

Le API REST definite in questa iterazione coprono tutti i casi d’uso primari del sistema SmartCanteen:

- UC1 – Check-in del dipendente
- UC2 – Servizio del pasto
- UC4 – Gestione di ricette e ingredienti
- UC5 – Consultazione dello stato dell’inventario
- UC7 – Consultazione dei report dei pasti erogati
- UC8 – Consultazione dello stato operativo della mensa
- UC9 – Esportazione dei dati amministrativi

I casi d’uso di supporto interno sono stati integrati all’interno delle operazioni principali e non esposti come endpoint REST autonomi, in linea con i principi di incapsulamento e responsabilità dei servizi applicativi.

---

## Considerazioni progettuali

La progettazione è stata guidata dai seguenti principi:

- separazione chiara delle responsabilità (layered architecture),
- aderenza ai principi RESTful per le API,
- disaccoppiamento tra logica di business e persistenza,
- coerenza tra modelli UML e struttura del codice previsto.

L’assenza di codice implementativo in questa iterazione è intenzionale e coerente con l’approccio AMDD adottato: l’Iterazione 2 ha avuto come scopo la definizione del “come” il sistema sarà costruito, senza anticipare l’implementazione.

---

Al termine dell’Iterazione 2, il progetto SmartCanteen dispone di:

- una progettazione architetturale completa,
- una definizione chiara delle API,
- una visione coerente della distribuzione del sistema,
- una descrizione dettagliata degli algoritmi di business.

Questa base progettuale è risultata sufficiente e stabile per avviare con successo l’implementazione del sistema nelle iterazioni successive.

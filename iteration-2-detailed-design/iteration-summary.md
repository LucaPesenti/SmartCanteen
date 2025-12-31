# Iterazione 2 – Design Dettagliato

## Obiettivi dell’iterazione

L’obiettivo dell’Iterazione 2 è stato quello di trasformare i modelli concettuali e funzionali definiti nelle iterazioni precedenti in una **progettazione tecnica dettagliata**, fornendo una descrizione chiara e coerente di come il sistema SmartCanteen dovrà essere costruito.

In particolare, questa iterazione ha mirato a:

* definire la struttura statica del sistema;
* chiarire l’organizzazione dei componenti software;
* descrivere la distribuzione del sistema a runtime;
* formalizzare la logica algoritmica dei principali casi d’uso.

---

## Attività svolte

Durante l’Iterazione 2 sono state svolte attività di **detailed design**, focalizzate sulla traduzione dei modelli concettuali in soluzioni tecniche concrete, senza introdurre ancora codice implementativo.

Le principali attività hanno incluso:

* progettazione delle classi di dominio e dei servizi applicativi;
* definizione delle API REST e dei relativi contratti;
* scomposizione del sistema in componenti logici;
* analisi della configurazione di deployment;
* descrizione degli algoritmi dei casi d’uso principali.

---

## Artefatti prodotti

Nel corso dell’Iterazione 2 sono stati prodotti i seguenti artefatti di progettazione:

### Diagramma delle classi

* Rappresenta la struttura statica del sistema.
* Descrive entità di dominio, servizi applicativi e relazioni tra le classi.

### Specifica delle API REST

* Definizione formale degli endpoint REST.
* Descrizione delle risorse esposte, dei payload JSON, dei codici di risposta e del modello di gestione degli errori.

### Component Diagram

* Scomposizione del sistema in componenti logici (Controller, Service, Repository, Domain Model).
* Evidenzia la separazione delle responsabilità e l’adozione di un’architettura a strati.

### Deployment Diagram

* Descrizione della configurazione del sistema a runtime.
* Include il nodo applicativo Spring Boot, il database relazionale e i client esterni.
* Chiarisce le interazioni tra nodi fisici e artefatti software.

### Design algoritmico (design in piccolo)

* Documentazione degli algoritmi dei principali casi d’uso.
* Utilizzo di pseudocodice e analisi della complessità temporale.
* Dettaglio completo del caso d’uso **UC2 – Servizio del Pasto**, identificato come flusso centrale del sistema.

---

## Copertura dei casi d’uso

Le attività di progettazione svolte in questa iterazione coprono i principali casi d’uso del sistema SmartCanteen, tra cui:

* UC1 – Check-in del dipendente
* UC2 – Servizio del pasto
* UC4 – Gestione di ricette e ingredienti
* UC5 – Consultazione dello stato dell’inventario
* UC7 – Consultazione dei report dei pasti erogati
* UC8 – Consultazione dello stato operativo della mensa
* UC9 – Esportazione dei dati amministrativi

I casi d’uso di supporto sono stati integrati all’interno delle operazioni principali, evitando l’esposizione di endpoint superflui e mantenendo un buon livello di incapsulamento.

---

## Considerazioni progettuali

La progettazione dell’Iterazione 2 è stata guidata dai seguenti principi:

* separazione chiara delle responsabilità;
* adozione di un’architettura a strati;
* conformità ai principi RESTful;
* disaccoppiamento tra logica di business e persistenza;
* coerenza tra modelli UML e struttura del sistema previsto.

In linea con l’approccio **AMDD**, non è stato introdotto codice implementativo: l’obiettivo dell’iterazione è stato esclusivamente la definizione del **design tecnico**, rimandando l’implementazione alle iterazioni successive.

---

## Stato del progetto al termine dell’iterazione

Al termine dell’Iterazione 2, il progetto SmartCanteen dispone di:

* una progettazione architetturale completa e coerente;
* una definizione chiara delle API REST;
* una visione strutturata dei componenti software;
* una descrizione esplicita della distribuzione del sistema;
* una formalizzazione degli algoritmi dei casi d’uso principali.

Questa iterazione fornisce una base tecnica solida e sufficientemente dettagliata per procedere con l’implementazione del sistema nelle fasi successive del processo di sviluppo.

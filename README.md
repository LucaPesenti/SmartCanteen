# SmartCanteen

Università degli Studi di Bergamo - Corso di Laurea Magistrale in Ingegneria Informatica - A.A. 2025/2026

---

## Descrizione del progetto

**SmartCanteen** è un sistema software progettato per supportare e ottimizzare i principali processi operativi di una mensa aziendale, includendo la gestione degli accessi dei dipendenti, l’erogazione dei pasti e la tracciabilità delle operazioni.

Il progetto è stato sviluppato con l’obiettivo di applicare in modo rigoroso metodologie di **progettazione software model-driven**, integrando progressivamente requisiti, modelli UML, architettura, implementazione e verifica.

L’intero lavoro è organizzato secondo il processo **Agile Model Driven Development (AMDD)**, con una chiara suddivisione in iterazioni incrementali e artefatti tracciabili.

---

## Obiettivi formativi e progettuali

Gli obiettivi principali del progetto sono:

* applicare metodologie di **analisi e progettazione software strutturata**;
* modellare requisiti funzionali e non funzionali tramite **UML**;
* definire un’architettura software coerente e scalabile;
* sviluppare il sistema in modo **incrementale, verificabile e documentato**;
* mantenere coerenza tra modelli concettuali, design e codice;
* produrre una documentazione completa e tecnicamente rigorosa.

---

## Metodologia di sviluppo

Il progetto segue il processo **Agile Model Driven Development (AMDD)**, che prevede:

* una fase iniziale di *envisioning* (Iterazione 0);
* iterazioni successive di early design, detailed design e implementazione;
* continua integrazione tra requisiti, modelli UML e codice;
* produzione incrementale di artefatti verificabili.

Come riferimento metodologico e architetturale è stato utilizzato il **progetto guida CoCoME**, in particolare per:

* la scomposizione in componenti;
* la modellazione dei casi d’uso;
* la coerenza tra progettazione UML e implementazione.

---

## Struttura del repository

Il repository è organizzato per **iterazioni AMDD**, ciascuna contenente gli artefatti prodotti in quella fase del processo.

SmartCanteen

├── code/

│   └── smartcanteen/                # Progetto Eclipse (backend + GUI)

│

├── iteration-0-envisioning/

│   ├── requirements/

│   ├── use-cases/

│   └── architecture/

│

├── iteration-1-early-design/

│   ├── domain-model/

│   └── sequence-diagrams/

│

├── iteration-2-detailed-design/

│   ├── algorithm-design/

│   ├── api-design/

│   ├── class-diagram/

│   ├── component-diagram/

│   ├── deployment-diagram/

│   └── iteration-summary.md

│

├── iteration-3-initial-implementation/

│   ├── dynamic-analysis/

│   ├── static-analysis/

│   ├── postman/

│   └── iteration-summary.md

│

├── iteration-4-completion-refinement/

│   ├── gui/

│   ├── user-guide/

│   └── iteration-summary.md

Ogni cartella di iterazione contiene esclusivamente gli artefatti pertinenti a quella fase, in modo da garantire **chiarezza, tracciabilità e coerenza temporale**.

---

## Panoramica delle iterazioni

### Iterazione 0 – Envisioning

* Analisi dei requisiti funzionali e non funzionali
* Glossario di dominio
* Diagramma dei casi d’uso
* Architettura di alto livello

### Iterazione 1 – Early Design

* Modello di dominio
* Diagrammi di sequenza per i casi d’uso principali

### Iterazione 2 – Detailed Design

* Diagramma delle classi
* Progettazione delle API REST
* Diagrammi dei componenti e di deployment
* Design algoritmico dei casi d’uso principali

### Iterazione 3 – Initial Implementation

* Implementazione backend Spring Boot
* API REST funzionanti
* Test di integrazione (JUnit)
* Analisi statica e dinamica del codice
* Validazione tramite Postman

### Iterazione 4 – Completion & Refinement

* GUI desktop Java Swing
* Integrazione completa con backend REST
* Miglioramenti grafici e di usabilità
* User guide e documentazione finale

---

## Tecnologie utilizzate

* **Linguaggio:** Java
* **Backend:** Spring Boot
* **API:** REST / JSON
* **GUI:** Java Swing
* **Modellazione:** UML (draw.io)
* **Testing:** JUnit, Postman
* **Analisi statica:** CodeMR
* **Analisi dinamica:** EclEmma
* **Versionamento:** Git / GitHub

---

## Stato del progetto

Alla fine dell’ultima iterazione documentata, il progetto dispone di:

* un backend REST funzionante e testato;
* una GUI desktop integrata;
* documentazione completa per ogni fase del processo AMDD;
* una struttura coerente e facilmente navigabile.

Il sistema rappresenta una **realizzazione completa e coerente dei casi d’uso principali**, con focus su correttezza progettuale, tracciabilità e qualità della documentazione.

---

## Autore

Luca Pesenti

---

## Licenza

Questo progetto è distribuito sotto licenza **MIT**.
Consultare il file `LICENSE` per i dettagli.

# SmartCanteen

Università degli Studi di Bergamo - Corso di Laurea Magistrale in Ingegneria Informatica - A.A. 2025/2026

---

## Contesto e obiettivi

Il sistema SmartCanteen è pensato per supportare e ottimizzare l’intero flusso operativo di una mensa aziendale, dalla gestione degli accessi tramite badge alla contabilizzazione dei pasti, fino al controllo degli ingredienti e alla riduzione degli sprechi.

Gli obiettivi principali del progetto sono:
- applicare metodologie di **progettazione software strutturata**;
- modellare requisiti funzionali e non funzionali tramite **UML**;
- definire un’architettura software coerente e scalabile;
- sviluppare il sistema in modo **incrementale e tracciabile**;
- documentare ogni fase del processo in modo rigoroso.

---

## Metodologia di sviluppo

Il progetto segue il processo **Agile Model Driven Development (AMDD)**, che prevede:
- una fase iniziale di *envisioning* (Iterazione 0),
- successive iterazioni incrementali di design, implementazione e verifica,
- forte integrazione tra requisiti, modelli e codice.

Come riferimento architetturale e metodologico viene utilizzato il **progetto guida CoCoME**, in particolare per:
- la suddivisione in componenti,
- la modellazione dei casi d’uso,
- la coerenza tra UML e implementazione.

---

## Struttura del repository

Il repository è organizzato per iterazioni AMDD numerate:

SmartCanteen/  
│  
├── README.md  
│  
├── iteration-0-envisioning/  
│ ├── requirements/  
│ ├── use-cases/  
│ ├── architecture/  
│ └── sequence/  
│  
├── iteration-1-early-design/  
├── iteration-2-mid/  
├── iteration-3-final/  
│  
└── tools/  
└── postman/  

---

### Iterazione 0 – Envisioning
Contiene:
- analisi dei requisiti funzionali e non funzionali;
- diagrammi dei casi d’uso;
- diagrammi di sequenza di alto livello;
- definizione della topologia iniziale del sistema.

Le iterazioni successive conterranno progressivamente modelli di design, codice sorgente, test, report di analisi statica e dinamica, e artefatti eseguibili.

---

## Tecnologie previste

- Linguaggio: Java  
- Framework: Spring Boot  
- API: REST / JSON  
- Modellazione: UML (draw.io)  
- Testing: JUnit, Postman  
- Analisi statica: Stan4j  
- Versionamento: Git / GitHub  

---

## Licenza

Questo progetto è distribuito sotto licenza **MIT**.  
Consulta il file `LICENSE` per i dettagli.

---

## Autore

Luca Pesenti  
Corso di Laurea Magistrale – Ingegneria Informatica  
Università degli Studi di Bergamo

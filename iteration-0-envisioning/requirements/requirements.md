## 1. Introduzione

Questo documento descrive l’**analisi dei requisiti iniziali** del sistema **SmartCanteen**, sviluppato nell’ambito del corso **Progettazione, Algoritmi e Computabilità [38090]**.

Il documento è prodotto durante l’**Iterazione 0 (Envisioning)** del processo di sviluppo **Agile Model Driven Development (AMDD)** e ha lo scopo di consolidare la visione del sistema, formalizzando i requisiti funzionali e non funzionali emersi nella fase di concezione dell’idea di progetto.

L’obiettivo principale di questa analisi è definire in modo chiaro e non ambiguo *cosa* il sistema SmartCanteen deve fare e *quali vincoli* deve rispettare, senza entrare nel dettaglio delle soluzioni architetturali o implementative, che verranno affrontate nelle iterazioni successive.

Il documento costituisce quindi una **baseline iniziale** per:
- la modellazione dei casi d’uso UML;
- la definizione dell’architettura del sistema;
- la progettazione delle componenti software;
- lo sviluppo incrementale del sistema nelle iterazioni successive.

I termini e i concetti utilizzati nel presente documento fanno riferimento al glossario definito nel file `glossary.md`, che stabilisce il vocabolario ufficiale del dominio applicativo SmartCanteen.

---

## 2. Contesto e scopo del sistema

Il sistema **SmartCanteen** nasce con l’obiettivo di supportare e ottimizzare la gestione operativa di una mensa aziendale, mantenendo invariato il flusso di lavoro tradizionale ma introducendo strumenti digitali per migliorarne efficienza, tracciabilità e controllo.

Nel contesto aziendale di riferimento, il servizio mensa è caratterizzato da:
- accessi regolati per fasce orarie (turni) associate a reparti o gruppi di dipendenti;
- registrazione manuale o parzialmente informatizzata dei pasti consumati;
- difficoltà nel controllo puntuale dei costi e degli sprechi.

SmartCanteen si propone di affrontare queste criticità fornendo un sistema centralizzato in grado di:
- gestire l’accesso dei dipendenti alla mensa tramite badge aziendale;
- tracciare in modo strutturato i pasti serviti;
- automatizzare la gestione di menu, ricette e ingredienti;
- supportare la pianificazione della produzione per turno;
- fornire strumenti di analisi e reporting a supporto delle decisioni gestionali.

Lo scopo del sistema non è quello di sostituire l’organizzazione esistente del servizio mensa, bensì di **digitalizzare e rendere più efficiente un processo già consolidato**, riducendo sprechi, errori operativi e tempi di gestione.

Il sistema SmartCanteen rientra nel dominio dei **sistemi informativi gestionali**, con particolare attenzione alla coerenza dei dati, alla tracciabilità delle operazioni e alla separazione dei ruoli tra i diversi attori coinvolti (dipendenti, staff mensa, chef, manager e amministratori).

Sono esplicitamente **fuori dallo scopo** del sistema:
- la gestione di pagamenti diretti da parte dei dipendenti;
- l’integrazione con fornitori esterni di materie prime;
- la gestione logistica o contabile esterna all’azienda.

Queste funzionalità potranno essere considerate come possibili estensioni future, ma non rientrano negli obiettivi del progetto corrente.

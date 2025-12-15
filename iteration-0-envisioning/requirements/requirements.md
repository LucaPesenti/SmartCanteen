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

---

## 3. Stakeholder e attori

Il sistema SmartCanteen coinvolge diversi soggetti con ruoli, responsabilità e obiettivi differenti.  
In questa sezione vengono identificati sia gli **attori che interagiscono direttamente con il sistema**, sia gli **stakeholder** che ne traggono beneficio o ne influenzano i requisiti.

L’identificazione chiara di questi soggetti è fondamentale per:
- la corretta definizione dei requisiti funzionali;
- la modellazione dei casi d’uso UML;
- la progettazione dell’architettura del sistema.

---

### 3.1 Stakeholder

**Azienda (Owner del sistema)**  
È il principale stakeholder del sistema SmartCanteen. L’azienda è interessata al controllo dei costi del servizio mensa, alla riduzione degli sprechi e alla disponibilità di dati affidabili per analisi e reporting.

**Direzione / Management**  
Utilizza le informazioni prodotte dal sistema per monitorare le performance del servizio mensa, valutare i costi e supportare decisioni strategiche.

**Reparto IT aziendale**  
È responsabile dell’infrastruttura tecnologica e dell’integrazione del sistema SmartCanteen con l’ambiente IT esistente (autenticazione, rete, sicurezza).

---

### 3.2 Attori del sistema

**Employee**  
Dipendente dell’azienda che utilizza il sistema per accedere al servizio mensa tramite badge. Interagisce indirettamente con il sistema durante il check-in e il consumo del pasto.

**Staff Mensa**  
Operatore della mensa incaricato di registrare i piatti serviti ai dipendenti. Utilizza il terminale mensa per associare i piatti a un ticket e completare il servizio del pasto.

**Chef**  
Responsabile della gestione delle ricette, degli ingredienti e delle scorte. Utilizza il sistema per monitorare l’inventario e supportare la pianificazione della produzione.

**Manager**  
Utente che accede alle funzionalità di analisi e reporting. Consulta KPI, report su costi, sprechi e pasti serviti per valutare l’andamento del servizio mensa.

**Admin**  
Utente con privilegi amministrativi. È responsabile della configurazione del sistema, della gestione degli utenti e dell’assegnazione dei ruoli.

---

### 3.3 Relazione tra attori e casi d’uso

Gli attori individuati in questa sezione costituiscono la base per la modellazione dei casi d’uso descritti nell’Iterazione 0.  
Ogni requisito funzionale sarà associato a uno o più attori, garantendo la tracciabilità tra requisiti, casi d’uso UML e funzionalità del sistema.

I ruoli e i termini utilizzati in questa sezione sono coerenti con le definizioni riportate nel file `glossary.md`.

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

---

## 4. Requisiti funzionali

In questa sezione sono descritti i **requisiti funzionali** del sistema SmartCanteen.  
Essi definiscono le funzionalità che il sistema deve fornire per supportare il processo operativo della mensa aziendale.

Ogni requisito funzionale è identificato da un codice univoco (RFx) ed è espresso in modo chiaro e verificabile.  
I requisiti qui riportati rappresentano una **baseline iniziale** e potranno essere raffinati e dettagliati nelle iterazioni successive del processo AMDD.

---

### RF1 – Check-in del dipendente tramite badge

Il sistema deve consentire al dipendente di effettuare il check-in alla mensa utilizzando il badge aziendale.

A seguito del check-in, il sistema deve:
- identificare il dipendente;
- verificare la validità del turno di accesso;
- creare un **Ticket** associato al dipendente e al turno corrente, con stato iniziale `OPEN`.

---

### RF2 – Gestione del ticket di accesso

Il sistema deve gestire il ciclo di vita del **Ticket**, che rappresenta il diritto del dipendente a consumare un pasto in un determinato turno.

Il ticket deve poter assumere i seguenti stati:
- `OPEN`: ticket valido e in attesa di servizio;
- `SERVED`: pasto servito correttamente;
- `EXPIRED`: ticket scaduto per superamento del tempo massimo consentito;
- `NO_SHOW`: ticket non utilizzato dal dipendente.

---

### RF3 – Registrazione del servizio del pasto

Il sistema deve consentire allo **Staff Mensa** di registrare i piatti serviti a un dipendente associandoli a un ticket `OPEN`.

Durante la registrazione del servizio, il sistema deve:
- validare i vincoli sul numero massimo di piatti per tipologia (primo, secondo, contorno);
- verificare la disponibilità degli ingredienti necessari;
- completare il servizio del pasto aggiornando lo stato del ticket a `SERVED`.

---

### RF4 – Gestione del menu giornaliero

Il sistema deve permettere la gestione e la consultazione del **menu giornaliero** della mensa.

In particolare, il sistema deve:
- distinguere tra piatti del giorno e piatti sempre disponibili;
- consentire la visualizzazione del menu in base alla data e alla mensa;
- rendere il menu consultabile dagli attori autorizzati.

---

### RF5 – Gestione di ricette e ingredienti

Il sistema deve consentire allo **Chef** e agli utenti autorizzati di gestire:
- le ricette associate ai piatti;
- gli ingredienti utilizzati e le relative quantità;
- le informazioni di costo e unità di misura degli ingredienti.

Ogni piatto deve essere associato a una ricetta che ne definisce la composizione.

---

### RF6 – Aggiornamento automatico dell’inventario

A seguito del servizio di un pasto, il sistema deve:
- calcolare le quantità di ingredienti utilizzate in base alle ricette;
- decrementare automaticamente l’inventario degli ingredienti;
- garantire la coerenza dei dati tramite operazioni atomiche.

---

### RF7 – Pianificazione della produzione per turno

Il sistema deve supportare la **pianificazione della produzione** dei piatti per ciascun turno.

Il sistema deve:
- analizzare i dati storici dei pasti serviti;
- suggerire un **Production Plan** con le quantità di piatti da preparare;
- consentire allo Chef di consultare e utilizzare tali suggerimenti.

---

### RF8 – Contabilizzazione del pasto

Per ogni pasto servito, il sistema deve:
- generare una **Finance Entry**;
- associare il costo del pasto al **centro di costo** del dipendente;
- memorizzare le informazioni necessarie per il reporting contabile.

---

### RF9 – Reporting e analisi

Il sistema deve fornire funzionalità di reporting a supporto della gestione del servizio mensa.

In particolare, il sistema deve consentire:
- la consultazione del numero di pasti serviti;
- l’analisi dei costi e del food cost;
- la valutazione degli sprechi e dei casi di `NO_SHOW`.

---

### RF10 – Gestione dei ruoli e delle autorizzazioni

Il sistema deve supportare la gestione dei ruoli degli utenti e limitare l’accesso alle funzionalità in base al ruolo assegnato.

I ruoli principali includono:
- Employee;
- Staff Mensa;
- Chef;
- Manager;
- Admin.

---

## 5. Requisiti non funzionali

In questa sezione sono descritti i **requisiti non funzionali** del sistema SmartCanteen.  
Essi definiscono le qualità, i vincoli e le caratteristiche operative che il sistema deve rispettare, influenzando direttamente le scelte architetturali e progettuali.

I requisiti non funzionali qui riportati rappresentano una definizione iniziale e potranno essere raffinati e misurati in modo più puntuale nelle iterazioni successive.

---

### RNF1 – Sicurezza

Il sistema deve garantire un adeguato livello di sicurezza per proteggere dati e funzionalità.

In particolare, il sistema deve:
- utilizzare comunicazioni sicure tramite protocollo TLS;
- supportare l’autenticazione degli utenti tramite meccanismi aziendali;
- gestire l’accesso alle funzionalità in base ai ruoli degli utenti;
- prevenire accessi non autorizzati ai dati sensibili.

---

### RNF2 – Affidabilità e consistenza dei dati

Il sistema deve garantire l’affidabilità delle operazioni e la consistenza dei dati.

In particolare:
- le operazioni critiche (es. servizio del pasto) devono essere atomiche;
- il sistema deve prevenire stati inconsistenti dei ticket e dell’inventario;
- devono essere gestiti correttamente casi di errore o interruzione del servizio.

---

### RNF3 – Performance

Il sistema deve garantire tempi di risposta adeguati per supportare il flusso operativo della mensa.

In condizioni operative normali:
- le operazioni principali devono essere completate entro tempi compatibili con l’utilizzo in tempo reale;
- il sistema deve supportare un numero adeguato di accessi concorrenti durante i turni di punta.

---

### RNF4 – Usabilità

Il sistema deve essere semplice e rapido da utilizzare, in particolare per lo **Staff Mensa** durante le operazioni di servizio.

In particolare:
- l’interazione con il terminale mensa deve richiedere un numero minimo di operazioni;
- le informazioni rilevanti devono essere facilmente accessibili;
- l’interfaccia deve ridurre il rischio di errori operativi.

---

### RNF5 – Scalabilità

Il sistema deve essere progettato in modo da poter scalare in funzione delle esigenze aziendali.

In particolare:
- deve supportare più mense o sedi aziendali;
- deve consentire l’aggiunta di nuovi utenti e ruoli;
- deve poter gestire un aumento del volume di dati nel tempo.

---

### RNF6 – Manutenibilità ed estendibilità

Il sistema deve essere progettato per facilitare la manutenzione e l’evoluzione futura.

In particolare:
- il codice deve essere strutturato in modo modulare;
- l’architettura deve supportare l’introduzione di nuove funzionalità;
- la documentazione deve essere mantenuta coerente con l’evoluzione del sistema.

---

### RNF7 – Portabilità

Il sistema deve poter essere eseguito su infrastrutture standard senza dipendenze proprietarie vincolanti.

In particolare:
- deve essere distribuibile come applicazione Java;
- deve poter essere eseguito su ambienti server comuni;
- l’installazione e la configurazione devono essere riproducibili.

---

## 6. Assunzioni e vincoli

In questa sezione sono riportate le **assunzioni** e i **vincoli** considerati nella definizione dei requisiti del sistema SmartCanteen.  
Esplicitare tali aspetti consente di delimitare correttamente il perimetro del progetto e di chiarire il contesto in cui il sistema verrà progettato e sviluppato.

---

### 6.1 Assunzioni

- Si assume che ogni dipendente dell’azienda sia identificato in modo univoco tramite un badge aziendale valido.
- Si assume che l’azienda disponga di un sistema di autenticazione centralizzato per la gestione degli utenti e dei ruoli.
- Si assume che il servizio mensa operi secondo turni predefiniti associati a specifici reparti o gruppi di dipendenti.
- Si assume che i processi operativi della mensa siano già consolidati e che il sistema SmartCanteen debba supportarli senza modificarne la struttura di base.
- Si assume la disponibilità di dati storici sui pasti serviti, utili per la pianificazione della produzione.

---

### 6.2 Vincoli tecnologici

- Il sistema deve essere sviluppato utilizzando il linguaggio **Java**.
- L’architettura applicativa deve essere basata su servizi **REST** con scambio dati in formato **JSON**.
- Il framework di riferimento per il backend è **Spring Boot**.
- Il versionamento del codice e della documentazione deve essere gestito tramite **Git**.
- La modellazione dei requisiti e dell’architettura deve essere espressa tramite diagrammi **UML**.

---

### 6.3 Vincoli architetturali e organizzativi

- Il sistema deve adottare un’architettura centralizzata con terminali di servizio collegati a un server centrale.
- Le operazioni critiche devono garantire coerenza e atomicità dei dati.
- Il sistema deve essere utilizzabile in un contesto aziendale interno, con particolare attenzione alla sicurezza e alla tracciabilità.
- Il progetto deve essere sviluppato seguendo il processo **Agile Model Driven Development (AMDD)**, articolato in iterazioni numerate e documentate.

---

## 7. Tracciabilità iniziale dei requisiti

In questa sezione viene fornita una **tracciabilità iniziale** tra i requisiti funzionali definiti e i principali casi d’uso del sistema SmartCanteen.

Lo scopo di questa tracciabilità è:
- garantire la coerenza tra requisiti e modellazione UML;
- facilitare la comprensione dell’impatto dei requisiti sulle funzionalità del sistema;
- costituire una base per la tracciabilità più dettagliata che verrà sviluppata nelle iterazioni successive.

La tracciabilità qui presentata è di livello alto ed è coerente con gli obiettivi dell’Iterazione 0 (Envisioning).

---

### 7.1 Mappatura requisiti funzionali – casi d’uso

| Requisito Funzionale | Caso d’Uso Principale | Attori Coinvolti |
|---------------------|----------------------|------------------|
| RF1 – Check-in del dipendente tramite badge | Check-in dipendente | Employee |
| RF2 – Gestione del ticket di accesso | Gestione ticket | Employee, Staff Mensa |
| RF3 – Registrazione del servizio del pasto | Servire pasto | Staff Mensa |
| RF4 – Gestione del menu giornaliero | Consultazione / gestione menu | Staff Mensa, Chef |
| RF5 – Gestione di ricette e ingredienti | Gestione ricette e ingredienti | Chef |
| RF6 – Aggiornamento automatico dell’inventario | Aggiornamento inventario | Chef |
| RF7 – Pianificazione della produzione per turno | Pianificazione produzione | Chef |
| RF8 – Contabilizzazione del pasto | Contabilizzazione pasto | Manager |
| RF9 – Reporting e analisi | Consultazione report | Manager |
| RF10 – Gestione dei ruoli e delle autorizzazioni | Gestione utenti e ruoli | Admin |

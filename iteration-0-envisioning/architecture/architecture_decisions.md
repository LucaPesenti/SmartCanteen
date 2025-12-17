# Decisioni architetturali – Iterazione 0

Questo documento riporta le principali decisioni architetturali adottate per il sistema SmartCanteen durante l’Iterazione 0 (Envisioning) del processo AMDD.

Le decisioni qui descritte hanno lo scopo di motivare le scelte effettuate a livello di architettura iniziale, senza entrare in dettagli implementativi, che verranno affrontati nelle iterazioni successive.

---

## AD1 – Adozione di un’architettura client–server

### Decisione
Il sistema SmartCanteen adotta un’architettura **client–server**, con un backend centrale che fornisce i servizi applicativi.

### Motivazione
I casi d’uso identificati prevedono:
- più tipologie di client (terminali mensa, client di gestione);
- accesso concorrente al sistema;
- necessità di centralizzare dati e logica di business.

Un backend centrale consente di garantire coerenza dei dati, semplificare la gestione della sicurezza e facilitare l’evoluzione del sistema.

---

## AD2 – Esposizione dei servizi tramite API REST

### Decisione
La comunicazione tra client e backend avviene tramite **API REST**, con scambio di dati in formato JSON.

### Motivazione
Le API REST permettono:
- comunicazioni stateless;
- interoperabilità tra client eterogenei;
- semplicità di integrazione e scalabilità.

Questa scelta è coerente con i requisiti non funzionali di portabilità e manutenibilità.

---

## AD3 – Separazione logica dei servizi applicativi

### Decisione
La logica di business del backend è organizzata in **servizi logici** (Ticket, Meal, Inventory, Accounting, Reporting).

### Motivazione
La separazione dei servizi:
- migliora la chiarezza architetturale;
- favorisce la manutenibilità;
- consente una possibile evoluzione verso architetture più distribuite nelle iterazioni successive.

In Iterazione 0 i servizi sono da intendersi come **responsabilità logiche**, non come unità di deployment separate.

---

## AD4 – Persistenza centralizzata dei dati

### Decisione
Il sistema utilizza un **database centrale** per la memorizzazione dei dati.

### Motivazione
Una persistenza centralizzata è necessaria per:
- garantire la consistenza dei dati;
- supportare operazioni transazionali;
- consentire analisi e reporting basati su dati storici.

Questa scelta è coerente con i casi d’uso critici del sistema, come il servizio del pasto e la contabilizzazione.

---

## AD5 – Integrazione con sistemi esterni

### Decisione
Il sistema prevede un’interfaccia di integrazione con un **sistema di contabilità aziendale esterno**.

### Motivazione
La contabilizzazione dei pasti richiede l’interoperabilità con sistemi aziendali esistenti.  
Prevedere esplicitamente l’integrazione sin dall’Iterazione 0 consente di:
- delimitare chiaramente i confini del sistema;
- evitare dipendenze rigide;
- supportare future estensioni.

---

## Considerazioni finali

Le decisioni architetturali qui riportate costituiscono una **baseline iniziale**.  
Esse potranno essere raffinate, estese o parzialmente riviste nelle iterazioni successive del progetto, in conformità con il processo AMDD.

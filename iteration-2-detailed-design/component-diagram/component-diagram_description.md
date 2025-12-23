# Diagramma dei Componenti – Iterazione 2 

Il presente Component Diagram descrive l’architettura software del sistema **SmartCanteen** a livello di componenti, secondo un punto di vista logico–architetturale. L’obiettivo del diagramma è rappresentare:

* la suddivisione del sistema in macro-componenti coerenti;
* le responsabilità principali di ciascun componente;
* le interfacce esposte e richieste;
* le dipendenze tra i componenti;
* il rapporto tra i layer applicativi e l’infrastruttura.

---

## Contesto Architetturale

SmartCanteen è un’applicazione backend basata su **Spring Boot**, che espone **API REST** per la gestione delle operazioni principali di una mensa universitaria (check-in dipendenti, gestione ticket, erogazione pasti, inventario ingredienti, contabilizzazione).

L’architettura segue una struttura **a layer**, coerente con le best practice Spring e con il modello architetturale di riferimento del progetto guida **CoCoMe**.

---

## Componenti Identificati

### Client REST (External Component)

**Stereotipo:** `<<external>>`

**Descrizione:**
Rappresenta un generico client HTTP che interagisce con il sistema SmartCanteen tramite API REST. Può essere:

* Postman (per il testing delle API);
* una futura interfaccia grafica (desktop o web);
* un sistema terzo.

**Responsabilità:**

* invocare endpoint REST;
* inviare richieste HTTP (GET, POST, ecc.);
* ricevere risposte JSON.

---

### SmartCanteen REST API (Web Layer)

**Stereotipo:** `<<component>>`

**Package Java associato:** `controller`

**Descrizione:**
Questo componente rappresenta il livello di esposizione delle API REST del sistema. Incapsula tutti i controller Spring e la gestione centralizzata delle eccezioni.

**Include logicamente:**

* `EmployeeController`
* `TicketController`
* `GlobalExceptionHandler`

**Responsabilità:**

* esposizione degli endpoint REST;
* validazione degli input;
* conversione DTO ↔ modello di dominio;
* gestione degli errori HTTP e delle risposte standardizzate.

**Interfacce fornite:**

* `IEmployeeAPI`
* `ITicketAPI`

---

### Application Services (Business Logic Layer)

**Stereotipo:** `<<component>>`

**Package Java associato:** `service`

**Descrizione:**
Rappresenta il cuore della logica applicativa. Questo componente implementa i casi d’uso del sistema e coordina le operazioni tra dominio e persistenza.

**Include logicamente:**

* `CheckInService`
* `MealService`

**Responsabilità:**

* implementazione dei casi d’uso;
* applicazione delle regole di business;
* gestione delle eccezioni di dominio;
* orchestrazione delle operazioni sui repository.

**Interfacce fornite:**

* `ICheckInService`
* `IMealService`

**Interfacce richieste:**

* interfacce dei repository di persistenza.

---

### Domain Model

**Stereotipo:** `<<component>>`

**Package Java associato:** `model`

**Descrizione:**
Contiene le entità di dominio del sistema SmartCanteen. Rappresenta lo stato e le informazioni fondamentali del sistema.

**Include:**

* `Employee`
* `Meal`
* `Ticket`
* `Ingredient`
* `AccountingEntry`

**Responsabilità:**

* rappresentazione dei concetti di dominio;
* mantenimento dello stato;
* definizione delle invarianti di business.

Questo componente non dipende da layer superiori.

---

### Persistence / Repository Layer

**Stereotipo:** `<<component>>`

**Package Java associato:** `repository`

**Descrizione:**
Fornisce l’accesso ai dati persistenti del sistema, isolando la logica di business dai dettagli di memorizzazione.

**Include logicamente:**

* `EmployeeRepository`
* `TicketRepository`
* `InventoryRepository`
* `AccountingRepository`

**Responsabilità:**

* gestione CRUD delle entità;
* astrazione del meccanismo di persistenza;
* supporto alla logica applicativa.

---

### Data Store

**Stereotipo:** `<<database>>`

**Descrizione:**
Rappresenta il sistema di persistenza dei dati. Nel contesto attuale può essere un database in-memory o un datastore semplificato, utilizzato per supportare lo sviluppo e il testing.

Il dettaglio tecnologico del database non è oggetto del diagramma.

---

## Dipendenze tra i Componenti

Le dipendenze tra i componenti seguono una direzione univoca e coerente con l’architettura a layer:

```
Client REST
   ↓
SmartCanteen REST API
   ↓
Application Services
   ↓
Domain Model
   ↓
Persistence / Repository
   ↓
Data Store
```

Non sono presenti dipendenze cicliche né accessi diretti tra layer non adiacenti.

# Deployment Diagram – Iterazione 2 

Il deployment diagram ha lo scopo di descrivere la configurazione fisica e logica del sistema SmartCanteen a runtime, evidenziando i nodi di esecuzione, gli artefatti software deployati e le modalità di comunicazione tra le principali parti del sistema.

---

## Panoramica dell’architettura di deployment

Il sistema SmartCanteen è progettato secondo un’architettura client-server basata su API REST.

L’architettura di deployment è composta dai seguenti nodi principali:

- Client REST
- Application Server
- Data Storage

Ogni nodo rappresenta un’unità fisica o logica coinvolta nell’esecuzione del sistema a runtime.

---

## Descrizione dei nodi

### Client REST («device»)

Il nodo *Client REST* rappresenta qualsiasi sistema esterno in grado di interagire con il backend SmartCanteen tramite API REST.

Esempi di client includono:
- strumenti di test delle API (es. Postman),
- interfacce grafiche future,
- altri sistemi software integrati.

Il client comunica con il server utilizzando il protocollo HTTP e scambia dati in formato JSON.

---

### Application Server («executionEnvironment»)

Il nodo *Application Server* ospita l’applicazione backend SmartCanteen ed è responsabile dell’elaborazione delle richieste REST, dell’esecuzione della logica di business e della gestione dei dati.

All’interno di questo nodo sono presenti:

- **Execution Environment**
  - Java Virtual Machine (JVM)
  - Spring Boot Runtime

- **Artifact**
  - `smartcanteen.jar`, che rappresenta l’artefatto software deployato e contiene l’intera applicazione backend.

Questo nodo incapsula l’architettura applicativa definita nel component diagram e implementata nel codice sorgente.

---

### Data Storage («database»)

Il nodo *Data Storage* rappresenta il livello di persistenza dei dati del sistema.

Nell’attuale configurazione progettuale, la persistenza è realizzata tramite un **livello di memorizzazione in-memory**, utilizzato attraverso i repository dell’applicazione.

Questo approccio è coerente con l’obiettivo didattico del progetto e consente di focalizzarsi sulla logica applicativa senza introdurre dipendenze da sistemi di database esterni.

---

## Comunicazioni tra i nodi

Le comunicazioni tra i nodi sono le seguenti:

- **Client REST ↔ Application Server**
  - Protocollo: HTTP
  - Stile architetturale: REST
  - Formato dei dati: JSON

- **Application Server ↔ Data Storage**
  - Modalità di accesso: Repository pattern
  - Responsabilità: lettura e scrittura dei dati applicativi

---

## Considerazioni progettuali

Il deployment diagram è mantenuto volutamente ad un livello di astrazione medio-alto, coerente con la fase di *Design Dettagliato* dell’approccio AMDD.

Non vengono rappresentati dettagli infrastrutturali specifici (come sistemi operativi, container o configurazioni di rete), in quanto non rilevanti per gli obiettivi del progetto e per la comprensione dell’architettura software.

# Iterazione 4 – GUI Desktop e Integrazione con Backend REST

## Obiettivi dell’iterazione

L’obiettivo principale di questa iterazione è stato lo sviluppo di una **GUI desktop funzionale** per il sistema SmartCanteen, in grado di interagire correttamente con il backend REST già implementato.

In particolare, l’iterazione ha mirato a:
- fornire un’interfaccia grafica chiara e utilizzabile;
- integrare correttamente le API REST esistenti;
- supportare i casi d’uso principali del sistema;
- migliorare la qualità complessiva della presentazione del progetto.

---

## Funzionalità implementate

Durante questa iterazione sono state implementate le seguenti funzionalità:

- **GUI desktop basata su Java Swing**
- Navigazione tramite finestra principale (`MainWindow`)
- Gestione dei casi d’uso:
  - **UC1 – Check-in del dipendente**
  - **UC2 – Servizio del pasto**
- Comunicazione con il backend tramite client HTTP dedicato (`RestClient`)
- Parsing delle risposte JSON e visualizzazione user-friendly dei risultati
- Gestione degli errori con feedback visivo differenziato
- Icone personalizzate per applicazione e pulsanti
- Miglioramenti grafici e di usabilità

---

## Componenti principali realizzati

| Componente | Descrizione |
|-----------|------------|
| `MainWindow` | Finestra principale di navigazione |
| `CheckInFrame` | Interfaccia per il check-in del dipendente |
| `ServeMealFrame` | Interfaccia per il servizio del pasto |
| `RestClient` | Client HTTP per chiamate REST |
| `GuiUtils` | Utility grafiche (icone, scaling, app icon) |

---

## Casi d’uso coperti

| Caso d’uso | Stato |
|-----------|-------|
| UC1 – Check-in dipendente | ✅ Completato |
| UC2 – Servizio pasto | ✅ Completato |

Entrambi i casi d’uso sono completamente supportati dalla GUI e correttamente integrati con il backend REST.

---

## Aspetti tecnici rilevanti

- Utilizzo di **WindowBuilder** per la progettazione delle schermate Swing
- Comunicazione sincrona tramite `java.net.http.HttpClient`
- Parsing JSON con **Jackson**
- Separazione tra logica di presentazione e comunicazione REST
- Validazione degli input lato client
- Formattazione leggibile delle date e dei dati restituiti dal backend

---

## Miglioramenti rispetto alle iterazioni precedenti

- Introduzione di una GUI completa al posto dell’interazione esclusivamente via API
- Maggiore usabilità e chiarezza operativa
- Migliore presentazione del progetto tramite schermate documentate
- Feedback immediato all’utente in caso di successo o errore
- Coerenza grafica tra le diverse schermate

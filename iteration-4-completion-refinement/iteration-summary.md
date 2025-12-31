# Iterazione 4 – GUI Desktop e Integrazione con Backend REST

## Obiettivi dell’iterazione

L’obiettivo principale dell’Iterazione 4 è stato lo sviluppo di una **interfaccia grafica desktop** per il sistema SmartCanteen, in grado di interagire correttamente con il backend REST implementato nelle iterazioni precedenti.

In particolare, questa iterazione ha mirato a:

* fornire un’interfaccia grafica chiara, coerente e utilizzabile;
* integrare le API REST esistenti tramite un client dedicato;
* supportare operativamente i casi d’uso principali del sistema;
* migliorare la qualità complessiva della presentazione e dell’esperienza utente del progetto.

---

## Attività svolte

Durante l’Iterazione 4 sono state svolte attività di **sviluppo e integrazione lato client**, focalizzate sulla realizzazione di una GUI desktop e sulla sua connessione con il backend REST.

Le principali attività hanno incluso:

* progettazione delle schermate Swing;
* implementazione della navigazione tra le finestre;
* integrazione delle chiamate REST;
* gestione degli errori e dei feedback utente;
* miglioramento dell’aspetto grafico e dell’usabilità.

---

## Artefatti prodotti

Nel corso dell’Iterazione 4 sono stati realizzati i seguenti artefatti:

* **GUI desktop Java Swing**

  * Interfaccia grafica completa per l’interazione con il sistema SmartCanteen.

* **Finestra principale (`MainWindow`)**

  * Punto di accesso ai casi d’uso principali e navigazione tra le schermate.

* **Schermate dedicate ai casi d’uso**

  * `CheckInFrame` per UC1 – Check-in del dipendente.
  * `ServeMealFrame` per UC2 – Servizio del pasto.

* **Client REST**

  * Componente `RestClient` per la comunicazione HTTP con il backend.

* **Utility grafiche**

  * Classe `GuiUtils` per la gestione di icone, scaling e icona dell’applicazione.

* **Documentazione grafica**

  * Screenshot delle schermate principali.
  * File `gui-description.md` con descrizione dettagliata dell’interfaccia.

---

## Copertura dei casi d’uso

La GUI realizzata in questa iterazione consente l’esecuzione completa dei seguenti casi d’uso:

* UC1 – Check-in del dipendente
* UC2 – Servizio del pasto

I casi d’uso rimanenti non sono esposti tramite interfaccia grafica in questa fase e rimangono accessibili esclusivamente via API REST, in linea con gli obiettivi dell’iterazione.

---

## Aspetti tecnici rilevanti

Dal punto di vista tecnico, l’Iterazione 4 ha introdotto:

* utilizzo di **Java Swing** per la realizzazione della GUI;
* progettazione delle schermate tramite **WindowBuilder**;
* comunicazione sincrona con il backend tramite `java.net.http.HttpClient`;
* parsing delle risposte JSON tramite **Jackson**;
* separazione tra logica di presentazione e comunicazione REST;
* validazione degli input lato client;
* formattazione user-friendly dei dati restituiti dal backend.

---

## Considerazioni progettuali

L’introduzione della GUI ha permesso di:

* validare l’usabilità delle API REST dal punto di vista dell’utente finale;
* verificare la correttezza dell’integrazione client–server;
* migliorare la chiarezza operativa dei flussi dei casi d’uso principali;
* mantenere una separazione netta tra backend applicativo e frontend desktop.

Le scelte effettuate risultano coerenti con l’architettura definita nelle iterazioni precedenti e con l’approccio incrementale previsto da AMDD.

---

## Stato del progetto al termine dell’iterazione

Al termine dell’Iterazione 4, il progetto SmartCanteen dispone di:

* un backend REST funzionante e validato;
* una GUI desktop operativa per i principali casi d’uso;
* un’integrazione completa tra client grafico e servizi REST;
* documentazione aggiornata a supporto dell’utilizzo dell’applicazione.

In questa fase:

* la GUI copre solo i casi d’uso principali;
* non sono state introdotte funzionalità avanzate (autenticazione, ruoli, persistenza reale);
* il sistema è orientato a una dimostrazione funzionale e completa dei flussi core.

L’Iterazione 4 rappresenta quindi una **fase di completamento e rifinitura**, finalizzata a rendere il sistema utilizzabile e presentabile, senza modificare le fondamenta architetturali già validate.

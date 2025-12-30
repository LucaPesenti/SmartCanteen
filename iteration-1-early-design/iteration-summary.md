# Iterazione 1 – Early Design

## Obiettivi dell’iterazione

L’obiettivo dell’Iterazione 1 è stato quello di trasformare la visione concettuale e i requisiti definiti nell’Iterazione 0 in una **prima progettazione strutturata del sistema**, introducendo i modelli fondamentali del dominio e i principali flussi di interazione.

In particolare, questa iterazione ha mirato a:

* modellare il dominio applicativo in modo formale;
* chiarire le entità principali e le loro relazioni;
* analizzare il comportamento dinamico dei casi d’uso più rilevanti;
* porre le basi per le successive attività di design di dettaglio.

---

## Attività svolte

Durante l’Iterazione 1 sono state svolte attività di **early design**, focalizzate sulla comprensione strutturale e comportamentale del sistema, senza ancora entrare nel dettaglio architetturale o implementativo.

Le principali attività hanno incluso:

* modellazione del dominio tramite diagramma delle classi concettuale;
* identificazione delle principali entità, attributi e relazioni;
* analisi dei flussi dinamici dei casi d’uso chiave;
* definizione delle responsabilità a livello concettuale.

---

## Artefatti prodotti

Nel corso dell’Iterazione 1 sono stati prodotti i seguenti artefatti:

### Domain Model

* **Diagramma del dominio**

  * Rappresentazione delle entità principali del sistema SmartCanteen.
  * Modellazione delle relazioni fondamentali tra dipendenti, ticket, pasti, ricette e inventario.
* **Descrizione del modello di dominio**

  * Spiegazione testuale delle classi concettuali e delle loro responsabilità.

### Sequence Diagram

* **Diagrammi di sequenza**

  * Modellazione dei flussi dinamici dei casi d’uso principali.
  * In particolare, è stato analizzato nel dettaglio il caso d’uso **UC2 – Servizio del Pasto**.
* **Descrizione dei diagrammi di sequenza**

  * Spiegazione passo-passo delle interazioni tra attori e sistema.

---

## Copertura dei casi d’uso

L’Iterazione 1 ha approfondito, dal punto di vista strutturale e dinamico, i casi d’uso principali del sistema, con particolare attenzione a:

* UC2 – Servizio del pasto (analizzato in dettaglio tramite diagramma di sequenza)
* UC1 – Check-in del dipendente (considerato a livello concettuale)
* Casi d’uso correlati alla gestione dei ticket e dei pasti

L’analisi ha permesso di chiarire:

* le interazioni fondamentali tra attore e sistema;
* l’ordine delle operazioni principali;
* le responsabilità logiche delle entità coinvolte.

---

## Considerazioni progettuali

Le attività di progettazione dell’Iterazione 1 sono state guidate dai seguenti principi:

* centralità del modello di dominio;
* separazione tra struttura statica e comportamento dinamico;
* progressiva introduzione dei dettagli, evitando over-design precoce;
* allineamento continuo con i requisiti definiti nell’Iterazione 0.

In questa fase non sono state ancora introdotte:

* decisioni architetturali di dettaglio;
* tecnologie specifiche;
* modelli di implementazione.

Tali scelte sono state volutamente rimandate alle iterazioni successive.

---

## Stato del progetto al termine dell’iterazione

Al termine dell’Iterazione 1, il progetto SmartCanteen dispone di:

* un modello di dominio formalizzato e condiviso;
* una comprensione chiara delle entità principali del sistema;
* una prima analisi dei flussi dinamici dei casi d’uso chiave;
* una base solida per procedere con la progettazione tecnica di dettaglio.

Questa iterazione costituisce un **ponte naturale** tra l’envisioning iniziale e la fase di detailed design prevista nelle iterazioni successive.

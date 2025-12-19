# Iterazione 2 – Detailed Design

## Obiettivo dell’iterazione

L’obiettivo dell’Iterazione 2 è stato quello di trasformare i modelli concettuali e funzionali definiti nelle iterazioni precedenti in una progettazione tecnica dettagliata, pronta per l’implementazione.

In particolare, questa iterazione si è concentrata sulla definizione della struttura statica del sistema e dei contratti di comunicazione esposti verso l’esterno.

---

## Artefatti prodotti

Durante l’Iterazione 2 sono stati realizzati i seguenti artefatti:

- Diagramma delle classi complessivo, che descrive la struttura statica del sistema e le responsabilità delle principali entità e servizi.
- Specifica delle API REST, organizzata per risorse e casi d’uso, comprensiva di endpoint, parametri, risposte e codici di errore.
- Modello unificato di gestione degli errori REST.

Non sono stati prodotti nuovi diagrammi di sequenza, in quanto i flussi dinamici principali erano già stati analizzati e validati nell’Iterazione 1 e non hanno subito variazioni progettuali significative.

---

## Copertura dei casi d’uso

Le API REST definite in questa iterazione coprono tutti i casi d’uso primari del sistema SmartCanteen:

- UC1 – Check-in del dipendente
- UC2 – Servizio del pasto
- UC4 – Gestione di ricette e ingredienti
- UC5 – Consultazione dello stato dell’inventario
- UC7 – Consultazione dei report dei pasti erogati
- UC8 – Consultazione dello stato operativo della mensa
- UC9 – Esportazione dei dati amministrativi

I casi d’uso di supporto interno sono stati integrati all’interno delle operazioni principali e non esposti come endpoint REST autonomi.

---

## Considerazioni progettuali

La progettazione ha seguito i principi RESTful e una chiara separazione tra risorse, logica applicativa e responsabilità di dominio.

L’assenza di codice implementativo in questa iterazione è intenzionale e coerente con l’approccio AMDD adottato: l’Iterazione 2 ha avuto come scopo la definizione del “come” il sistema sarà costruito, senza anticipare l’implementazione.

---

## Stato finale dell’iterazione

Al termine dell’Iterazione 2, il sistema SmartCanteen dispone di una progettazione tecnica completa e coerente, sufficiente per avviare l’implementazione del codice applicativo.


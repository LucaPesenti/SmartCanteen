# Iterazione 2 – Design dettagliato

## Obiettivo dell’iterazione

L’obiettivo dell’Iterazione 2 è stato quello di trasformare i modelli concettuali e funzionali definiti nelle iterazioni precedenti in una progettazione tecnica dettagliata, pronta per l’implementazione.

In particolare, questa iterazione si è concentrata sulla definizione della struttura statica del sistema e dei contratti di comunicazione esposti verso l’esterno.

---

## Artefatti prodotti

Durante l’Iterazione 2 sono stati realizzati i seguenti artefatti:

- Diagramma delle classi complessivo, che descrive la struttura statica del sistema e le responsabilità delle principali entità e servizi.
- Diagramma dei componenti, che rappresenta l’architettura logica del sistema, evidenziando i principali componenti software, i layer architetturali e le dipendenze tra di essi.
- Specifica delle API REST, organizzata per risorse e casi d’uso, comprensiva di endpoint, parametri, risposte e codici di errore.
- Modello unificato di gestione degli errori REST, condiviso tra tutti gli endpoint per garantire coerenza semantica e semplicità di integrazione lato client.

Non sono stati prodotti nuovi diagrammi di sequenza, in quanto i flussi dinamici principali erano già stati analizzati e validati nell’Iterazione 1 e non hanno subito variazioni progettuali significative tali da richiedere un ulteriore raffinamento.

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

I casi d’uso di supporto interno sono stati integrati all’interno delle operazioni principali e non esposti come endpoint REST autonomi, in linea con i principi di incapsulamento e responsabilità dei servizi applicativi.

---

## Considerazioni progettuali

La progettazione ha seguito i principi RESTful e una chiara separazione delle responsabilità tra:
- livello di presentazione (controller REST),
- livello applicativo (servizi),
- livello di persistenza (repository),
- modello di dominio.

Il diagramma dei componenti ha consentito di validare l’architettura complessiva prima dell’implementazione, verificando la correttezza delle dipendenze tra i layer e l’assenza di accoppiamenti impropri.

L’assenza di codice implementativo in questa iterazione è intenzionale e coerente con l’approccio AMDD adottato: l’Iterazione 2 ha avuto come scopo la definizione del “come” il sistema sarà costruito, senza anticipare l’implementazione.

---

## Stato finale dell’iterazione

Al termine dell’Iterazione 2, il sistema SmartCanteen dispone di una progettazione tecnica completa, coerente e validata a livello architetturale, sufficiente per avviare l’implementazione del codice applicativo nelle iterazioni successive.


# Descrizione della GUI - Iterazione 4

La GUI di SmartCanteen rappresenta l’interfaccia desktop del sistema ed è stata sviluppata utilizzando **Java Swing** con il supporto del plugin **WindowBuilder** di Eclipse.

L’obiettivo della GUI è fornire un’interazione semplice, chiara e immediata con le principali funzionalità del backend REST, mantenendo una struttura coerente con i casi d’uso definiti nelle iterazioni precedenti.

L’interfaccia è pensata per l’utilizzo da parte del personale della mensa e supporta, in questa iterazione, i seguenti casi d’uso:
- **UC1 – Check-in del dipendente**
- **UC2 – Servizio del pasto**

---

## Architettura della GUI

La GUI è organizzata secondo una struttura a finestre (`JFrame`) indipendenti:

- **MainWindow**: finestra principale di navigazione
- **CheckInFrame**: schermata dedicata al check-in del dipendente
- **ServeMealFrame**: schermata dedicata al servizio del pasto

Ogni finestra:
- è indipendente dal backend a livello di stato;
- comunica con il sistema tramite chiamate REST sincrone;
- delega la comunicazione HTTP al componente `RestClient`.

---

## MainWindow

### Scopo
La `MainWindow` rappresenta il punto di accesso principale all’applicazione e consente all’utente di navigare verso le funzionalità disponibili.

### Componenti principali
- Titolo applicazione (“SmartCanteen”)
- Due pulsanti di azione principali:
  - **Check-in Dipendente**
  - **Servizio Pasto**
- Etichetta di stato del backend

### Screenshot
![MainWindow](gui/screenshots/main-window.png)

---

## CheckInFrame

### Scopo
La `CheckInFrame` consente di eseguire il **check-in di un dipendente** (UC1) inserendo il relativo identificativo.

### Componenti principali
- Campo di input:
  - ID Dipendente
- Pulsante:
  - **Check-in**
- Area di output testuale per la visualizzazione del risultato
- Pulsante di ritorno al menu principale

### Comportamento
- Alla pressione del pulsante **Check-in** viene invocata l’API REST:

``` POST /employees/{employeeId}/check-in ```

- La risposta JSON viene parsata e mostrata in forma leggibile all’utente
- In caso di successo, il messaggio viene evidenziato in verde
- In caso di errore, viene mostrato un messaggio in rosso

### Screenshot
![CheckInFrame](gui/screenshots/check-in.png)

---

## ServeMealFrame

### Scopo
La `ServeMealFrame` consente di eseguire il **servizio di un pasto** associato a un ticket (UC2).

### Componenti principali
- Campo di input:
  - ID Ticket
- Pulsante:
  - **Servi Pasto**
- Area di output testuale per la visualizzazione dei dettagli del pasto servito
- Pulsante di ritorno al menu principale

### Comportamento
- Alla pressione del pulsante **Servi Pasto** viene invocata l’API REST:

``` POST /tickets/{ticketId}/serve ```

- La risposta JSON viene trasformata in una visualizzazione testuale user-friendly
- Vengono mostrati:
  - ID Ticket
  - Nome del pasto
  - Prezzo
  - Data e ora del servizio
  - Feedback visivo differenziato per successo o errore

### Screenshot
![ServeMealFrame](gui/screenshots/serve-meal.png)

---

## Considerazioni di usabilità

Durante la progettazione della GUI sono state adottate le seguenti scelte:
- Interfaccia minimale e focalizzata sul compito
- Feedback immediato all’utente
- Validazione degli input lato client
- Navigazione semplice e lineare
- Coerenza grafica tra le schermate
- Iconografia dedicata per migliorare la riconoscibilità delle azioni

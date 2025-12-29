# SmartCanteen – User Guide

SmartCanteen è un’applicazione desktop che consente di gestire in modo semplice ed efficiente le operazioni principali di una mensa aziendale, interagendo con un backend REST.

Questa guida descrive:

* come avviare l’applicazione;
* come utilizzare le funzionalità disponibili;
* il significato dei messaggi mostrati all’utente.

---

## Requisiti

Per utilizzare correttamente SmartCanteen sono necessari:

* Java JDK 17 o superiore
* Backend SmartCanteen in esecuzione su [http://localhost:8080](http://localhost:8080)
* Sistema operativo compatibile con Java (Windows, macOS, Linux)

---

## Avvio dell’applicazione

1. Avviare il backend SmartCanteen.
2. Avviare l’applicazione tramite il comando “Run” del progetto (ad esempio da IDE).
3. L’interfaccia grafica viene avviata automaticamente senza necessità di eseguire manualmente una classe specifica.

Se il backend è correttamente attivo, nella parte inferiore della finestra principale comparirà il messaggio:

Stato: Backend attivo su [http://localhost:8080](http://localhost:8080)

---

## Nota tecnica

L’applicazione utilizza una classe principale configurata come entry point del progetto.

L’utente finale non deve conoscere né eseguire manualmente classi specifiche come MainWindow.

---

## Finestra principale (Main Window)

La finestra principale consente di accedere alle funzionalità del sistema tramite due pulsanti:

* Check-in Dipendente
* Servizio Pasto

Entrambi i pulsanti sono:

* centrati verticalmente;
* dotati di icone esplicative;
* progettati per un utilizzo immediato e intuitivo.

---

## Check-in Dipendente

### Descrizione

Questa funzionalità consente di registrare il check-in di un dipendente all’ingresso della mensa.

### Procedura

1. Dalla finestra principale, cliccare su “Check-in Dipendente”.
2. Inserire l’ID del dipendente (es. E1) nel campo di testo.
3. Premere il pulsante “Check-in”.

### Risultato

In caso di successo, verrà visualizzato un messaggio contenente:

* ID del dipendente
* data e ora del check-in

Il messaggio è mostrato in verde per indicare un’operazione riuscita.

### Errori

In caso di errore (ad esempio ID non valido), il sistema mostra:

* un messaggio descrittivo;
* testo in rosso per segnalare il problema.

---

## Servizio Pasto

### Descrizione

Questa funzionalità consente di servire un pasto associato a un ticket.

### Procedura

1. Dalla finestra principale, cliccare su “Servizio Pasto”.
2. Inserire l’ID del ticket (es. T1) nel campo di testo.
3. Premere il pulsante “Servi Pasto”.

### Risultato

In caso di successo, verranno mostrati:

* ID del ticket
* nome del pasto
* prezzo
* data e ora del servizio

Anche in questo caso, il testo è mostrato in verde.

### Errori

Eventuali errori (ticket non valido, pasto già servito, ecc.) vengono visualizzati:

* con un messaggio esplicativo;
* in colore rosso.

---

## Navigazione

Ogni finestra secondaria (Check-in e Servizio Pasto) dispone del pulsante “Torna al menu”, che consente di ritornare alla finestra principale in modo semplice e immediato.

---

## Note sull’usabilità

L’interfaccia è stata progettata per:

* ridurre al minimo le operazioni richieste all’utente;
* fornire feedback immediato;
* mantenere coerenza grafica tra le schermate;
* garantire chiarezza nella visualizzazione dei dati.

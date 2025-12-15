# Glossario – SmartCanteen

Questo glossario definisce i principali termini utilizzati nel progetto **SmartCanteen**.  
Lo scopo è fornire un vocabolario condiviso e non ambiguo, valido per tutti i documenti di progetto, i diagrammi UML e le iterazioni successive di sviluppo.

Le definizioni qui riportate sono da considerarsi **vincolanti** per l’interpretazione dei requisiti.

---

## Attori e ruoli

**Employee**  
Dipendente dell’azienda che usufruisce del servizio mensa. È identificato tramite badge aziendale e ha diritto a un pasto per ciascun turno assegnato.

**Staff Mensa**  
Operatore della mensa incaricato di registrare i piatti serviti ai dipendenti tramite il terminale di servizio.

**Chef**  
Responsabile della cucina. Gestisce ricette, ingredienti, scorte e supervisiona la produzione dei piatti.

**Manager**  
Figura responsabile del controllo dei costi e dell’analisi delle performance del servizio mensa tramite report e KPI.

**Admin**  
Utente con privilegi amministrativi per la configurazione del sistema e la gestione degli utenti.

---

## Concetti di dominio

**Mensa**  
Struttura fisica dell’azienda in cui viene erogato il servizio di ristorazione ai dipendenti.

**Turno**  
Fascia oraria predefinita durante la quale specifici reparti o gruppi di dipendenti possono accedere alla mensa.

**Badge**  
Dispositivo di identificazione aziendale utilizzato dal dipendente per effettuare il check-in alla mensa.

**Ticket**  
Entità logica creata al momento del check-in del dipendente. Rappresenta il diritto a consumare un pasto in un determinato turno.  
Può assumere stati come OPEN, SERVED, EXPIRED o NO_SHOW.

**Pasto**  
Insieme dei piatti serviti a un dipendente in un singolo accesso alla mensa.

**Piatto**  
Singola portata disponibile nel menu (primo, secondo o contorno). Può essere “del giorno” o sempre disponibile.

**Menu Giornaliero**  
Insieme dei piatti disponibili in una mensa in una specifica data.

---

## Produzione e inventario

**Ricetta**  
Definizione strutturata che associa un piatto agli ingredienti necessari e alle relative quantità.

**Ingrediente**  
Materia prima utilizzata nella preparazione dei piatti, caratterizzata da unità di misura, costo unitario e quantità disponibile in magazzino.

**Inventario (Stock)**  
Quantità corrente degli ingredienti disponibili in magazzino.

**Decremento Stock**  
Riduzione automatica delle quantità di ingredienti in inventario a seguito del servizio di un pasto.

**Production Plan**  
Suggerimento o pianificazione delle quantità di piatti da preparare per un determinato turno, basato su dati storici e previsioni.

---

## Contabilità e reporting

**Served**  
Record che rappresenta un pasto effettivamente erogato, associato a un ticket, ai piatti serviti e ai relativi costi.

**Food Cost**  
Costo complessivo degli ingredienti utilizzati per preparare un pasto o un piatto.

**Finance Entry**  
Voce contabile generata per ogni pasto servito, utilizzata per l’attribuzione dei costi al centro di costo aziendale.

**Centro di Costo**  
Unità organizzativa dell’azienda a cui viene attribuito il costo del pasto consumato dal dipendente.

**NO_SHOW**  
Stato di un ticket che indica che il dipendente ha effettuato il check-in ma non ha consumato il pasto entro il tempo previsto.

**Spreco**  
Differenza tra produzione pianificata e consumo effettivo, utilizzata per analisi e ottimizzazione del servizio.

---

## Sistema e architettura

**Terminale Mensa**  
Postazione locale utilizzata dallo staff per il check-in dei dipendenti e la registrazione dei piatti serviti.

**Server Centrale**  
Componente centrale del sistema SmartCanteen che gestisce la logica applicativa, i dati e le API.

**API REST**  
Interfacce di comunicazione esposte dal sistema per l’interazione tra terminali, servizi e componenti software.

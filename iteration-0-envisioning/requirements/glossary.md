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

**Piatto (Dish)**  
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

**Production Plan (Piano di Produzione)**  
Suggerimento o pianificazione delle quantità di piatti da preparare per un determinato turno, basato su dati storici e previsioni.

---

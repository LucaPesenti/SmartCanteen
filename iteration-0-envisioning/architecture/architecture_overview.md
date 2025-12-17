# Architettura del sistema – Iterazione 0

Questo documento descrive l’architettura iniziale del sistema SmartCanteen, definita durante l’Iterazione 0 (Envisioning) del processo AMDD.

L’architettura presentata ha lo scopo di fornire una visione ad alto livello del sistema, identificando i principali componenti e le loro interazioni, senza entrare in dettagli implementativi.

---

## Stile architetturale

Il sistema SmartCanteen adotta un’architettura **client–server a servizi**, basata su comunicazioni **REST**.

Un backend centrale fornisce i servizi applicativi e gestisce la logica di business, mentre diversi client accedono a tali servizi in base al ruolo dell’utente.

---

## Componenti principali

### Client

- **Terminale Mensa**
  Utilizzato dallo Staff Mensa per il servizio del pasto e la registrazione dei piatti.

- **Client di Gestione**
  Utilizzato da Chef, Manager e Admin per la gestione del menu, delle ricette, della pianificazione e del reporting.

### Backend SmartCanteen

Il backend rappresenta il cuore del sistema e fornisce:
- servizi di gestione dei ticket;
- servizi di gestione dei pasti;
- servizi di inventario;
- servizi di contabilizzazione;
- servizi di reporting.

Il backend espone API REST utilizzate dai client.

### Database

Un database centrale memorizza:
- dati degli utenti e dei ruoli;
- ticket e pasti serviti;
- ricette e ingredienti;
- inventario;
- dati contabili e storici.

### Sistemi esterni

- **Sistema di contabilità aziendale**  
  Può essere integrato per l’esportazione o la sincronizzazione dei dati economici.

---

## Interazioni principali

- I client comunicano con il backend tramite API REST.
- Il backend gestisce la logica applicativa e accede al database.
- Le integrazioni con sistemi esterni avvengono tramite interfacce dedicate.

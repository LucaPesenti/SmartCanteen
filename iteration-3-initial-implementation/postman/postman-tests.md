# Postman Tests – Validazione API REST

L’obiettivo dei test Postman è verificare il corretto funzionamento delle API REST implementate dal sistema SmartCanteen, validando:

- la raggiungibilità degli endpoint
- la corretta gestione delle richieste HTTP
- la coerenza delle risposte rispetto ai casi d’uso modellati
- l’integrazione tra livello API e logica applicativa

I test Postman rappresentano una **validazione end-to-end** del sistema, complementare ai test di unità JUnit.

---

## Ambiente di esecuzione

- **Applicazione**: SmartCanteen (esecuzione locale)
- **Server**: `localhost`
- **Porta**: `8080`
- **Formato dati**: JSON
- **Protocollo**: HTTP

È stato utilizzato Postman in modalità desktop per consentire l’invio di richieste verso `localhost`.

---

## Struttura della collection Postman

La collection `smartcanteen.postman_collection.json` è organizzata per casi d’uso principali:

- **UC1 – Check-in del dipendente**
- **UC2 – Servizio del pasto**

Per ciascun caso d’uso sono state definite **due richieste POST**, al fine di validare scenari distinti (es. richieste ripetute, variazione dei parametri).

---

## Casi di test eseguiti

### UC1 – Check-in del dipendente

#### Endpoint

POST /api/employees/check-in

#### Scenari testati
- Check-in valido di un dipendente registrato
- Secondo check-in consecutivo dello stesso dipendente

#### Risultati
- L’endpoint risponde correttamente alle richieste valide
- Il sistema gestisce in modo coerente lo stato del dipendente
- La risposta HTTP restituisce un payload JSON conforme alle specifiche API

---

### UC2 – Servizio del pasto

#### Endpoint

POST /api/meals/serve

#### Scenari testati
- Erogazione di un pasto a un dipendente con check-in valido
- Seconda richiesta di servizio pasto (scenario ripetuto)

#### Risultati
- Il servizio del pasto viene correttamente registrato
- La logica applicativa viene eseguita come previsto
- Le risposte REST confermano l’avvenuta elaborazione della richiesta

---

## Test automatici Postman

I test Postman associati alle richieste verificano:

- codice di stato HTTP (`200 OK` in caso di successo)
- presenza di una risposta JSON
- corretto parsing del payload di risposta

Esempio di asserzioni utilizzate:
- verifica dello status code
- verifica dell’esistenza del body di risposta

---

## Analisi dei risultati

Tutte le richieste POST definite nella collection sono state:

- **eseguite con successo**
- **ricevute correttamente dal server**
- **elaborate dalla logica applicativa**

Le risposte ottenute confermano la corretta implementazione dei casi d’uso UC1 e UC2 a livello API.

Le eventuali risposte di errore ottenute in fasi preliminari (es. `404` o `INTERNAL_ERROR`) sono state ricondotte a problemi di configurazione dell’ambiente di test e non a difetti dell’implementazione applicativa.

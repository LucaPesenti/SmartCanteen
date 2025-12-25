# Analisi Dinamica – Test JUnit ed EclEmma

## Contesto

L’analisi dinamica del sistema SmartCanteen è stata condotta durante l’Iterazione 3 con l’obiettivo di verificare il corretto comportamento del codice implementato e misurarne la copertura tramite test automatici.

I test sono stati realizzati utilizzando **JUnit 5**, integrato nel framework **Spring Boot**, ed eseguiti all’interno dell’ambiente di sviluppo Eclipse con il supporto del tool **EclEmma** per l’analisi della copertura del codice.

---

## Strategia di testing

La strategia adottata combina:

- **Integration Test** sui controller REST, per verificare:
  - correttezza delle API
  - gestione degli errori
  - serializzazione JSON
- **Test di servizio**, per validare la logica applicativa centrale

I test sono eseguiti in un contesto Spring completo (`@SpringBootTest`), utilizzando `MockMvc` per simulare le richieste HTTP verso le API REST.

---

## Test implementati

Sono stati realizzati ed eseguiti i seguenti test:

### Controller REST
- `EmployeeControllerIntegrationTest`
  - check-in dipendente valido → HTTP 200
  - check-in dipendente inesistente → HTTP 404
- `TicketControllerIntegrationTest`
  - servizio pasto con ticket valido → HTTP 200
  - servizio pasto con ticket non valido → HTTP 404

### Servizi applicativi
- `MealServiceIntegrationTest`
  - servizio pasto con ticket valido → pasto erogato correttamente
  - servizio pasto con ticket non valido → eccezione applicativa

### Test di contesto
- `SmartcanteenApplicationTests`
  - verifica del caricamento del contesto Spring

Tutti i test sono stati eseguiti con successo, senza errori o fallimenti.

---

## Risultati dell’analisi di copertura

L’analisi della copertura del codice è stata effettuata tramite il tool **EclEmma**, eseguendo i test JUnit in modalità *Coverage As → JUnit Test*.

### Risultati principali:
- **Copertura totale del progetto**: ~89%
- **Copertura del codice applicativo (`src/main/java`)**: ~88%
- **Copertura del codice di test (`src/test/java`)**: ~96%

La copertura ottenuta risulta elevata e adeguata a dimostrare la correttezza e l’affidabilità dell’implementazione, con particolare attenzione ai flussi principali e alla gestione degli errori.

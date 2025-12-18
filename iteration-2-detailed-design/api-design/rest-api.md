# SmartCanteen REST API

## Overview

Questo documento descrive le API REST del sistema SmartCanteen.
Le API sono progettate secondo principi RESTful e riflettono le risorse principali del dominio applicativo.

Formato dati: JSON  
Protocollo: HTTP  

---

## Tickets API

### UC2 – Servizio del pasto

Eroga un pasto associato a un ticket valido.  
L’operazione verifica la validità del ticket, la disponibilità degli ingredienti,
aggiorna l’inventario e registra l’operazione contabile.

---

#### Endpoint

POST /tickets/{ticketId}/serve

---

#### Path Parameters

| Nome | Tipo | Descrizione |
|----|----|------------|
| ticketId | string | Identificativo univoco del ticket |

---

#### Request Body

Nessun body richiesto:
{}

---

### Success Response

HTTP 200 – OK
```json
{
  "ticketId": "T12345",
  "meal": {
    "mealId": "M01",
    "name": "Pasta al pomodoro",
    "price": 5.50
  },
  "servedAt": "2025-05-18T12:34:56"
}
```
---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
|400 | INVALID_TICKET | Ticket non valido o scaduto |
|404 | TICKET_NOT_FOUND | Ticket inesistente |
|409 | TICKET_ALREADY_SERVED | Ticket già utilizzato |
|409 | INSUFFICIENT_INGREDIENTS | Scorte insufficienti |

---

#### Note

- L’endpoint rappresenta una transizione di stato del ticket.
- L’operazione è atomica: tutte le azioni devono completarsi con successo.

---

### UC1 – Check-in del dipendente

Verifica la validità di un ticket presentato da un dipendente al momento dell’accesso alla mensa.  
L’operazione consente di determinare se il ticket può essere utilizzato per il servizio del pasto.

---

#### Endpoint

POST /tickets/{ticketId}/check-in

---

#### Path Parameters

| Nome | Tipo | Descrizione |
|----|----|------------|
| ticketId | string | Identificativo univoco del ticket |

---

#### Request Body

Nessun body richiesto: {}

---

#### Success Response

HTTP 200 – OK
```json
{
  "ticketId": "T12345",
  "valid": true,
  "message": "Ticket valido"
}
```

---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
|400 | INVALID_TICKET | Ticket non valido o scaduto |
|404 | TICKET_NOT_FOUND | Ticket inesistente |

---

#### Note

- L’operazione non modifica lo stato del ticket.
- Serve esclusivamente come validazione preliminare.

---

## Inventory API

### UC5 – Consultazione stato dell’inventario

Consente di consultare lo stato corrente delle scorte di ingredienti presenti in magazzino.  
L’operazione è utilizzata principalmente dal personale di cucina per verificare la disponibilità degli ingredienti.

---

#### Endpoint

GET /inventory

---

#### Path Parameters

Nessun parametro richiesto.

---

#### Request Body

Nessun body richiesto: {}

---

#### Success Response

HTTP 200 – OK
```json
{
  "ingredients": [
    {
      "ingredientId": "I01",
      "name": "Pasta",
      "quantity": 120,
      "unit": "g"
    },
    {
      "ingredientId": "I02",
      "name": "Pomodoro",
      "quantity": 80,
      "unit": "g"
    }
  ]
}
```

---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
| 500 | INVENTORY_UNAVAILABLE | Inventario temporaneamente non disponibile |

---

#### Note

- L’operazione è di sola lettura.
- Non modifica lo stato dell’inventario.
- Pensata per supportare decisioni operative della cucina.

---

### UC4 – Gestione di ricette e ingredienti

Consente al personale autorizzato di creare e aggiornare ricette, specificando gli ingredienti necessari e le relative quantità.
Le ricette sono utilizzate durante il servizio del pasto per verificare la disponibilità degli ingredienti.

---

#### Endpoint – Creazione ricetta

POST /recipes

---

#### Request Body

```json
{
  "name": "Pasta al pomodoro",
  "ingredients": [
    {
      "ingredientId": "I01",
      "quantity": 100
    },
    {
      "ingredientId": "I02",
      "quantity": 50
    }
  ]
}
```

---

#### Success Response

HTTP 201 – Created

```json
{
  "recipeId": "R01",
  "name": "Pasta al pomodoro"
}
```

---

#### Endpoint – Aggiornamento ricetta

PUT /recipes/{recipeId}

---

#### Path Parameters

| Nome | Tipo | Descrizione |
|----|----|------------|
| recipeId | string | Identificativo univoco della ricetta|

---

#### Request Body

```json
{
  "ingredients": [
    {
      "ingredientId": "I01",
      "quantity": 120
    }
  ]
}
```

---

#### Success Response

HTTP 200 – OK
```json
{
  "recipeId": "R01",
  "message": "Recipe updated successfully"
}
```
---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
|400 | INVALID_RECIPE_DATA | Dati della ricetta non validi |
|404 | RECIPE_NOT_FOUND | Ricetta inesistente |

---

#### Note

- Le operazioni sono riservate a utenti autorizzati.
- La modifica delle ricette non aggiorna automaticamente l’inventario.

---

## Accounting API

### UC7 – Consultazione report dei pasti erogati

Consente di consultare i report relativi ai pasti erogati in un determinato periodo di tempo.  
L’operazione è destinata al personale amministrativo e supporta attività di monitoraggio e analisi.

---

#### Endpoint

GET /accounting-entries

---

#### Query Parameters

| Nome | Tipo | Descrizione |
|----|----|------------|
| from | string (ISO date) | Data di inizio del periodo di riferimento | 
| to | string (ISO date) | Data di fine del periodo di riferimento | 

---

#### Success Response

HTTP 200 – OK
```json
{
  "entries": [
    {
      "entryId": "A001",
      "ticketId": "T12345",
      "mealName": "Pasta al pomodoro",
      "price": 5.50,
      "servedAt": "2025-05-18T12:34:56"
    },
    {
      "entryId": "A002",
      "ticketId": "T12346",
      "mealName": "Insalata",
      "price": 4.00,
      "servedAt": "2025-05-18T13:10:12"
    }
  ]
}
```

---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
|400 | INVALID_DATE_RANGE | Intervallo di date non valido |
|500 | ACCOUNTING_DATA_UNAVAILABLE | Dati contabili temporaneamente non disponibili |

---

#### Note

- L’operazione è di sola lettura.
- I risultati possono essere filtrati per intervallo temporale.
- I dati restituiti derivano dalle registrazioni effettuate durante UC2.

---

### UC8 – Consultazione stato operativo della mensa

Consente di consultare informazioni aggregate sullo stato operativo corrente della mensa, inclusi il numero di pasti erogati e l’incasso totale nella giornata in corso.

---

#### Endpoint

GET /accounting-entries/summary

---

#### Query Parameters

| Nome | Tipo | Descrizione |
|----|----|------------|
| date | string (ISO date) | Data di riferimento per il riepilogo | 

---

#### Success Response

```json
HTTP 200 – OK

{
  "date": "2025-05-18",
  "mealsServed": 245,
  "totalRevenue": 1280.50
}
```

---

#### Error Responses

| HTTP | errorCode | Descrizione |
|------|-----------|------------|
| 400 | INVALID_DATE | Data non valida |
| 500 | ACCOUNTING_DATA_UNAVAILABLE | Dati contabili temporaneamente non disponibili |

---

#### Note

- L’operazione restituisce dati aggregati.
- È pensata per il monitoraggio operativo in tempo quasi reale.
- I dati derivano dalle registrazioni effettuate durante il servizio dei pasti.

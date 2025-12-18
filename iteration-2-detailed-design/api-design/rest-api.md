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

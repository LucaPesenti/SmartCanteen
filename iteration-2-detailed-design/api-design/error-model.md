# Error Model

Questo documento definisce il modello standard di errore utilizzato
da tutte le API REST del sistema SmartCanteen.

---

## Error Response Format

Tutte le risposte di errore seguono il formato JSON seguente:

```json
{
  "errorCode": "STRING",
  "message": "Human readable description"
}
```

---

## Error Codes

### Ticket Errors

- INVALID_TICKET
- TICKET_NOT_FOUND
- TICKET_ALREADY_SERVED

### Inventory Errors

- INSUFFICIENT_INGREDIENTS

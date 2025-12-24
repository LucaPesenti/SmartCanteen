# Diagramma delle Classi – Iterazione 2

## Contesto Architetturale

Il diagramma delle classi dell’Iterazione 2 rappresenta la **struttura statica dettagliata** del sistema SmartCanteen, mettendo in evidenza:

- le principali entità di dominio,
- i servizi applicativi che implementano la logica di business,
- i repository responsabili della persistenza,
- e le relazioni tra i diversi elementi del sistema.

Il modello segue un’architettura **a strati**, coerente con i principi di separazione delle responsabilità adottati nel progetto.

---

## Classi di dominio

### Employee
Rappresenta un dipendente del campus che utilizza il servizio mensa.

**Attributi principali**
- `employeeId`: identificativo univoco del dipendente
- `name`: nome del dipendente
- `department`: reparto di appartenenza

**Responsabilità**
- verificare lo stato di attivazione del dipendente tramite il metodo `isActive()`
- essere associato ai ticket posseduti

---

### Ticket
Rappresenta il titolo che consente al dipendente di usufruire del pasto.

**Attributi principali**
- `ticketId`: identificativo del ticket
- `type`: tipologia del ticket
- `status`: stato corrente (es. valido, utilizzato)
- `validityDate`: data di validità

**Responsabilità**
- verificare la validità del ticket (`isValid()`)
- aggiornare lo stato a “servito” (`markAsServed()`)

Ogni ticket è associato a un solo dipendente e genera una voce contabile al momento dell’utilizzo.

---

### Meal
Rappresenta il pasto erogato dalla mensa.

**Attributi principali**
- `mealId`: identificativo del pasto
- `name`: nome del pasto
- `price`: prezzo

Il pasto è definito da una ricetta ed è associato all’utilizzo di un ticket.

---

### Recipe
Descrive la composizione di un pasto in termini di ingredienti.

**Attributi principali**
- `recipeId`: identificativo della ricetta

**Responsabilità**
- utilizzare uno o più ingredienti necessari alla preparazione del pasto

---

### Ingredient
Rappresenta un ingrediente presente in magazzino.

**Attributi principali**
- `ingredientId`: identificativo dell’ingrediente
- `name`: nome
- `quantityAvailable`: quantità disponibile

**Responsabilità**
- decrementare la quantità disponibile (`decreaseQuantity(amount)`)

---

### Inventory
Rappresenta la gestione logica del magazzino ingredienti.

**Responsabilità**
- verificare la disponibilità degli ingredienti per una ricetta (`checkAvailability(recipe)`)
- aggiornare le quantità a seguito del consumo (`updateStock(recipe)`)

---

### AccountingEntry
Rappresenta una voce contabile generata a seguito dell’erogazione di un pasto.

**Attributi principali**
- `entryId`: identificativo della voce
- `amount`: importo
- `date`: data dell’operazione

Ogni voce è generata a partire da un ticket utilizzato.

---

## Servizi applicativi (Service Layer)

### MealService
Servizio applicativo principale che coordina il flusso del caso d’uso **UC2 – Servizio del Pasto**.

**Responsabilità**
- orchestrare la validazione del ticket
- verificare e aggiornare l’inventario
- registrare l’operazione contabile

Dipende da:
- `TicketService`
- `InventoryService`
- `AccountingService`

---

### TicketService
Gestisce la logica di validazione e aggiornamento dei ticket.

**Responsabilità**
- validare un ticket (`validateTicket(ticketId)`)
- aggiornare lo stato del ticket (`updateTicketStatus(ticketId, status)`)

---

### InventoryService
Gestisce la disponibilità degli ingredienti necessari alla preparazione dei pasti.

**Responsabilità**
- verificare la disponibilità degli ingredienti (`checkIngredients(recipe)`)
- consumare gli ingredienti (`consumeIngredients(recipe)`)

---

### AccountingService
Gestisce la registrazione delle operazioni economiche.

**Responsabilità**
- registrare una transazione contabile (`registerMeal(ticket, meal)`)

---

## Repository (Persistence Layer)

### TicketRepository
Responsabile dell’accesso ai dati relativi ai ticket.

**Operazioni**
- `findById(ticketId)`
- `save(ticket)`

---

### InventoryRepository
Responsabile della persistenza degli ingredienti.

**Operazioni**
- `findIngredientById(id)`
- `save(ingredient)`

---

### AccountingRepository
Responsabile della persistenza delle voci contabili.

**Operazioni**
- `save(entry)`

---

## Relazioni principali

- Un `Employee` possiede uno o più `Ticket`
- Un `Ticket` è utilizzato per servire un `Meal`
- Un `Meal` è definito da una `Recipe`
- Una `Recipe` utilizza uno o più `Ingredient`
- Il `MealService` coordina l’interazione tra i servizi applicativi
- I servizi accedono ai dati tramite i rispettivi repository

---

## Considerazioni progettuali

Il diagramma riflette una progettazione orientata ai servizi, in cui:
- la logica di business è incapsulata nel service layer,
- le entità di dominio rimangono semplici e coerenti,
- la persistenza è completamente disaccoppiata dalla logica applicativa.

Questa struttura garantisce manutenibilità, testabilità e facilità di estensione del sistema SmartCanteen.


# Modello di Dominio – Iterazione 1

Questo documento descrive il modello di dominio realizzato durante l’Iterazione 1 del progetto SmartCanteen.  
Il modello di dominio fornisce una rappresentazione concettuale delle entità principali del sistema e delle relazioni che intercorrono tra di esse, con riferimento ai casi d’uso core identificati in Iterazione 0.

---

## Entità del dominio

### Employee
Rappresenta il dipendente dell’azienda che usufruisce del servizio mensa.

Attributi principali:
- `employeeId`: identificativo del dipendente;
- `name`: nome del dipendente;
- `department`: reparto di appartenenza.

---

### Ticket
Rappresenta il titolo che abilita il dipendente alla fruizione del pasto.

Attributi principali:
- `ticketId`: identificativo del ticket;
- `type`: tipologia di ticket;
- `status`: stato del ticket (es. valido, servito);
- `validityDate`: data di validità.

---

### Meal
Rappresenta il pasto erogato dal sistema.

Attributi principali:
- `mealId`: identificativo del pasto;
- `name`: nome del pasto;
- `price`: prezzo del pasto.

---

### Recipe
Descrive la composizione di un pasto in termini di ingredienti utilizzati.

Attributi principali:
- `recipeId`: identificativo della ricetta.

---

### Ingredient
Rappresenta un ingrediente utilizzato nella preparazione dei pasti e gestito a livello di inventario.

Attributi principali:
- `ingredientId`: identificativo dell’ingrediente;
- `name`: nome dell’ingrediente;
- `quantityAvailable`: quantità disponibile in magazzino.

---

### Inventory
Rappresenta l’insieme delle scorte di ingredienti gestite dal sistema.

In questa iterazione l’entità Inventory non presenta attributi specifici ed è utilizzata per modellare la gestione concettuale degli ingredienti.

---

### AccountingEntry
Rappresenta una registrazione contabile associata all’erogazione di un pasto.

Attributi principali:
- `entryId`: identificativo della registrazione;
- `amount`: importo contabilizzato;
- `date`: data della registrazione.

---

## Relazioni tra le entità

Il modello di dominio include le seguenti relazioni principali:

- **Employee – Ticket**  
  Un dipendente può possedere più ticket, mentre ogni ticket è associato a un solo dipendente.

- **Ticket – Meal**  
  Ogni ticket fa riferimento a un singolo pasto erogato.

- **Meal – Recipe**  
  Ogni pasto è definito da una ricetta.

- **Recipe – Ingredient**  
  Una ricetta utilizza uno o più ingredienti.

- **Inventory – Ingredient**  
  L’inventario contiene e gestisce più ingredienti.

- **Ticket – AccountingEntry**  
  Ogni ticket genera una singola registrazione contabile.

Le relazioni sono state modellate per riflettere fedelmente le esigenze funzionali espresse dai casi d’uso core.

---

## Scelte di modellazione e limitazioni

Alcuni aspetti sono stati volutamente esclusi dal modello di dominio in questa iterazione, tra cui:
- servizi applicativi e componenti architetturali;
- dettagli relativi alla persistenza dei dati;
- quantità di ingredienti specifiche per ricetta;
- aspetti tecnologici o implementativi.

Tali elementi potranno essere introdotti e dettagliati nelle iterazioni successive, in conformità con il processo AMDD.

# Design in piccolo - Iteration 2

Questo documento descrive il **design algoritmico** dei principali casi d’uso del sistema *SmartCanteen*, con l’obiettivo di chiarire la logica di business interna indipendentemente dall’implementazione concreta.

Gli algoritmi qui descritti rappresentano il **“design in piccolo”** e costituiscono un ponte tra:
- la progettazione architetturale (class diagram, component diagram),
- e l’implementazione e il testing delle iterazioni successive.

---

## Criteri di selezione degli algoritmi

Sono stati documentati esclusivamente gli algoritmi che:
- implementano logica di business non banale,
- coinvolgono più componenti applicativi,
- hanno un impatto diretto sulla consistenza dei dati.

Gli algoritmi selezionati corrispondono ai seguenti casi d’uso:
- UC1 – Check-in del dipendente
- UC2 – Servizio del pasto
- UC5 – Consultazione dello stato dell’inventario
- UC7 – Generazione report dei pasti
- UC9 – Esportazione dei dati amministrativi

---

## Struttura degli algoritmi

Ogni algoritmo è descritto secondo la seguente struttura standard:
- Descrizione
- Input
- Output
- Pseudocodice
- Complessità temporale

---

## Algoritmi di business

### Servizio del Pasto (UC2)

#### Descrizione

Questo algoritmo gestisce l’erogazione di un pasto a un dipendente.  
Rappresenta il **processo centrale del sistema SmartCanteen**, in quanto coordina la validazione del ticket, la verifica della disponibilità degli ingredienti, l’aggiornamento dell’inventario e la registrazione contabile dell’operazione.

L’algoritmo garantisce che il servizio del pasto avvenga solo se tutte le condizioni di validità sono soddisfatte.

---

#### Input

- `ticketId`: identificativo del ticket presentato dal dipendente
- `mealId`: identificativo del pasto richiesto

---

#### Output

- Conferma del servizio del pasto con i dettagli dell’operazione  
- Eccezioni logiche nei seguenti casi:
  - ticket non valido o inesistente
  - pasto inesistente
  - ingredienti insufficienti

---

#### Pseudocodice

1. Recuperare il ticket associato a `ticketId`
2. Se il ticket non esiste o risulta già utilizzato  
   → sollevare eccezione `InvalidTicketException`
3. Recuperare il pasto associato a `mealId`
4. Per ogni ingrediente richiesto dal pasto:
   - verificare la quantità disponibile in inventario
   - se la quantità non è sufficiente  
     → sollevare eccezione `InsufficientIngredientsException`
5. Per ogni ingrediente richiesto:
   - decrementare la quantità disponibile in inventario
6. Marcare il ticket come utilizzato
7. Creare una nuova voce di accounting relativa al pasto erogato
8. Salvare le modifiche su ticket, inventario e accounting
9. Restituire conferma del servizio del pasto

---

#### Complessità temporale

Sia *n* il numero di ingredienti associati al pasto.

- Verifica disponibilità ingredienti: O(n)
- Aggiornamento inventario: O(n)

**Complessità totale:** O(n)

---

### Check-in Dipendente (UC1)

#### Descrizione

Questo algoritmo gestisce l’accesso di un dipendente al sistema mensa, verificando la sua esistenza e registrando l’operazione di check-in.

---

#### Input

- `employeeId`: identificativo del dipendente

---

#### Output

- Conferma del check-in
- Eccezione `EmployeeNotFoundException` se il dipendente non esiste

---

#### Pseudocodice

1. Recuperare il dipendente associato a `employeeId`
2. Se il dipendente non esiste  
   → sollevare eccezione `EmployeeNotFoundException`
3. Registrare il check-in del dipendente
4. Restituire conferma dell’operazione

---

#### Complessità temporale

- Accesso al repository: O(1)

**Complessità totale:** O(1)

---

### Consultazione Stato Inventario (UC5)

#### Descrizione

Questo algoritmo fornisce una vista consistente dello stato corrente dell’inventario, restituendo la lista degli ingredienti e le rispettive quantità disponibili.

---

#### Input

- Nessuno

---

#### Output

- Lista degli ingredienti con quantità disponibili

---

#### Pseudocodice

1. Recuperare tutti gli ingredienti dal repository
2. Restituire la lista completa

---

#### Complessità temporale

Sia *n* il numero totale di ingredienti.

**Complessità totale:** O(n)

---

### Generazione Report dei Pasti (UC7)

#### Descrizione

Questo algoritmo aggrega i dati storici relativi ai pasti erogati per generare report informativi destinati alla consultazione amministrativa.

---

#### Input

- Parametri di filtro temporale (opzionali)

---

#### Output

- Report aggregato dei pasti erogati

---

#### Pseudocodice

1. Recuperare le voci di accounting nel periodo richiesto
2. Aggregare i dati per tipo di pasto e quantità
3. Restituire il report risultante

---

#### Complessità temporale

Sia *n* il numero di voci di accounting.

**Complessità totale:** O(n)

---

### Esportazione Dati Amministrativi (UC9)

#### Descrizione

Questo algoritmo consente l’esportazione strutturata dei dati amministrativi del sistema, garantendo coerenza e completezza delle informazioni.

---

#### Input

- Parametri di selezione dei dati (opzionali)

---

#### Output

- Dataset amministrativo esportato

---

#### Pseudocodice

1. Recuperare i dati amministrativi richiesti
2. Serializzare i dati in formato strutturato
3. Restituire il dataset esportato

---

#### Complessità temporale

Sia *n* il numero di record esportati.

**Complessità totale:** O(n)

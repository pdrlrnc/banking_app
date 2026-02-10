# CGD Banking App

Small banking exercise: create accounts, transfer money between accounts, and list transactions.

## What it does
- **Accounts**: store an `id` and a `balance` and other information about the acccount.
- **Transfers**: move money from one account to another
- **Transactions**: every transfer creates a transaction record (history)
- **Card**: a representation of a bank card

## Rules (must always be true)
- `amount > 0`
- both accounts must exist
- `fromAccountId != toAccountId`
- sender must have enough balance
- transfer is **atomic** (either everything happens or nothing happens)

## Backend flow
Controller → Service → Repository → Database

Transfer logic happens in the **service** and should run inside **one DB transaction** (`@Transactional`):
1. load accounts
2. validate rules
3. update balances (minus / plus)
4. save transaction
5. return a DTO

## Key endpoint behavior
### Transactions by account
When you request transactions for an account, you should get:
- outgoing transactions **OR**
- incoming transactions

This means: transactions where `fromAccountId = accountId OR toAccountId = accountId`.

## Run (example)
### Backend
```bash
cd backend
mvn spring-boot:run
```

## Notes
- Use **DTOs** in controllers (don’t expose entities directly).
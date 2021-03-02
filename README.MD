#FabrickProxy
A simple rest proxy for Sella API in Fabrick

This project implements sandbox API:

```
[POST] /api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers
[GET]  /api/gbs/banking/v4.0/accounts/{accountId}/balance
[GET]  /api/gbs/banking/v4.0/accounts/{accountId}/transactions
```
from http://developers.fabrick.com/hc/it and expose it respectively as:
```
[POST] /{accountId}/money-transfer
[GET]  /{accountId}/balance
[GET]  /{accountId}/transactions
```
The body for money-transfer is the same described in https://docs.fabrick.com/platform/apis/gbs-banking-payments-moneyTransfers-v4.0

The project use Gradle, once you run gradle bootRun the api are exposed under localhost:8091

No authentication is needed to execute the API

At the execution of the transaction API the results are saved on H2 Database (https://www.h2database.com/html/main.html)



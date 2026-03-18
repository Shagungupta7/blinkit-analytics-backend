# Blinkit Analytics Dashboard — Backend

## About
A Spring Boot REST API that powers the Blinkit Analytics Dashboard.
It connects to a PostgreSQL database and exposes analytics endpoints
that compute business insights from operational data including orders,
deliveries, riders, and customers.

## Tech Stack
- **Java 21**
- **Spring Boot**
- **PostgreSQL**
- **Hibernate / JPA**
- **Railway** (deployment)

## Architecture
The backend follows standard Spring layered architecture:
Controller → Service → Repository → Database

The repository layer runs native SQL queries using EntityManager
and maps results to response models.

## API Endpoints
| Endpoint | Description |
|----------|-------------|
| `/analytics/total-orders` | Total order count |
| `/analytics/avg-order-value` | Average order value |
| `/analytics/cancellation-rate` | Overall cancellation rate |
| `/analytics/orders-per-city` | Orders grouped by city |
| `/analytics/orders-per-day` | Daily order trend |
| `/analytics/orders-per-hour` | Hourly order distribution |
| `/analytics/revenue-per-city` | Revenue grouped by city |
| `/analytics/avg-time-per-city` | Avg delivery time per city |
| `/analytics/top-5-riders` | Fastest riders by avg delivery time |
| `/analytics/peak-delivery-hours` | Delivery time by hour |
| `/analytics/orders-per-category` | Orders by product category |
| `/analytics/orders-per-payment-method` | Orders by payment method |
| `/analytics/rider-utilization` | Avg deliveries per rider per city |
| `/analytics/zone-wise-distribution` | Orders by zone |
| `/analytics/total-revenue` | Total platform revenue |
| `/analytics/total-riders` | Total rider count |
| `/analytics/avg-delivery-time` | Overall avg delivery time |
| `/analytics/repeat-customers` | Repeat customer count |

## Local Setup
### Prerequisites
- Java 21
- PostgreSQL
- Maven

### Steps
1. Clone the repo
2. Create a PostgreSQL database called `blinkit_analytics`
3. Create `src/main/resources/application-local.properties`:

```
DATABASE_URL=jdbc:postgresql://localhost:5432/blinkit_analytics
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=yourpassword
```
4. Run the application

## Challenges
Deployment to Railway required debugging a JVM timezone mismatch
with the cloud PostgreSQL instance, securing credentials using
Spring profiles, and configuring the Railway build pipeline.
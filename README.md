# Enterprise System Integration 2022

## Environment variables

 - `SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres`
 - `SPRING_DATASOURCE_USER=postgres`
 - `SPRING_DATASOURCE_PASS=postgres`
 - `SECURITY_SECRET_KEY=adilsdeals`

## Run locally

```bash
cp .env.example .env
# replace environment variables
docker-compose -f docker-compose.local.yml up
```

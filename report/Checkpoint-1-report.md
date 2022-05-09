# Checkpoint 1 Report

#### Team L

##### Bill Sendewicz
##### Mir Jalal Hashimli
##### Adil Shirinov
##### Volodymyr Chernetskyi

GitHub repo: https://github.com/Stackeduary/Enterprise-System-Integration-2022

Deployed app: https://api.chernetskyi.com

<br>

## Data Entities

- car
- car owner
- car rent
- employee
- car catalog
- car entry
- car repair
- repair bay

<br>

## REST API

URI | HTTP Verb | Description
---|---|---
 /car/create | POST | add a car
 /car/{carId} | GET | view a car with a specified ID
 /car | GET | view all cars
 /car/{carId} | PUT | edit a specific car's attributes
 /car/{carId} | DELETE | remove a specific car
 /car-owner/create | POST | add a car owner
 /car-owner/{carId} | GET | view a car owner with a specified ID
 /car-owner/ | GET | view all car owners
 /car-owner/{carId} | PUT | edit a specific car owner's attributes
 /car-owner/{carId} | DELETE | remove a specific car owner
 /cars/rent/create | POST | add a rental
 /cars/rent/{id} | GET | view a rental with a specified ID
 /cars/rent | GET | view all rentals
 /cars/rent/{id} | PUT | edit a specific rental's attributes
 /cars/rent/{id} | DELETE | remove a specific rental
 /cars/repair/create | POST | add a repair reservation
 /cars/repair/{id} | GET | view a repair reservation with a specified ID
 /cars/repair | GET | view all repair reservations
 /cars/repair/{id} | PUT | edit a specific repair reservation's attributes
 /cars/repair/{id} | DELETE | remove a specific repair reservation
 
 / |  |  

<br>

## Security Aspects

Role | Description
---|---
 employee | can perform CRUD operations on all cars, car owners, repair reservations and rental reservations

reqs https://courses.cs.ut.ee/MTAT.03.229/2022_spring/uploads/Main/Project_CP_1_2022.pdf (to delete later)
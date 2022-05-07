# Checkpoint 1 Report

#### Team L

##### Bill Sendewicz
##### Mir Jalal Hashimli
##### Adil Shirinov
##### Volodymyr Chernetskyi

GitHub repo: https://github.com/Stackeduary/Enterprise-System-Integration-2022

Deployed app: www.voldylovesaws.ua

<br>

## Data Entities
<hr>

- employee
- car catalog
- car entry
- car
- car rent
- car owner
- car repair
- car repair history
- VGG employee
- repair history
- repair bay

<br>

## REST API
<hr>

URI | HTTP Verb | Description
---|---|---
 /car/create | POST | add a car
 /car/{carId} | GET | view a car with a specified ID
 /car/ | GET | view all cars
 /car/update/{carId} | PUT | edit a specific car's attributes
 /car/delete/{carId} | DELETE | remove a specific car
 /car-owner/create | POST | add a car owner
 /car-owner/{carId} | GET | view a car owner with a specified ID
 /car-owner/ | GET | view all car owners
 /car-owner/update/{carId} | PUT | edit a specific car owner's attributes
 /car-owner/delete/{carId} | DELETE | remove a specific car owner
 
 / |  |  

<br>

## Security Aspects
<hr>
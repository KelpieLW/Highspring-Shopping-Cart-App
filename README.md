# Highspring-Shopping-Cart-App

Spring Boot Backend for Shopping Cart web aplication, calculates purchase quantities, discounts, subtotal and total prices for different products

![Static Badge](https://img.shields.io/badge/Springboot-3.5.7-blue)

## Instructions

### Prerequisites

- Docker installed (https://www.docker.com/get-started)

1. Clone the repository.

```
git clone https://github.com/KelpieLW/Highspring-Shopping-Cart-App
cd Highspring-Shopping-Cart-App
```

2. Build the docker container.

```
docker build -t backend .
```

3. Run the docker container

```
docker run -p 8080:8080 backend
```

> Make sure this container is running before starting the frontend repository.

4. Add some item orders through the API (all items id's begin at 1, there are up to 25 items to chose from). Some examples bellow:

Add one unit of item 9.

```
curl --location 'http://localhost:8080/v1/api/orderItems' \
--header 'Content-Type: application/json' \
--data '{
    "itemId":9,
    "quantity":1
}'
```

Add two units of item 2.

```
curl --location 'http://localhost:8080/v1/api/orderItems' \
--header 'Content-Type: application/json' \
--data '{
    "itemId":2,
    "quantity":2
}'
```

Add one unit of item 24

```
curl --location 'http://localhost:8080/v1/api/orderItems' \
--header 'Content-Type: application/json' \
--data '{
    "itemId":24,
    "quantity":1
}'
```

These item orders will be shown in the web page, it's advice to run this backend repository before the front end repository and add the items to preview them in the website.

User input of orders through UI is currently not implemented, all the available items are preloaded in an H2 database, orders can be placed through public use endpoints, more info about the API in the swagger documentation:

> localhost:8080/swagger-ui/index.html#/

Once the orders are loaded the rest of the app functionalities such as performing an order, checkout and clearing a shopping cart can be done through the UI.

H2 database can be consulted at:

> localhost:8080/h2-console

## Architecture diagrams

### Class Diagram

![Class-diagram](./Design/Class-diagram.png)

### Component Diagram

![Component-diagram](./Design/Component-diagram.png)

### Sequence Diagram

![Sequence-diagram](./Design/Sequence-diagram.png)

## Documentation

All the oficial Javadoc documentation can be found at:
[View Javadoc](https://kelpielw.github.io/Highspring-Shopping-Cart-App/)

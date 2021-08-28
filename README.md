# Munro API

GET API returning CSV parsed Munro data with filtering & sorting functionality

## Getting Started

### Dependencies

* Java 11

### Tech

* Built with Spring boot & Maven wrapper using OpenCSV

### Executing program

* Linux / Mac
```
./mvnw spring-boot:run
```

* Windows
```
mvnw.cmd spring-boot:run
```


## Usage

API can be accessed at
* http://localhost:8080/munro-data

### Filter on...

#### Hill category (defaults to ANY), values: MUN, TOP, ANY
* http://localhost:8080/munro-data?hill=TOP

#### Min and / or Max height
* http://localhost:8080/munro-data?min=925.6
* http://localhost:8080/munro-data?min=925.6&max=1200

#### Results returned
* http://localhost:8080/munro-data?limit=10

### Sort on...

#### Height, values: ASC, DESC
* http://localhost:8080/munro-data?height=ASC

#### Alphabetical order, values: ASC, DESC
* http://localhost:8080/munro-data?alpha=DESC

### Filtering and sorting example combinations

#### Munros between 900m & 1100m sorted alphabetically in ascending order
* http://localhost:8080/munro-data?min=900&max=1100&alpha=ASC

#### First 10 Munro TOP's sorted by height in descending order
* http://localhost:8080/munro-data?hill=TOP&height=DESC&limit=10

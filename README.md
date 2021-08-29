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

### Executing tests

* Linux / Mac
```
./mvnw test
```

* Windows
```
mvnw.cmd test
```


## Usage

API can be accessed at
* http://localhost:8080/munros

### Filter on...

#### Hill category (defaults to ANY), values: MUN, TOP, ANY
* http://localhost:8080/munros?hill=TOP

#### Min and / or Max height
* http://localhost:8080/munros?min=925.6
* http://localhost:8080/munros?min=925.6&max=1200

#### Results returned
* http://localhost:8080/munros?limit=10

### Sort on...

#### Height, values: ASC, DESC
* http://localhost:8080/munros?height=ASC

#### Alphabetical order, values: ASC, DESC
* http://localhost:8080/munros?alpha=DESC

### Filtering and sorting example combinations

#### Munros between 900m & 1100m sorted alphabetically in ascending order
* http://localhost:8080/munros?min=900&max=1100&alpha=ASC

#### First 10 Munro TOP's sorted by height in descending order
* http://localhost:8080/munros?hill=TOP&height=DESC&limit=10

### MVN Wrapper

If there are any issues running maven wrapper the application can be built and run using maven or by importing into an IDE.

Run application
```
mvn clean compile exec:java
```

Run tests

```
mvn test
```


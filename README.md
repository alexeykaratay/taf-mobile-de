# taf-mobile-de
Website https://www.mobile.de/ Testing API 
Checking the get request on the resource home page www.mobile.de. Сhecking post requests using the example of one selected car, as well as checking post requests on the login form page

## Content
- [Technologies](#technologies)
- [Getting started](#getting_started)
- [Testing](#testing)
- [Result](#result)

## Technologies
- [Java](https://www.java.com/)
- [Maven](https://maven.apache.org/)
- [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)

## Getting started
To start testing, you need to install the following dependencies:
```
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.13.0</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.2</version>
    <scope>test</scope>
</dependency>
```

## Testing
1. Status Code = 200
2. Status Code = 201, in body key: "adId" the value equal to the ID of the selected car
3. Status Code = 400, in body equal to "field": "email", "code": "account-exists",  "message": "Diese E-Mail-Adresse ist bereits registriert."
4. Status Code = 400 in body equal to "field": "email", "code": "email-empty", "message": "Bitte geben Sie eine E-Mail-Adresse ein.", "field": "email", "code": "email-invalid", "message": "Die eingegebene E-Mail-Adresse ist ungültig.". 
    

## Result
Our tests are tested for functionality API
   

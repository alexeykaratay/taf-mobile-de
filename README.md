# taf-mobile-de
Website https://www.mobile.de/ Testing API 
1. Send a GET request https://www.mobile.de/ Check the response Status code = 200

2. On the website, select any car manually and send a request
POST https://suchen.mobile.de/fahrzeuge/svc/my/parkings/id_car
Body 
{ 
    "adId": "значение_id_машины", 
    "ref": null, 
    "refId": null 
} 
Checking the answer
Status Code = 201
Check that adId= id_car

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

## Result
Our tests are tested for functionality API
   

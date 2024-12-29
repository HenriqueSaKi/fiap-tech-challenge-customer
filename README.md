# FIAP PosTech - Software Architecture (Post Degree)
## Customer API - A microservice responsible to allow customers to sign in/sign up to the app

## Technologies
For this project we choose to develop using:
- Java 17
- Spring Boot
- PostgreSQL
- SonarCloud.io

## How to execute this application?
1- Clone this project and access the folder
git clone https://github.com/HenriqueSaKi/cart-purchase.git

2- Install dependencies
mvn clean install

3 - Now you can run the application </br>
Once Spring Boot has finished starting up, you can access the Swagger UI documentation by clicking this icon: 
[![](https://img.shields.io/badge/swagger_url-85EA2D?style=flat&logo=swagger&logoColor=black)](http://localhost:8080/api/v1/swagger-ui/index.html) </br>
Ps: You don't need to configure environment variables. If no database data is provided, the service will use H2 instance be default.

### Project Badges
#### SonarQube results
[![](https://img.shields.io/badge/passed-quality_gate?style=flat&logo=sonarqube&logoColor=4E9BCD&label=quality%20gate&color=13C100)](https://sonarcloud.io/summary/new_code?id=HenriqueSaKi_fiap-tech-challenge-customer&branch=master)
![](https://img.shields.io/badge/100.0%25-coverage?style=flat&logo=sonarqube&logoColor=4E9BCD&label=coverage&color=999999)

# 
## Application execution flow:
    - JVM starts -> main() -> SpringApplication.run(...) -> Spring Boot starts -> Creates container -> Creates beans -> Starts embedded Tomcat -> Application ready.
## Annotation @SpringBootApplication:
- @Configuration + @EnableAutoConfiguration + @ComponentScan
- @EnableAutoConfiguration: 
  - Spring checks .xml file and sees `spring-boot-starter-web` and says: "Oh, you want a web application." Then it automatically configures:
  - Tomcat, DispatcherServlet, JSON support, MVC configuration, ...etc. (without ME writing configuration for these manually)
- @ComponentScan: 
  - Spring starts scanning packages & sub-packages.
  - Looking for java annotations like: `@RestController, @Service, @Repository, @Component`
  - When found: Spring creates and manages those objects.
## Dependency Injection (DI)
- Instead of developer creating ServiceClass object, Spring automatically creates when they see: `@Service` annotation.
## RestController flow-control: 
- Client ->  Controller -> Service -> Repository -> Database
- DB -> Repository -> service -> Controller -> Client
- @RestController means:
  - This class contains HTTP endpoints and Spring should expose them as REST APIs.
## RestController method resolution: 
- During scan time(@ComponentScan), Spring creates internal mappings. Like: Map<Route, HandlerMethod> roughly. Ex:
  - GET /players --> PlayerController.players()
  - GET /hello   --> PlayerController.hello()
## java vs browser communication language gap ?
- Spring-Boot converts the java response Object into json form implicitly. Like: 
  - **returned java object --> Jackson --> JSON --> HTTP Response**
## How Spring/Jackson parsing object into json+http takes care of **sensitive fields like password** ?
- By annotating the sensitive field by: @JsonIgnore, Then Jackson skips it.
- But, In real time, developer avoid returning Entity/Domain objects directly. 
- Instead, we create: DTOs (Data Transfer Objects) without sensitive fields. 
- Now, Jackson can parse this DTOs blindly. No need of risky @JsonIgnore annotation.
## REST API Layers: 
- Controller (handles HTTP)
  ↓
  Service (handles business logic)
  ↓
  Repository (handles persistence)
  ↓
  Database
## @Service Annotation 
- It tells Spring: Please create and manage an object of this service-class inside the Spring Container
- Imagine tomorrow:
- PlayerService
  ↓
  PlayerRepository
  ↓
  DatabaseConnection
- With Spring: no need to create object manually, Spring will create, wire and manages.
## IoC (Inversion of Control)
- Control moved from developer to container. for: 
- creating, managing, objects & it's life cycle.
## object creation order in spring: 
- It must be in DAG (Directed Acyclic Graph) fashion. No cycles in object creation. 
- otherwise, circular wait (deadlock situation), Spring-boot will not start itself and throws error (fail-fast).
## Spring startup work-flow:
- Scan packages -> Find annotations -> Build bean definitions -> Build dependency graph -> Validate graph -> Create singleton beans -> Start application
## why explicit 'empty/default/no-arg' constructor is needed ?
- When framework/library (jackson in spring-boot) needs to create object, it can't guess which parameterized constructors to be called, In which order parameter's needs to be passed in constructor. 
- Hence, Better, create an empty object first. 
- Then populate/initialize that object. 
- Which means setter method is also needed along with default constructor. 
## java bean class
- means it contains: No-Arg Constructor + Getters + Setters
## unknown filed sent by browser (http request)
- Either extra unknown fields or spell mismatch field then ? 
- option A: ignore unknow field and serve 200 response with other correct field. Compatibility/Flexibility achieved.
- option B: strictness/fail-fast/Potentially dangerous. hence throw error and highlight the issue.
## how to keep some unusual things happening in production are informed ?
- Like: Unknown JSON fields,  High response times, Database retries, Memory pressure, Cache misses
- Many systems continue working while simultaneously informing operators. Think in that way. 
## Summary: 
- Feature	Problem Being Solved
- @Service	Separation of concerns
- DI	    Object creation & wiring
- @Primary	Multiple implementations
- @Qualifier	Explicit selection
- DTO	    Prevent overexposing entities
- Validation	Protect business rules
- Jackson	Object ↔ JSON conversion
- Fail-fast startup	Catch configuration errors early
## Spring Request-Validation order: 
- Validation checks all validation for better user experience.
- It validates all validation, even if previous ones fails. 
- And returns all the errors, instead of one-by-one. This is a good user experience. 
- So this is no "fail-fast" as this is intended for user experience not application based.
## spring debugging: 
- When something goes wrong, I ask:
- Did JSON parse?
- Did object get created?
- Did validation pass?
- Did controller execute?
- Did service execute?
- Did repository execute?

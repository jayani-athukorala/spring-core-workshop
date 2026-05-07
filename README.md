# 🚚  Workshop : Shipping Cost Calculator

A **Java console application** built using **Spring Core (IoC + DI)** that calculates shipping costs based on destination, speed, and weight using a flexible strategy-based architecture.

---

## 📝 Table of Contents

1. [✨ Features](#-features)
2. [📌 Workshop Document](#-workshop-document)
3. [📂 Folder Structure](#-folder-structure)
4. [🛠 Available Options](#-available-options)
5. [🗃 Data Structure](#-data-structure)
6. [🔧 Spring Concepts Used](#-spring-concepts-used)
7. [🚀 How to Run](#-how-to-run)
8. [⚡ Expected Output :](#-expected-output-)

---

## 📌 Workshop Document

You can find the workshop description here:

[Workshop Document](Spring_Core_Workshop.md)

---
## ✨ Features

- Calculates shipping cost based on:
  - Destination (DOMESTIC / INTERNATIONAL)
  - Shipping Speed (STANDARD / EXPRESS)
  - Package weight (kg)
- Uses Strategy Pattern for pricing rules
- Fully managed by Spring IoC Container
- Supports multiple shipping strategies
- Easily extensible without modifying existing logic
- Clean separation of concerns (Service, Factory, Calculators)

---

## 📂 Folder Structure

```
src
└── main
    ├── java/se/lexicon
    │   ├── calculator
    │   │   ├── StandardDomesticShipping.java
    │   │   ├── ExpressDomesticShipping.java
    │   │   ├── StandardInternationalShipping.java
    │   │   └── ExpressInternationalShipping.java
    │   ├── config
    │   │   └── ShippingCostCalculatorConfig.java
    │   ├── model
    │   │   ├── Destination.java
    │   │   ├── Speed.java
    │   │   └── ShippingRequest.java
    │   ├── service
    │   │   ├── ShippingService.java
    │   │   ├── ShippingCostCalculator.java
    │   │   └── ShippingCalculatorFactory.java
    │   └── Main.java
    └── resources
        ├── application.properties
        ├── application-dev.properties
        └── application-prod.properties
```
---
## 🛠 Available Options

The system supports the following shipping combinations:

- Domestic Standard
- Domestic Express
- International Standard
- International Express

Each option has a different pricing strategy based on base cost and cost per kg.


---
## 🗃 Data Structure

```ShippingRequest``` → Immutable record containing:
- Destination
- Speed
- Weight (kg)

```ShippingCostCalculator``` → Strategy interface 
Multiple implementations:
- StandardDomesticShipping
- ExpressDomesticShipping
- StandardInternationalShipping
- ExpressInternationalShipping

---

## 🔧 Spring Concepts Used

- Spring IoC Container
- Component Scanning (```@Component```)
- Dependency Injection (Constructor Injection)
- Factory Pattern with Spring Beans
- ```@Value``` for externalized configuration
- ```@PostConstruct``` for bean initialization logging

---
## 🚀 How to Run

1. Clone the repository.

```git clone https://github.com/jayani-athukorala/spring-core-workshop.git```

2. Build with Maven:
    ```bash
    mvn clean install
    ```

3. Run the CLI:
   ```bash
    java -cp target/classes se.lexicon.Main
    ```

---

## ⚡ Expected Output :

```
=== Creating Beans ===
✅ DomesticExpressShipping bean created.
✅ ExpressInternationalShipping bean created.
✅ InternationalStandardShipping bean created.
✅ StandardDomesticShipping bean created.

=== Shipping Quote ===
Domestic Standard (10kg)
Estimated Charge: 17.0

International Express (15kg)
Estimated Charge: 92.5

Domestic Standard (5kg)
Estimated Charge: 11.0

International Express (20kg)
Estimated Charge: 115.0

Domestic Express (10kg)
Estimated Charge: 40.0

International Standard (10kg)
Estimated Charge: 42.0

Process finished with exit code 0
```

---

# Hostel Mess Waste Analytics & Prediction Portal
**An Innovative Resource Optimization Prototype for the IIT Madras Summer Fellowship 2026**

## Research Problem Statement
Institutional mess facilities face systemic inefficiencies due to production-consumption asymmetry. This project addresses the lack of actionable data in kitchen management by implementing a predictive framework that converts historical waste logs into quantitative production adjustments.

## Technical Stack
- **Language:** Java 17 (LTS)
- **Framework:** Spring Boot 3.5.10 (Spring Web, Spring Data JPA)
- **Database:** MySQL 8.0 (Relational Storage)
- **Frontend:** HTML5, CSS3, Bootstrap 5, Thymeleaf Template Engine
- **Build Tool:** Maven



## Key Features
- **Predictive Resource Optimization:** A quantitative engine that identifies waste trends and calculates exact kilogram reduction targets for upcoming meal cycles.
- **Dynamic Anomaly Detection:** Real-time flagging of "High Waste" events using a 20% production-to-waste variance threshold.
- **Multi-Meal Intelligence:** Algorithmic scanning of Breakfast, Lunch, Snacks, and Dinner to identify the "Highest Waste Offender" across the current data set.
- **Research-Grade Audit Log:** A robust, persistable data history designed for longitudinal studies on institutional sustainability.

## Implementation & Deployment
1. **Model:** JPA Entities with `@PrePersist` hooks for automated waste calculation.
2. **Repository:** Custom JPQL queries for aggregate data analysis.
3. **Controller:** MVC-compliant REST endpoints for data flow management.
4. **View:** Responsive, IITM-branded dashboard with automated data-binding.

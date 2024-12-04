# Project: Microservices-based Data Synchronization Solution

## Problem
The challenge was to develop a microservices-based solution that synchronizes user and order data across two MongoDB databases in an event-driven system. The system must efficiently handle user account information, order status updates, and ensure data consistency across services.

## Action
- **Microservices Architecture:** Built using **Spring Boot** to create independent microservices for user management and order processing.
- **API Gateway:** Implemented **Spring Cloud Gateway** to route requests to the appropriate microservices.
- **Strangler Pattern:** Introduced two versions of the user microservice (v1 and v2), migrating gradually using the **Strangler Pattern** to minimize disruption.
- **Event-Driven Data Synchronization:** Integrated **Apache Kafka** for asynchronous messaging, ensuring data synchronization between user and order microservices.
- **RESTful APIs:** Exposed REST APIs for creating and updating users and orders, enabling smooth integration and communication between services.

## Result
- **Docker Deployment:** The entire solution was containerized with **Docker**, enabling easy deployment on a cloud-based VM.
- **CI/CD Pipeline:** Integrated **CI/CD pipelines** to automate the deployment process, ensuring efficient and scalable updates to the system.
- **Seamless Integration:** Enabled HTTP endpoints for user and order management, providing reliable and real-time services for clients.

## How to Run the Project

To run the project, execute the following command:

```bash
docker-compose up -d


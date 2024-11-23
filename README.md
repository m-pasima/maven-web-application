# Maven Web Application

This is a sample **Java Maven Web Application** that uses **Spring Boot** to build a simple web-based application. The project demonstrates how to integrate **Spring Boot** with **Maven**, and includes instructions for **Dockerizing** the application, **deploying it on Kubernetes**, and **automating the process with Jenkins**.

## Project Overview

This project provides the following features:
- A **Spring Boot** based web application using the **Spring Web MVC** framework.
- It includes a simple `HelloWorldController` to handle HTTP requests.
- The application is packaged as a **WAR file** and can be deployed on a servlet container such as **Jetty** or **Tomcat**.
- **JUnit** testing is included for integration tests.

### Technologies Used:
- **Spring Boot 2.5.4**
- **Maven** for dependency management and build automation.
- **JUnit 5** for testing.
- **Log4J** for logging.
- **Jetty** for local web server deployment.
- **Docker** for containerizing the application.
- **Kubernetes** for orchestrating the application deployment.
- **Jenkins** for CI/CD pipeline automation.

## Features:
- **Spring Boot Starter Web**: Enables web functionality with RESTful endpoints.
- **JUnit 5**: For running unit and integration tests.
- **Jetty Maven Plugin**: To run the application locally during development.
- **Dockerized Application**: The application is containerized using Docker for consistent deployment environments.
- **Kubernetes Deployment**: The Docker container is deployed on Kubernetes for production-like environments.
- **Jenkins Pipeline**: Automates the CI/CD pipeline for building, testing, and deploying the application.

## Setup and Installation

Follow these steps to set up and run the application:

### Prerequisites:
- **Java 8** or newer.
- **Maven** installed.
- **Docker** and **Kubernetes** configured.
- **Jenkins** setup for automation.

### Steps:
1. Clone the repository:

    ```bash
    git clone https://github.com/m-pasima/maven-web-application.git
    cd maven-web-application
    ```

2. Ensure **Maven**, **Docker**, and **Java** are installed and configured correctly:

    ```bash
    mvn -v
    java -version
    docker -v
    kubectl version --client
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

    This will download dependencies, compile the code, and run tests.

4. **Dockerize the Application**:
   - Build the Docker image:

     ```bash
     docker build -t your-docker-username/maven-web-application:latest .
     ```

   - Run the Docker container locally:

     ```bash
     docker run -p 8080:8080 your-docker-username/maven-web-application:latest
     ```

     The application will be accessible at `http://localhost:8080/maven-web-application`.

5. **Deploy to Kubernetes**:
   - Create the Kubernetes deployment and service:

     ```bash
     kubectl apply -f deployment.yaml
     ```

     This will deploy the application to your Kubernetes cluster.

6. **Run the Jenkins Pipeline**:
   - Set up Jenkins with a **Jenkinsfile** for automation.
   - Configure Docker and Kubernetes credentials in Jenkins.
   - Run the Jenkins pipeline to build the Docker image, push it to a container registry, and deploy it to Kubernetes.

     The Jenkins pipeline includes these steps:
     - Clone the repository.
     - Build the application using Maven.
     - Build the Docker image.
     - Push the image to Docker Hub or another container registry.
     - Deploy the image to a Kubernetes cluster.

## Directory Structure

```
maven-web-application/
│
├── pom.xml               # Maven Project Object Model (POM) configuration file.
├── README.md             # Project documentation.
├── Dockerfile            # Defines how to build the Docker image.
├── Jenkinsfile           # Jenkins pipeline configuration file.
├── deployment.yaml       # Kubernetes deployment and service configuration.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mt/
│   │   │           └── sample/
│   │   │               └── HelloWorldController.java  # Main controller class.
│   │   └── resources/
│   │       └── application.properties  # Spring Boot configuration file.
│   └── test/
│       └── java/
│           └── com/
│               └── mt/
│                   └── sample/
│                       └── test/
│                           └── HelloWorldControllerTest.java  # Unit test for controller.
└── target/               # Generated files after building (e.g., WAR file).
```

## Running in a Container (Tomcat or other servers)

To deploy this application in a servlet container like **Tomcat**, package it as a WAR file:

```bash
mvn clean package
```

This will generate a `maven-web-application-0.0.1-SNAPSHOT.war` file in the `target/` folder. You can deploy this file to your servlet container.

## Running Jenkins Pipeline

1. **Docker Image Build**: The Jenkins pipeline will trigger a Maven build, build the Docker image, push it to the registry, and deploy it to Kubernetes.
2. **Jenkins Setup**:
   - Ensure you have **Docker** and **Kubernetes** installed on the Jenkins agent.
   - Store Docker credentials (`DOCKER_USERNAME`, `DOCKER_PASSWORD`) and Kubernetes configurations securely in Jenkins or any other secrets manager.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to your fork (`git push origin feature-branch`).
5. Open a Pull Request.

## License

This project is open-source and available under the **MIT License**.




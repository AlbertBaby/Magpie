# Web Test Service - README

This module (`web-test-service`) is a part of a hybrid test automation framework designed to perform web application testing using Selenium, Java, Cucumber, and Spring Boot.

## Purpose

The `web-test-service` provides a microservice that executes web application tests. It is designed to be invoked by an orchestration service, enabling cross-service test execution and parallelization.

## Technology Stack

* **Java:** Core programming language.
* **Maven:** Build automation and dependency management.
* **Spring Boot:** Framework for building the microservice.
* **Selenium:** Web browser automation.
* **Cucumber:** Behavior-driven development (BDD).
* **JUnit/TestNG:** Testing frameworks.

## File Structure

Markdown

# Web Test Service - README

This module (`web-test-service`) is a part of a hybrid test automation framework designed to perform web application testing using Selenium, Java, Cucumber, and Spring Boot.

## Purpose

The `web-test-service` provides a microservice that executes web application tests. It is designed to be invoked by an orchestration service, enabling cross-service test execution and parallelization.

## Technology Stack

* **Java:** Core programming language.
* **Maven:** Build automation and dependency management.
* **Spring Boot:** Framework for building the microservice.
* **Selenium:** Web browser automation.
* **Cucumber:** Behavior-driven development (BDD).
* **JUnit/TestNG:** Testing frameworks.

## How to Run Tests

### 1. Direct Execution via Maven

* Navigate to the `web-test-service` directory.
* Run all Cucumber tests:

    ```bash
    mvn test
    ```

* Run tests with specific Cucumber tags:

    ```bash
    mvn test -Dcucumber.filter.tags="@your_tag"
    ```

* Run specific feature files:

    ```bash
    mvn test -Dcucumber.features="classpath:com/web/testservice/features/login.feature"
    ```

### 2. Execution via Orchestration Service (REST API)

* Ensure the `web-test-service` is running (Spring Boot application).
* The orchestration service sends a POST request to `/execute` with a JSON payload in the `TestRequest` format.
* The service executes the specified test and returns a `TestResult`.

## Configuration

### `application.properties` or `application.yml`

* `server.port`: Specifies the port for the web test service (e.g., `8082`).
* Environment-specific configurations (e.g., database URLs, API endpoints).

### `cucumber.properties`

* Cucumber-specific configurations (e.g., plugin settings).

## Testing with Different Configurations

### Environment Variables

* Use environment variables to pass configurations (e.g., `SELENIUM_BROWSER=chrome`).
* Retrieve these variables in your step definitions or configuration classes.

### Maven Profiles

* Define Maven profiles for different environments (dev, staging, production).
* Use profile-specific `application.properties` or `application.yml` files.
* Activate profiles with `-P` flag: `mvn test -Pstaging`.

## Modifying the Architecture

### Adding New Test Scenarios

* Create new `.feature` files in the `src/test/java/com/web/testservice/features/` directory.
* Implement corresponding step definitions in the `src/test/java/com/web/testservice/steps/` directory.
* Use the page object model (`src/test/java/com/web/testservice/pages/`) for better maintainability.

### Changing Selenium Configuration

* Modify the `SeleniumConfig.java` class to customize Selenium WebDriver settings (e.g., browser type, driver location, browser options).
* Add more configurations to `application.properties` or `application.yml` as needed.

### Adding New Dependencies

* Update the `pom.xml` file with the required dependencies.
* Run `mvn clean install` to update the project.

### Adding new rest endpoint.

* Add a new controller to the `src/main/java/com/web/testservice/controllers/` directory.
* Add a new service to the `src/main/java/com/web/testservice/services/` directory.
* Add new models to the `src/main/java/com/web/testservice/models/` directory, if needed.

## Tech and Best Practices

* **Page Object Model (POM):** Use POM to encapsulate UI interactions and improve maintainability.
* **Cucumber BDD:** Write tests in Gherkin syntax for better readability and collaboration.
* **Selenium WebDriver:** Use explicit waits and proper element locators for reliable tests.
* **Spring Boot:** Leverage Spring Boot's features for dependency injection and configuration management.
* **REST API:** Expose test execution as a REST API for integration with the orchestration service.
* **Environment-Specific Configurations:** Use environment variables or Maven profiles for flexible configurations.
* **CI/CD Integration:** Integrate with CI/CD tools (e.g., Jenkins, GitLab CI) for automated test execution.
* **Logging:** Use logging frameworks (e.g., Log4j, SLF4j) for better debugging.
* **Error Handling:** Implement robust error handling in your step definitions and service classes.
* **Dockerization (Optional):** Containerize the service for consistent environments and deployment.

## Contributing

* Follow the project's coding standards.
* Write clear and concise commit messages.
* Create pull requests for code contributions.
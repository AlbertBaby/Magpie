File Structure

We'll use Maven's multi-module project structure to organize the microservices.

hybrid-test-framework/
├── mobile-test-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/mobile/testservice/
│   │   │   │   ├── MobileTestServiceApplication.java (Spring Boot app)
│   │   │   │   ├── controllers/
│   │   │   │   │   └── MobileTestController.java (REST API)
│   │   │   │   ├── services/
│   │   │   │   │   └── MobileTestExecutionService.java
│   │   │   │   ├── config/
│   │   │   │   │   └── AppiumConfig.java
│   │   │   │   ├── models/
│   │   │   │   │   └── TestRequest.java, TestResult.java
│   │   │   ├── resources/
│   │   │   │   └── application.properties/application.yml
│   │   ├── test/
│   │   │   ├── java/com/mobile/testservice/
│   │   │   │   ├── features/
│   │   │   │   │   └── login.feature, checkout.feature
│   │   │   │   ├── steps/
│   │   │   │   │   └── LoginSteps.java, CheckoutSteps.java
│   │   │   │   ├── pages/
│   │   │   │   │   └── LoginPage.java, CheckoutPage.java
│   │   │   │   ├── utils/
│   │   │   │   │   └── AppiumUtils.java, TestData.java
│   │   │   │   ├── MobileTestServiceApplicationTests.java
│   │   │   ├── resources/
│   │   │   │   └── cucumber.properties
│   ├── pom.xml
├── web-test-service/
│   ├── src/
│   │   ├── ... (Similar structure to mobile-test-service, but with Selenium)
│   ├── pom.xml
├── api-test-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/api/testservice/
│   │   │   │   ├── ApiTestServiceApplication.java (Spring Boot app)
│   │   │   │   ├── controllers/
│   │   │   │   │   └── ApiTestController.java (REST API)
│   │   │   │   ├── services/
│   │   │   │   │   └── ApiTestExecutionService.java
│   │   │   │   ├── tests/
│   │   │   │   │   └── UserApiTests.java, ProductApiTests.java
│   │   │   │   ├── models/
│   │   │   │   │   └── TestRequest.java, TestResult.java
│   │   │   ├── resources/
│   │   │   │   └── application.properties/application.yml
│   │   ├── test/
│   │   │   ├── java/com/api/testservice/
│   │   │   │   └── ApiTestServiceApplicationTests.java
│   │   ├── pom.xml
├── test-orchestration-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/orchestrator/testservice/
│   │   │   │   ├── TestOrchestrationServiceApplication.java (Spring Boot app)
│   │   │   │   ├── controllers/
│   │   │   │   │   └── OrchestrationController.java (REST API)
│   │   │   │   ├── services/
│   │   │   │   │   └── OrchestrationService.java
│   │   │   │   ├── models/
│   │   │   │   │   └── TestSuiteRequest.java, TestSuiteResult.java, TestExecutionRequest.java, TestExecutionResult.java
│   │   │   ├── resources/
│   │   │   │   └── application.properties/application.yml
│   │   ├── test/
│   │   │   ├── java/com/orchestrator/testservice/
│   │   │   │   └── TestOrchestrationServiceApplicationTests.java
│   │   ├── pom.xml
├── pom.xml (Parent POM)

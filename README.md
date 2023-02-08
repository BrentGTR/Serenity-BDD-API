
# Serenity-Java-Maven

The purpose of this assessment is to give insight in your technical abilities, development approach and general technical
working habits.


## 🚀 About Me
Hi, I am Brent Singh, as software tester from sunny South Africa. Throughout my 10+ year career I have aimed to used the knowledge and skills gained in order to collaborate and provide an innovative end-to-end testing strategy that utilizes all tools which are currently available, including test automation on all levels of the application framework.

Current project stack: Pytest on AWS for API and integration testing.


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/brent-singh-83221913/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/BrentGTR)


## Optimizations (project refactors)

Refactors are sometimes needed for easily identifying elements in GUI projects. This is the list of the ones done:
 
- Add <env.MAVEN_REPO_URL> https://repo.maven.apache.org/maven2/</env.MAVEN_REPO_URL>
- Remove all instances of Gradle to conform with project requirements
- Change seren-cuke6 dep to seren-cuke dep to resolve dep issues
- Refactored org.codehaus.groovy:3.0.12 to org.apache.groovy:4.0.1 to resolve dependency issues
- Added .gitlab-ci.yml for use in pipeline
- URL for multi-project pipeline setup: https://tinyurl.com/brentsawesomelink


Page object model not used as scope of project is well defined and limited


## Project details

The code is a BDD test using Serenity BDD framework. It tests the functionality of the "Search product" feature in a REST API.

The feature file defines a single scenario that describes the steps to test the search product functionality. The "Background" section specifies that a GET request to the product endpoint should return a 200 status code. The scenario outline specifies that when the "search product endpoint" is called with a product name, it should verify that the product should be present in the search results and the schema of the response should match with the "search_product.json" specification.

The step definitions for the feature file are provided in the "SearchStepDefs" class. It uses the SerenityRest class to make REST API requests and perform assertions. The class has methods for each step defined in the scenario.

- The "iCallTheSearchProductEndpointProduct" method makes a GET request to the "search product endpoint" with the product name as a parameter.
- The "iVerifyProductShouldBeInSearchResults" method performs two assertions to check that the product name is present in the search results.
- The "theSchemaShouldMatchWithTheSpecificationDefinedIn" method verifies that the response's schema matches the "search_product.json" specification.
- The "iVerifyThatANotFoundErrorShouldBeDisplayedInSearchResults" and "iVerifyThatAnUnauthorizedErrorShouldBeDisplayedInSearchResult" methods check for the 404 and 401 status codes respectively and verify the error details in the response body.
- The "iGetAFromTheProductEndpoint" method makes a GET request to the product endpoint and checks for the expected status code.

The "CommonActions" class provides methods for common actions that can be used in multiple scenarios. It has methods to verify the API response status code, verify that the response list is not an empty list, and verify the response schema with a given JSON file.


## Run Locally

Run the Serenity features

```bash
  mvn clean verify
```

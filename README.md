
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

 

## Run Locally

Run the Serenity features

```bash
  mvn clean verify
```

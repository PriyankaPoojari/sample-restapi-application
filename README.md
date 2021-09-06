


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
       </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
This is a simple light-weight Student Info application built using Java language.
All the CRUD operations are supported.


![Student's App Main Screen]<img src="images/StudentsApp.PNG" alt="Logo" width="80" height="80">

![Student's App Search Screen](https://photos.app.goo.gl/2sS9aRghgHFpQsMx6)

### Built With
* [Spring Boot Framework](https://spring.io/projects/spring-framework)
* [Apache h2 database](https://www.h2database.com/)
* [REST API](https://www.mulesoft.com/resources/api)
*  [Cucumber BDD for testing](https://cucumber.io/)

<!-- GETTING STARTED -->
## Getting Started

Download the entire repository and import in Eclipse or Spring tool suite(STS).
When importing the project, select Maven > Maven Existing project option.

### Prerequisites
Following addin must be installed in your Eclipse.
* Maven
* WindowsBuilder (Swing GUI- to view the design) NOT MANDATORY

 Apache Tomcat service running to be stopped. Press Windows+R, type "Services.msc". Stop Apache Tomcat service if is already running. This is because apache h2 console requires service to be started.

## Usage
After importing the project, Run as Spring Boot app and select Application.java as main class.
![run config ](https://photos.app.goo.gl/9M9KgcYeNjFRxA4aA)

Moreover, if importing and running is not possible then Executable-jar is also uploaded to main folder.
Download it and double-click on it. All the api's and the database too will be up and running.
### To access Database
 Open http://localhost:8080/h2-console/login.jsp in browser
 user: sa
 password: password
 JDBC URL: jdbc:h2 <Path to sampledata>
 The path is also updated in the Eclipse console logs.
 
### Postman 
Postman can be used to test the API's manually. 
The workspace is exported and uploaded to base directory of this repository.

  






# Canvas Reply Java Selenium Suite

Automation Testing Using Selenium, BDD and Cucumber

Canvas Reply Java Selenium Suite is a behavior driven development (BDD) approach to write automation test script to test Web.

Getting Started
-------------
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
--------------
Maven  
Git
Java 11

Installing
-------------
Clone the repo to get a working project

Running the tests - from IDE
-------------------
Run [src/test/java/com/selenium/runner/CanvasReplyRunner.java](src/test/java/com/selenium/runner/CanvasReplyRunner.java)  as maven test

Run from feature file from IDE:
Run [src/test/resources/features/CanvasReply.feature] (src/test/resources/features/CanvasReply.feature)

Running all the tests - from cmd line - needs the right mvn configuration
-------------------
mvn clean test

Built With
-------------
* [Selenium](http://www.seleniumhq.org/) - The web framework to automate browsers
* [Maven](https://maven.apache.org/) - Dependency Management
* [Cucumber](https://cucumber.io/) - Behavior Driven Development (BDD) library

To DO
-------------
Integrate HTML reporter like allure reports or Testra Reporting tool(This is my own reporting tool, can be integrated to any cucumber and Java projects)
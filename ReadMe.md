## **Full Stack Automation Final Project**
[Short Video - Demonstration](https://drive.google.com/file/d/1hAUzxmJI-iaACPlKhXdfROXmjrBnLakk/view?usp=sharing)
### **_This project demonstrate my knowledge and skills in Automation Testing._**
***
### _About_
The project demonstrates a smart automation infrastructure. In this project we emphasize the hierarchy order of the project structure.
In this way, the tests can be created with no complications.
In addition, the infrastructure allows us to work with different types of applications.
**Most important advantage of the infrastructure is the ability to be easily maintained!**
### _Project Overview_
Application types:
* Web based application
* Mobile application
* API with rest-assured 
* Electron application
* Desktop application
### **_The Infrastructure:_**
* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Screenshots
* Video Recording
* Failure Mechanism
* Common Functionality
* External Files Support
* Reporting System (including screenshots)
* Visual Testing
* DB support
* DDT support
* CI support
***
### _Applications List:_
* Mortgage webpage - Web based application
* Loan Calculator IQ - Mobile application
* Grafana API - Web API
* Todoist - Electron application
* Windows calculator - Desktop application
### _Tools & Frameworks:_
* TestNG - Testing Framework
* Listeners - interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - used for login to Grafana web page
* Jenkins - for tests execution
* REST Assured - for API testing
* Allure Reports - as the main reporting system
### Tests Execution:
> Each of the applications has a few tests for demonstration purpose.
These tests can be created and implemented with ease, due to a strong infrastructure.
[[Sanity Tests]](https://github.com/Ronenk7/TheFinalProject/tree/master/src/test/java/sanity)
### _Known Issues:_
Consequently, that the experitest dependencies can not co-exist with appium dependencies, there are 
some changes that will have to be made in the code.
In essence, when we want to run the desktop app we need to disable the mobile support and vice versa.

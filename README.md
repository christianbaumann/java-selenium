## java-selenium

* For practicing Selenium in the Java flavour  
* Based on the [Selenium WebDriver with Java](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/) course by [Angie Jones](https://twitter.com/techgirl1908) on [TestautomationU](https://testautomationu.applitools.com/)

## Execution

All tests: ``mvn test``

Single test class: ``mvn test -Dtest=<ClassName>``, eg ``mvn clean test -Dtest=AlertTests``  

Single test: ``mvn test -Dtest=<ClassName>``, eg ``mvn test -Dtest=LoginTests#testSuccessfullLogin``

## Reports
At: ``target\surefire-reports``
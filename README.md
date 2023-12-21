# Test automation project for https://magento.softwaretestingboard.com
![store logo](images/logo/logo.svg)

>Luma is a demo online store built on Magento CMS

## :pushpin: Table of contents
- [Technologies and tools](#technologist-technologies-and-tools)

## :computer: Technologies and tools
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Jira" src="images/logo/Jira.svg">
</p>

### Project Description

#### Autotests

The autotests for this project are written in Java and utilize the following tools and frameworks:

- **Selenide framework**: Used for UI tests
- **Gradle**: A build automation tool
- **JUnit5**: Used for executing the tests
- **Jenkins**: Used for CI/CD to run tests remotely
- **Selenoid**: Enables running tests remotely in browsers launched in Docker containers
- **Allure Report**: Utilized for visualizing test results
- **Allure TestOps**: Implemented as a Test Management System
- **Telegram Bot**: Used for test results notifications

#### Allure Report Details

An Allure report includes:

- Test steps
- A screenshot of the browser page when the test is completed
- Page source
- Browser console logs
- A video of the test running

## :computer: How to run the tests from Terminal
### Running the tests locally
```
gradle clean test
```
### Running the tests remotely
```
clean test -Dremote=${REMOTE} -Dremote_login=${REMOTE_LOGIN} -Dremote_pass=${REMOTE_PASS} -Dresolution=${RESOLUTION} -Dbrowser=${BROWSER} -Dbrowser_version=${VERSION}
```
You need to specify the following parameteres:
* <code>REMOTE</code> - a remote server to run the tests
* <code>REMOTE_LOGIN</code> - the server login
* <code>REMOTE_PASS</code> - the server password
* <code>RESOLUTION</code> - a browser window resolution (<code>1920x1080</code> by default)
* <code>BROWSER</code> - a browser (<code>chrome</code> by default)
* <code>VERSION</code> - the browser version (<code>100.0</code> by default)

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> How to run the tests in [Jenkins](https://jenkins.autotests.cloud/job/c17-kat_rud-luma-ecommerce/)
Click <code>**Build With Parameters**</code> and select values for the options. Click <code>**Build**</code> button to start a build.
<p align="center">
  <img src="images/screenshots/Jenkins.png" alt="Jenkins" width="800">
</p>

After the build is completed in <code>**Build History**</code> section you will find <code>**Allure Report**</code> link right at the latest build. Click it to view the results on an HTML generated page.
<p align="center">
  <img src="images/screenshots/Allure_Report.png" alt="Jenkins" width="800">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Test results in [Allure Report](https://jenkins.autotests.cloud/job/c17-kat_rud-luma-ecommerce/allure/)
<p align="center">
  <img src="images/screenshots/Allure_Report_Details.png" alt="Jenkins" width="800">
</p>

## <img width="4%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/33209)
<p align="center">
  <img src="images/screenshots/Allure_TestOps.png" alt="testresults" width="900">
</p>

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1002)
<p align="center">
  <img src="images/screenshots/Jira.png" alt="jira" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications
After the build is completed, a special bot created in <code>Telegram</code>, automatically processes and sends a test run report message.

<p align="center">
<img title="Telegram Notifications" src="media/telegram.png">
</p>

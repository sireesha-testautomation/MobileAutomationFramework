# 🚀 Sireesha Test Automation – Hybrid Mobile Automation Framework

A scalable **Hybrid Test Automation Framework** built using **Java, TestNG, Maven, Selenium/Appium**, and industry best practices.  
This framework supports **modular test design, reporting, logging, and reusable utilities** for UI and mobile automation.

📂 Project Structure
```Project Folder Structure
mobile-automation-framework
├── src/test/java
│   ├── pageobjects
│   │   └── Page Object classes representing application screens
│   │
│   ├── testbase
│   │   └── Base classes for WebDriver/Appium setup, driver initialization,
│   │       configuration loading, and common test setup/teardown
│   │
│   ├── testcases
│   │   └── TestNG test classes containing test scenarios
│   │
│   └── utilities
│       ├── DataProviders.java        → TestNG data providers
│       ├── ExcelUtility.java         → Read/write test data from Excel
│       ├── ExtentReportManager.java  → Extent report configuration
│       └── RetryAnalyzer.java        → Retry failed test cases
│
├── src/test/resources
│   ├── config.properties             → Environment & device configuration
│   ├── log4j2.xml                    → Logging configuration
│   ├── General-Store.apk             → Mobile app under test
│   └── chromedriver.exe              → Chrome WebDriver executable
│
├── logs
│   └── automation-YYYY-MM-DD.log     → Execution logs
│
├── reports
│   └── Test-Report-YYYY.MM.DD.html   → Extent HTML reports
│
├── screenshots
│   └── Screenshots captured on test failure
│
├── testData
│   └── External test data files (Excel)
│
├── test-output
│   └── TestNG default reports
│
├── pom.xml                            → Maven dependencies & plugins
├── testng.xml                         → TestNG suite configuration
├── run.bat                            → Batch file to execute tests
└── README.md

## 🧩 Framework Type

This is a **Hybrid Automation Framework**, combining:

- Page Object Model (POM)  
- Data-driven testing  
- Keyword-driven utilities  
- TestNG framework  
- Maven build management  

---

## 🛠️ Tech Stack

- **Programming Language:** Java  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Automation Tools:** Selenium / Appium  
- **Logging:** Log4j (or Java Logger if configured)  
- **Reporting:** TestNG Reports / Custom Reports  
- **IDE:** Eclipse / IntelliJ  
- **OS:** Windows  

---

## ✨ Features

- ✅ Page Object Model (POM) design pattern  
- ✅ Modular and reusable test components  
- ✅ Parallel execution using TestNG  
- ✅ Data-driven testing support  
- ✅ Centralized configuration via XML & Maven  
- ✅ Logging and reporting  
- ✅ Batch execution using Run.bat  
- ✅ Maven lifecycle integration (test, clean, install)  

---

## ⚙️ Prerequisites

Make sure the following are installed:

- Java JDK 17 or higher  
- Maven 3.x  
- Eclipse / IntelliJ IDE  
- Android Studio & Emulator (for mobile testing)  
- Node.js & Appium Server (for mobile automation)  

---

## ▶️ How to Run Tests

### 🔹 1. Using TestNG XML
Right-click `testng.xml` → Run As → TestNG Suite

---

### 🔹 2. Using Maven Command Line

```bash
mvn clean test

### 🔹 3. Using Batch File

```bash
Run Run.bat


Test Reports

After execution, reports are generated in:

/reports/

Logging

Execution logs are stored in:

/logs/

📈 Future Enhancements

CI/CD integration with GitHub Actions / Jenkins

Allure or Extent Reports integration

Dockerized test execution

Cloud execution on BrowserStack / Sauce Labs

Cross-platform mobile (Android + iOS) support

👩‍💻 Author

Sireesha Gumireddy
QA Automation Engineer | Selenium | Appium | Java | TestNG

⭐ If you like this project, give it a star!

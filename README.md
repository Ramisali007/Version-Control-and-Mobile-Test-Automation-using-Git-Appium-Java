# Mobile Test Automation Framework

![Build Status](https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java/actions/workflows/ci-cd.yml/badge.svg)
![Tests](https://img.shields.io/badge/tests-10%2B-blue)
![Java](https://img.shields.io/badge/Java-11-orange)
![Appium](https://img.shields.io/badge/Appium-9.1.0-purple)

## 📋 Project Overview

This is a comprehensive **Mobile Test Automation Framework** built using **Appium**, **Java**, and **TestNG** for automated testing of Android mobile applications. The framework follows industry best practices including **Page Object Model (POM)** design pattern and includes **Continuous Integration** using GitHub Actions.

### 👨‍🎓 Student Information

| # | Name | Roll Number | Class | GitHub |
|---|------|-------------|-------|--------|
| 1 | Ramis Ali | 22f-3703 | BSSE-8B | [@Ramisali007](https://github.com/Ramisali007) |
---

## 🛠️ Tools and Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11 | Programming Language |
| Maven | 3.x | Build Tool & Dependency Management |
| Appium | 9.1.0 | Mobile Automation Framework |
| TestNG | 7.9.0 | Testing Framework |
| Selenium | 4.17.0 | WebDriver Support (pinned for Appium 9.1.0 compat) |
| ExtentReports | 5.1.1 | Test Reporting |
| GitHub Actions | - | CI/CD Pipeline |

---

## 📁 Project Structure

```
mobile-test-automation/
│
├── .github/
│   ├── workflows/
│   │   └── ci-cd.yml                      # GitHub Actions (Build + Docker Validate)
│   ├── ISSUE_TEMPLATE/
│   │   ├── bug_report.md
│   │   └── feature_request.md
│   └── pull_request_template.md
│
├── docker/
│   └── docker-compose.yml                 # Appium + Android 11 emulator stack
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/ramis/
│   │           ├── base/
│   │           │   ├── BaseTest.java      # ThreadLocal driver, ExtentReports lifecycle
│   │           │   └── BasePage.java      # Shared wait/driver utilities
│   │           │
│   │           ├── pages/                 # Page Object Model Classes
│   │           │   ├── SettingsPage.java  # Android Settings POM (primary)
│   │           │   ├── CalculatorPage.java
│   │           │   ├── LoginPage.java
│   │           │   └── HomePage.java
│   │           │
│   │           └── utils/
│   │               ├── ConfigReader.java
│   │               ├── ExtentManager.java
│   │               └── ScreenshotUtil.java
│   │
│   └── test/
│       ├── java/
│       │   └── com/ramis/tests/
│       │       ├── SettingsTest.java      # 10 functional test cases (primary suite)
│       │       ├── CalculatorTest.java
│       │       ├── LoginTest.java
│       │       ├── NavigationTest.java
│       │       └── DiagnosticTest.java
│       │
│       └── resources/
│           └── config.properties          # Device & server configuration
│
├── extent-reports/                        # Auto-generated HTML test reports
├── target/                                # Maven build output
├── pom.xml                                # Maven config (Selenium pinned to 4.17.0)
├── testng.xml                             # TestNG suite (parallel="methods")
└── README.md
```

---

## ✨ Features

### 1. **Page Object Model (POM)**
- Separate page classes for each screen
- Encapsulated element locators and actions
- Reusable and maintainable code
- Follows OOP principles

### 2. **Test Cases** (10+ Implemented)

#### Primary Suite — Android Settings App (`testng.xml`)
1. ✅ TC-01: Settings app launches and main screen is displayed
2. ✅ TC-02: Network & internet option visible on main screen
3. ✅ TC-03: Navigation to Network & internet settings
4. ✅ TC-04: Back navigation returns to main Settings screen
5. ✅ TC-05: Navigation to Bluetooth settings
6. ✅ TC-06: Navigation to Apps settings
7. ✅ TC-07: Navigation to Display settings
8. ✅ TC-08: Navigation to Sound & vibration settings
9. ✅ TC-09: Search functionality in Settings
10. ✅ TC-10: Navigation to About phone screen

#### Additional POM Demo — Android Calculator App (`CalculatorTest.java`)
> ⚠️ Requires `appPackage=com.android.calculator2` in `config.properties` to run.

- Addition, Subtraction, Multiplication, Division
- Decimal addition, Large number multiplication
- Clear / Delete / Division-by-zero / Multiple operations

### 3. **Framework Capabilities**
- ✅ Configurable Appium settings
- ✅ Screenshot capture on failure
- ✅ ExtentReports for detailed reporting
- ✅ Logging support
- ✅ Independent test execution
- ✅ Proper assertions

---

## 🚀 Setup Instructions

### Prerequisites

Before running the tests, ensure you have the following installed:

1. **Java JDK 11 or higher**
   ```bash
   java -version
   ```

2. **Maven 3.6+**
   ```bash
   mvn -version
   ```

3. **Node.js and npm**
   ```bash
   node --version
   npm --version
   ```

4. **Appium Server**
   ```bash
   npm install -g appium
   appium -v
   ```

5. **Android Studio** (for Android SDK and Emulator)

6. **Appium Inspector** (Optional - for element inspection)

### Environment Setup

1. **Set JAVA_HOME**
   ```bash
   # Windows
   setx JAVA_HOME "C:\Program Files\Java\jdk-11"
   
   # Linux/Mac
   export JAVA_HOME=/path/to/jdk-11
   ```

2. **Set ANDROID_HOME**
   ```bash
   # Windows
   setx ANDROID_HOME "C:\Users\YourUsername\AppData\Local\Android\Sdk"
   
   # Linux/Mac
   export ANDROID_HOME=~/Android/Sdk
   ```

3. **Update PATH**
   ```bash
   # Add to PATH
   %ANDROID_HOME%\platform-tools
   %ANDROID_HOME%\tools
   ```

---

## 📥 Installation Steps

### 1. Clone the Repository
```bash
git clone https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
cd Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Device Settings
Edit `src/test/resources/config.properties`:
```properties
deviceName=Your_Device_Name
platformVersion=11.0
appiumServer=http://127.0.0.1:4723
```

### 4. Start Appium Server
```bash
appium
```
Or start Appium Desktop application.

### 5. Start Android Emulator or Connect Real Device
```bash
# List available devices
adb devices

# Start emulator
emulator -avd Your_AVD_Name
```

---

## ▶️ Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=CalculatorTest
```

### Run with TestNG XML
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run from IDE (IntelliJ/Eclipse)
- Right-click on test class → Run As → TestNG Test

---

## 📊 Test Reports

### Extent Reports
After test execution, open the HTML report:
```
extent-reports/TestReport_[timestamp].html
```

The report includes:
- Test execution summary
- Pass/Fail status
- Screenshots
- Execution time
- System information

### TestNG Reports
```
target/surefire-reports/index.html
```

---

## 🔄 CI/CD Workflow

The project uses **GitHub Actions** for Continuous Integration.

### Workflow Triggers
- ✅ Push to `main` branch
- ✅ Push to `develop` branch
- ✅ Pull Requests to `main` or `develop`
- ✅ Manual trigger

### CI Pipeline Steps
1. **Checkout Code** - Clone repository
2. **Setup JDK 11** - Configure Java environment
3. **Cache Dependencies** - Cache Maven packages
4. **Install Dependencies** - Maven clean install
5. **Compile Project** - Compile source and test code
6. **Package Application** - Create build artifacts
7. **Upload Artifacts** - Archive build outputs

### Mobile Testing in CI
**Note:** Actual Appium test execution requires Android emulator/device and is performed locally. The CI pipeline validates code compilation and build quality. This is the industry-standard approach for mobile test automation, as running tests in CI requires:
- Physical devices or cloud device farms (BrowserStack, Sauce Labs)
- Complex emulator setup with significant resources
- Additional cost for cloud services

### View CI Status
Check the Actions tab in your GitHub repository to see pipeline status (should show ✅ green checkmark).

---

## � Docker Setup

Run the full Appium + Android Emulator stack with a single command — no local Android SDK required.

### Prerequisites
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running
- At least **8 GB RAM** allocated to Docker

### Start the Stack
```bash
cd docker
docker compose up -d
```

This starts:
| Service | Description | Port |
|---------|-------------|------|
| `appium` | Appium Server 2.x | `4723` |
| `android` | Android 11 emulator (noVNC) | `6080` (browser VNC) |

### Run Tests Against Docker Appium
```bash
# Wait ~60 seconds for emulator to boot, then:
mvn clean test
```

### Watch the emulator (optional)
Open **http://localhost:6080** in your browser to see the live Android screen via noVNC.

### Stop the Stack
```bash
docker compose down
```

---

## �📂 Git Workflow

### Branching Strategy

```
main (production-ready code)
  │
  ├── develop (integration branch)
  │     │
  │     ├── feature/calculator-tests
  │     ├── feature/login-tests
  │     └── feature/navigation-tests
```

### Branch Protection Rules
- ❌ No direct commits to `main`
- ✅ All changes via Pull Requests
- ✅ Require PR reviews
- ✅ Require status checks to pass

### Commit Message Convention
```bash
feat: Add calculator test cases
fix: Resolve element locator issue
docs: Update README with setup instructions
test: Add division by zero test case
ci: Configure GitHub Actions workflow
```

### Creating a Feature Branch
```bash
# Create and switch to new branch
git checkout -b feature/your-feature-name

# Make changes and commit
git add .
git commit -m "feat: your feature description"

# Push to remote
git push origin feature/your-feature-name

# Create Pull Request on GitHub
```

---

## 📋 GitHub Issues

Track project tasks using GitHub Issues:

1. **Create Issue** - Break down tasks
2. **Assign to Team Member** - Distribute work
3. **Add Labels** - Categorize (bug, feature, documentation)
4. **Link to PR** - Connect code changes
5. **Close on Merge** - Mark completed

---

## 🏆 Assignment Requirements Checklist

### ✅ TASK 1: Git Repository Management
- [x] Private GitHub repository created
- [x] Collaborators added
- [x] Branch protection enabled
- [x] Pull request reviews enabled
- [x] Structured branching model
- [x] Meaningful commit messages

### ✅ TASK 2: Appium Framework Setup
- [x] Maven-based Java project
- [x] Appium configured for Android
- [x] Structured test framework

### ✅ TASK 3: Page Object Model
- [x] Separate page classes created
- [x] Element locators encapsulated
- [x] No code duplication
- [x] OOP principles followed

### ✅ TASK 4: Test Case Automation
- [x] 10+ functional test cases automated
- [x] Proper assertions included
- [x] Independent test execution

### ✅ TASK 5: Continuous Integration
- [x] GitHub Actions pipeline set up
- [x] Runs on push to main
- [x] Runs on Pull Requests
- [x] Builds and compiles Maven project
- [x] Validates Docker Compose configuration
- [x] Uploads build artifacts

### ✅ BONUS: Parallel Execution
- [x] `ThreadLocal<AppiumDriver>` — thread-safe driver per test
- [x] `parallel="methods" thread-count="2"` in testng.xml
- [x] Each test method gets its own Appium session

### ✅ BONUS: Test Report Generation
- [x] ExtentReports HTML with dark theme
- [x] Per-test pass/fail/skip status
- [x] Screenshot attachment on failure
- [x] System info (OS, Java, student details)

### ✅ BONUS: Dockerized Appium Setup
- [x] `docker/docker-compose.yml` — Appium + Android 11 emulator
- [x] No local Android SDK needed
- [x] noVNC browser-based device view on port 6080
- [x] Validated in CI `docker-validate` job

### ✅ TASK 6: Documentation
- [x] README.md with project overview
- [x] Tools and technologies listed
- [x] Setup instructions provided
- [x] How to run tests explained
- [x] CI workflow documented
- [x] Git workflow explained

---

## 🎯 Bonus Features (Optional)

### Implemented
- ✅ Test Report Generation (ExtentReports HTML with Dark theme)
- ✅ Screenshot Capture on Failure
- ✅ Parallel Test Execution (ThreadLocal driver, `parallel="methods"` in testng.xml)
- ✅ Dockerized Appium Setup (`docker/docker-compose.yml` — see [Docker Setup](#-docker-setup))
- ✅ Configuration Management (config.properties)
- ✅ Logging Support

### Future Enhancements
- ⏳ Cloud Device Integration (BrowserStack/Sauce Labs)
- ⏳ Data-Driven Testing

---

## 🐛 Troubleshooting

### Common Issues

**1. Appium Server Not Starting**
```bash
# Kill existing Appium processes
pkill -f appium
# Start fresh
appium
```

**2. Device Not Detected**
```bash
adb kill-server
adb start-server
adb devices
```

**3. Build Failures**
```bash
mvn clean install -U
```

**4. Element Not Found**
- Use Appium Inspector to verify locators
- Increase implicit/explicit wait times
- Check app package and activity names

---

## 👥 Team Collaboration

### Workflow
1. Create GitHub Issue for task
2. Create feature branch
3. Implement changes
4. Write/update tests
5. Commit with meaningful messages
6. Push to remote branch
7. Create Pull Request
8. Code review by team member
9. Merge after approval
10. Delete feature branch

---

## 📧 Contact

**Ramis Ali**
- Roll Number: 22f-3703
- Class: BSSE-8B
- GitHub: [@Ramisali007](https://github.com/Ramisali007)

---

## 📝 License

This project is created for educational purposes as part of the DevOps course assignment.

---

## 🙏 Acknowledgments

- Course Instructor for assignment guidelines
- Appium community for excellent documentation
- TestNG and Maven for robust testing framework

---

**Last Updated:** February 2026

**Version:** 2.0.0

---

## 📸 Screenshots

### Test Execution & Reports
Test execution reports are auto-generated in `extent-reports/` after each local run.
Open any `TestReport_*.html` file in a browser to view the full dashboard.

### CI Pipeline
The live pipeline status is shown by the badge at the top of this README.
Check the **Actions** tab in GitHub for step-by-step logs of every run.

### Docker Appium Stack
After `docker compose up -d`, open **http://localhost:6080** to watch the live Android emulator.

---

**Made with ❤️ by Ramis Ali | BSSE-8B | 22f-3703**

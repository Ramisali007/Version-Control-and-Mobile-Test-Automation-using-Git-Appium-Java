# Quick Start Guide

Get up and running with the Mobile Test Automation Framework in minutes!

## Prerequisites Check

Before starting, verify you have:
- ✅ Java 11+ installed
- ✅ Maven 3.6+ installed
- ✅ Node.js and npm installed
- ✅ Appium installed globally
- ✅ Android Studio with SDK
- ✅ Emulator or real device ready

**Quick Check:**
```bash
java -version
mvn -version
node -version
appium -v
adb devices
```

---

## 5-Minute Setup

### Step 1: Clone Repository (30 seconds)
```bash
git clone https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
cd Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java
```

### Step 2: Install Dependencies (2 minutes)
```bash
mvn clean install
```

### Step 3: Start Appium Server (30 seconds)
**Terminal 1:**
```bash
appium
```

### Step 4: Start Android Device (1 minute)
**Terminal 2:**
```bash
# Option A: Start Emulator
emulator -avd Pixel_4_API_30

# Option B: Connect Real Device
adb devices  # Verify device connected
```

### Step 5: Run Tests (1 minute)
**Terminal 3:**
```bash
mvn clean test
```

**OR use the run script:**
```bash
# Windows
run-tests.bat

# Mac/Linux
chmod +x run-tests.sh
./run-tests.sh
```

---

## What's Included?

### ✅ Complete Test Framework
- Page Object Model implementation
- 10+ automated test cases
- Base classes for easy extension
- Configuration management

### ✅ Test Cases (Calculator App)
1. Addition Test
2. Subtraction Test
3. Multiplication Test
4. Division Test
5. Decimal Addition Test
6. Large Number Multiplication Test
7. Clear Function Test
8. Delete Function Test
9. Division by Zero Test
10. Multiple Operations Test

### ✅ Reporting
- ExtentReports for detailed HTML reports
- Screenshot capture on failures
- TestNG reports

### ✅ CI/CD
- GitHub Actions configured
- Automatic build and test on push
- Artifact upload

---

## Project Structure Overview

```
mobile-test-automation/
├── src/
│   ├── main/java/com/ramis/
│   │   ├── base/          # Base classes
│   │   ├── pages/         # Page Object Models
│   │   └── utils/         # Utilities
│   └── test/
│       ├── java/com/ramis/tests/  # Test classes
│       └── resources/             # Config files
├── .github/workflows/     # CI/CD configuration
├── extent-reports/        # Test reports (generated)
├── screenshots/           # Test screenshots (generated)
├── pom.xml               # Maven configuration
├── testng.xml            # TestNG suite
└── README.md             # Documentation
```

---

## Common Commands

### Build & Test
```bash
# Clean and install
mvn clean install

# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=CalculatorTest

# Skip tests
mvn clean install -DskipTests

# Package project
mvn package
```

### Device Management
```bash
# List devices
adb devices

# List emulators
emulator -list-avds

# Start emulator
emulator -avd Your_AVD_Name

# Restart ADB
adb kill-server
adb start-server
```

### Appium
```bash
# Start Appium
appium

# Start on specific port
appium -p 4724

# Check Appium status
curl http://localhost:4723/status
```

---

## View Test Reports

After running tests:

```bash
# Open ExtentReports (HTML)
# Windows
start extent-reports\TestReport_[timestamp].html

# Mac
open extent-reports/TestReport_[timestamp].html

# Linux
xdg-open extent-reports/TestReport_[timestamp].html
```

---

## Customize Configuration

Edit `src/test/resources/config.properties`:

```properties
# Change device name
deviceName=Your_Device_Name

# Change Android version
platformVersion=11.0

# Change Appium server URL
appiumServer=http://127.0.0.1:4723
```

---

## Run with IDE

### IntelliJ IDEA
1. Open project
2. Wait for Maven import
3. Right-click on test class
4. Select "Run 'CalculatorTest'"

### Eclipse
1. Import Maven project
2. Right-click on test class
3. Run As → TestNG Test

---

## Troubleshooting Quick Fixes

### Tests not running?
```bash
# Check Appium is running
curl http://localhost:4723/status

# Check device connected
adb devices

# Restart Appium
pkill -f appium  # Mac/Linux
appium
```

### Build errors?
```bash
# Clean Maven cache
mvn clean install -U
```

### Element not found?
- Verify app is installed
- Check element locators
- Increase wait times

---

## Next Steps

1. ✅ Run the sample tests
2. ✅ Explore the code structure
3. ✅ Read the full [README.md](README.md)
4. ✅ Check [SETUP_GUIDE.md](SETUP_GUIDE.md) for detailed setup
5. ✅ Review [GIT_WORKFLOW.md](GIT_WORKFLOW.md) for Git practices
6. ✅ Create your own test cases
7. ✅ Push to GitHub repository

---

## Need Help?

Check these resources:
- 📖 [README.md](README.md) - Full documentation
- 🛠️ [SETUP_GUIDE.md](SETUP_GUIDE.md) - Detailed setup
- 🔀 [GIT_WORKFLOW.md](GIT_WORKFLOW.md) - Git workflow
- ✅ [SUBMISSION_CHECKLIST.md](SUBMISSION_CHECKLIST.md) - Submission guide
- 💬 GitHub Issues for questions

---

## Tips for Success

💡 **Testing Tips:**
- Start Appium before running tests
- Keep device/emulator running
- Check logs for errors
- Use Appium Inspector for locators

💡 **Development Tips:**
- Follow Page Object Model pattern
- Write independent tests
- Use descriptive names
- Add proper assertions

💡 **Git Tips:**
- Create feature branches
- Write meaningful commits
- Review before pushing
- Use Pull Requests

---

## That's It! 🎉

You're now ready to use the Mobile Test Automation Framework!

**Happy Testing!** 🚀

---

**Ramis Ali | 22f-3703 | BSSE-8B**

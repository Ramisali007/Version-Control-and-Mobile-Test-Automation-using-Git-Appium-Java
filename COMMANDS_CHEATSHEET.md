# Commands Cheat Sheet

Quick reference for all important commands used in this project.

---

## Git Commands

### Initial Setup
```bash
# Initialize git repository
git init

# Add remote origin
git remote add origin https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git

# First commit
git add .
git commit -m "feat: initial project setup"
git push -u origin main
```

### Daily Workflow
```bash
# Check status
git status

# Pull latest changes
git pull origin develop

# Create feature branch
git checkout -b feature/feature-name

# Stage changes
git add .

# Commit changes
git commit -m "feat: your message"

# Push to remote
git push origin feature/feature-name

# Switch branches
git checkout branch-name

# List branches
git branch -a

# Delete local branch
git branch -d feature-name

# Delete remote branch
git push origin --delete feature-name
```

### Merging
```bash
# Merge develop into your branch
git checkout feature/your-branch
git merge develop

# Resolve conflicts, then
git add .
git commit -m "merge: resolve conflicts with develop"
```

---

## Maven Commands

### Build & Install
```bash
# Clean and install
mvn clean install

# Skip tests during install
mvn clean install -DskipTests

# Clean project
mvn clean

# Compile only
mvn compile

# Package project
mvn package

# Update dependencies
mvn clean install -U
```

### Testing
```bash
# Run all tests
mvn test

# Run all tests with clean
mvn clean test

# Run specific test class
mvn test -Dtest=CalculatorTest

# Run specific test method
mvn test -Dtest=CalculatorTest#testAddition

# Run multiple test classes
mvn test -Dtest=CalculatorTest,LoginTest

# Skip tests
mvn install -DskipTests

# Run with specific TestNG XML
mvn clean test -DsuiteXmlFile=testng.xml
```

### Project Info
```bash
# Show dependencies
mvn dependency:tree

# Show effective POM
mvn help:effective-pom

# Validate project
mvn validate

# Show active profiles
mvn help:active-profiles
```

---

## Appium Commands

### Installation
```bash
# Install Appium globally
npm install -g appium

# Check Appium version
appium -v

# Install Appium doctor
npm install -g appium-doctor

# Run Appium doctor
appium-doctor --android
```

### Running Appium
```bash
# Start Appium server
appium

# Start on specific port
appium -p 4724

# Start with logs
appium --log appium.log

# Check Appium status
curl http://localhost:4723/status
```

### Drivers
```bash
# Install UiAutomator2 driver
appium driver install uiautomator2

# List installed drivers
appium driver list

# Update driver
appium driver update uiautomator2
```

### Stopping Appium
```bash
# Kill Appium process (Mac/Linux)
pkill -f appium

# Kill Appium process (Windows)
taskkill /F /IM node.exe
```

---

## ADB (Android Debug Bridge) Commands

### Device Management
```bash
# List connected devices
adb devices

# List devices (detailed)
adb devices -l

# Restart ADB server
adb kill-server
adb start-server

# Connect to specific device
adb -s emulator-5554 shell

# Get device properties
adb shell getprop
```

### App Management
```bash
# Install APK
adb install path/to/app.apk

# Uninstall app
adb uninstall com.package.name

# List installed packages
adb shell pm list packages

# List third-party packages
adb shell pm list packages -3

# Clear app data
adb shell pm clear com.package.name

# Get app info
adb shell pm dump com.package.name
```

### Device Info
```bash
# Get Android version
adb shell getprop ro.build.version.release

# Get device model
adb shell getprop ro.product.model

# Get device serial
adb shell getprop ro.serialno

# Get screen resolution
adb shell wm size

# Get device battery status
adb shell dumpsys battery
```

### Logs
```bash
# View logcat
adb logcat

# Clear logcat
adb logcat -c

# Save logcat to file
adb logcat > logcat.txt

# Filter logcat by tag
adb logcat -s TAG_NAME
```

### File Operations
```bash
# Push file to device
adb push local-file /sdcard/

# Pull file from device
adb pull /sdcard/file local-destination

# Screenshot
adb shell screencap /sdcard/screen.png
adb pull /sdcard/screen.png

# Record screen
adb shell screenrecord /sdcard/demo.mp4
```

---

## Android Emulator Commands

### List & Create
```bash
# List available AVDs
emulator -list-avds

# Create AVD (via Android Studio or command)
avdmanager create avd -n test_avd -k "system-images;android-30;google_apis;x86_64"
```

### Start Emulator
```bash
# Start emulator
emulator -avd AVD_NAME

# Start with specific port
emulator -avd AVD_NAME -port 5556

# Start without audio
emulator -avd AVD_NAME -no-audio

# Start with writable system
emulator -avd AVD_NAME -writable-system

# Start in headless mode (no UI)
emulator -avd AVD_NAME -no-window

# Start with specific RAM
emulator -avd AVD_NAME -memory 2048
```

### Emulator Control
```bash
# Kill emulator
adb -s emulator-5554 emu kill

# Reboot emulator
adb -s emulator-5554 reboot
```

---

## Java Commands

### Compilation & Execution
```bash
# Check Java version
java -version

# Check compiler version
javac -version

# Check JAVA_HOME
echo $JAVA_HOME  # Mac/Linux
echo %JAVA_HOME%  # Windows

# Compile Java file
javac FileName.java

# Run Java class
java ClassName
```

---

## Node.js & NPM Commands

### Version & Info
```bash
# Check Node version
node -v

# Check NPM version
npm -v

# Check NPM configuration
npm config list

# Get global packages location
npm root -g
```

### Package Management
```bash
# Install package globally
npm install -g package-name

# Uninstall package globally
npm uninstall -g package-name

# Update package globally
npm update -g package-name

# List global packages
npm list -g --depth=0

# Update npm itself
npm install -g npm@latest
```

---

## Project-Specific Commands

### Quick Setup
```bash
# One-time setup
git clone https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
cd Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java
mvn clean install
```

### Daily Testing Workflow
```bash
# Terminal 1: Start Appium
appium

# Terminal 2: Start Emulator
emulator -avd Pixel_4_API_30

# Terminal 3: Run Tests
mvn clean test

# Or use the script
./run-tests.sh  # Mac/Linux
run-tests.bat   # Windows
```

### View Reports
```bash
# Open ExtentReports (Mac)
open extent-reports/TestReport_*.html

# Open ExtentReports (Linux)
xdg-open extent-reports/TestReport_*.html

# Open ExtentReports (Windows)
start extent-reports\TestReport_*.html
```

---

## Troubleshooting Commands

### Clean Everything
```bash
# Clean Maven
mvn clean

# Clean Maven cache
rm -rf ~/.m2/repository  # Mac/Linux
rmdir /s %USERPROFILE%\.m2\repository  # Windows

# Clean Git
git clean -fdx
```

### Reset & Restart
```bash
# Kill all ADB processes
adb kill-server
adb start-server

# Kill Appium
pkill -f appium  # Mac/Linux
taskkill /F /IM node.exe  # Windows

# Restart Appium
appium

# Reset emulator to factory
emulator -avd AVD_NAME -wipe-data
```

---

## CI/CD Commands (GitHub)

### Check Workflow
```bash
# Install GitHub CLI (optional)
gh workflow list

# View workflow runs
gh run list

# View specific run
gh run view RUN_ID
```

---

## Useful Aliases (Optional)

Add to `.bashrc` or `.zshrc`:

```bash
# Git aliases
alias gs='git status'
alias ga='git add .'
alias gc='git commit -m'
alias gp='git push'
alias gl='git log --oneline'

# Maven aliases
alias mci='mvn clean install'
alias mct='mvn clean test'
alias mcs='mvn clean install -DskipTests'

# Appium aliases
alias appium-start='appium'
alias appium-stop='pkill -f appium'

# Emulator aliases
alias emu-list='emulator -list-avds'
alias emu-start='emulator -avd Pixel_4_API_30'

# ADB aliases
alias adb-devices='adb devices'
alias adb-restart='adb kill-server && adb start-server'
```

---

## Quick Reference URLs

### Documentation
- Java: https://docs.oracle.com/en/java/
- Maven: https://maven.apache.org/guides/
- Appium: https://appium.io/docs/
- TestNG: https://testng.org/doc/
- Git: https://git-scm.com/doc

### Downloads
- Java: https://adoptium.net/
- Maven: https://maven.apache.org/download.cgi
- Node.js: https://nodejs.org/
- Android Studio: https://developer.android.com/studio
- Appium Inspector: https://github.com/appium/appium-inspector

---

## Emergency Fixes

```bash
# If tests won't run
adb kill-server && adb start-server
pkill -f appium
appium

# If build fails
mvn clean install -U

# If elements not found
# Check config.properties
# Verify app package/activity
# Use Appium Inspector

# If port already in use
lsof -ti:4723 | xargs kill -9  # Mac/Linux
netstat -ano | findstr :4723  # Windows
```

---

**Keep this cheat sheet handy for quick reference!**

**Ramis Ali | 22f-3703 | BSSE-8B**

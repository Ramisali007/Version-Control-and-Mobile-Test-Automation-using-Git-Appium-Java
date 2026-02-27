# Setup Guide for Mobile Test Automation Framework

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Java Setup](#java-setup)
3. [Maven Setup](#maven-setup)
4. [Node.js and Appium Setup](#nodejs-and-appium-setup)
5. [Android Setup](#android-setup)
6. [Project Setup](#project-setup)
7. [Verification](#verification)
8. [Troubleshooting](#troubleshooting)

---

## Prerequisites

Before starting, ensure you have:
- Windows 10/11, macOS, or Linux
- At least 8GB RAM
- 20GB free disk space
- Admin/sudo privileges

---

## Java Setup

### Windows
1. Download JDK 11 from [Oracle](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) or [OpenJDK](https://adoptium.net/)
2. Install JDK
3. Set Environment Variables:
   ```batch
   setx JAVA_HOME "C:\Program Files\Java\jdk-11"
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```
4. Verify:
   ```bash
   java -version
   javac -version
   ```

### macOS
```bash
# Using Homebrew
brew install openjdk@11

# Set JAVA_HOME
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 11)' >> ~/.zshrc
source ~/.zshrc

# Verify
java -version
```

### Linux
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install openjdk-11-jdk

# Set JAVA_HOME
echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64' >> ~/.bashrc
source ~/.bashrc

# Verify
java -version
```

---

## Maven Setup

### Windows
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to `C:\Program Files\Apache\maven`
3. Set Environment Variables:
   ```batch
   setx MAVEN_HOME "C:\Program Files\Apache\maven"
   setx PATH "%PATH%;%MAVEN_HOME%\bin"
   ```
4. Verify:
   ```bash
   mvn -version
   ```

### macOS
```bash
brew install maven
mvn -version
```

### Linux
```bash
sudo apt install maven
mvn -version
```

---

## Node.js and Appium Setup

### Install Node.js

**Windows/macOS:**
Download from [nodejs.org](https://nodejs.org/) and install LTS version.

**Linux:**
```bash
curl -fsSL https://deb.nodesource.com/setup_lts.x | sudo -E bash -
sudo apt-get install -y nodejs
```

Verify:
```bash
node --version
npm --version
```

### Install Appium

```bash
# Install Appium globally
npm install -g appium

# Install Appium Doctor (for verification)
npm install -g appium-doctor

# Install UiAutomator2 driver
appium driver install uiautomator2

# Verify
appium -v
```

---

## Android Setup

### 1. Install Android Studio
Download from [developer.android.com](https://developer.android.com/studio)

### 2. Install Android SDK
1. Open Android Studio
2. Go to Tools → SDK Manager
3. Install:
   - Android SDK Platform (API 30 or higher)
   - Android SDK Build-Tools
   - Android SDK Platform-Tools
   - Android Emulator

### 3. Set Environment Variables

**Windows:**
```batch
setx ANDROID_HOME "C:\Users\%USERNAME%\AppData\Local\Android\Sdk"
setx PATH "%PATH%;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\tools;%ANDROID_HOME%\emulator"
```

**macOS/Linux:**
```bash
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/emulator

# Add to ~/.bashrc or ~/.zshrc
echo 'export ANDROID_HOME=$HOME/Android/Sdk' >> ~/.bashrc
echo 'export PATH=$PATH:$ANDROID_HOME/platform-tools' >> ~/.bashrc
source ~/.bashrc
```

### 4. Create Android Emulator
1. Open Android Studio
2. Go to Tools → Device Manager
3. Click "Create Device"
4. Select device (e.g., Pixel 4)
5. Select system image (e.g., Android 11)
6. Finish setup

### 5. Verify ADB
```bash
adb version
adb devices
```

---

## Project Setup

### 1. Clone Repository
```bash
git clone https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
cd Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Settings
Edit `src/test/resources/config.properties`:
```properties
deviceName=Your_Emulator_Name
platformVersion=11.0
appiumServer=http://127.0.0.1:4723
```

### 4. Create Required Directories
```bash
mkdir extent-reports
mkdir screenshots
```

---

## Verification

### 1. Check All Installations
```bash
# Run Appium Doctor
appium-doctor --android
```

All should show ✓ (green checkmarks)

### 2. Start Appium Server
```bash
appium
```

Should see:
```
[Appium] Welcome to Appium v2.x.x
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

### 3. Start Emulator
```bash
# List available emulators
emulator -list-avds

# Start emulator
emulator -avd Your_AVD_Name
```

### 4. Verify Device Connection
```bash
adb devices
```

Should show:
```
List of devices attached
emulator-5554   device
```

### 5. Run Sample Test
```bash
mvn clean test
```

---

## Troubleshooting

### Issue: Java not found
**Solution:**
- Verify JAVA_HOME is set correctly
- Check PATH includes JAVA_HOME/bin
- Restart terminal/IDE

### Issue: Maven not recognized
**Solution:**
```bash
# Windows
where mvn

# macOS/Linux
which mvn
```
If not found, reinstall or fix PATH

### Issue: Appium server not starting
**Solution:**
```bash
# Kill existing processes
pkill -f appium  # macOS/Linux
taskkill /F /IM node.exe  # Windows

# Start fresh
appium
```

### Issue: Device not detected
**Solution:**
```bash
adb kill-server
adb start-server
adb devices
```

### Issue: Build failures
**Solution:**
```bash
# Clean Maven cache
mvn clean install -U

# Clear .m2 cache
rm -rf ~/.m2/repository  # macOS/Linux
rmdir /s %USERPROFILE%\.m2\repository  # Windows
```

### Issue: Element not found
**Solution:**
- Use Appium Inspector to verify locators
- Increase wait times in config.properties
- Check app package and activity names

---

## Quick Start Commands

```bash
# 1. Start Appium
appium

# 2. Start Emulator (in new terminal)
emulator -avd Pixel_4_API_30

# 3. Run Tests (in new terminal)
cd mobile-test-automation
mvn clean test
```

---

## Additional Tools (Optional)

### Appium Inspector
Download from [GitHub](https://github.com/appium/appium-inspector/releases)

### Android Studio Plugins
- ADB Idea
- Genymotion

### IDE Plugins
**IntelliJ IDEA:**
- Maven Helper
- TestNG
- Git Integration

**VS Code:**
- Java Extension Pack
- Maven for Java
- Test Runner for Java

---

## Next Steps

1. ✅ Complete all installations
2. ✅ Verify setup using appium-doctor
3. ✅ Run sample tests
4. ✅ Explore framework structure
5. ✅ Create your first test case
6. ✅ Push to GitHub repository

---

## Support

If you encounter issues:
1. Check this setup guide
2. Review troubleshooting section
3. Check project README.md
4. Open GitHub issue
5. Contact team members

---

**Setup completed? Start testing!** 🚀

**Ramis Ali | 22f-3703 | BSSE-8B**

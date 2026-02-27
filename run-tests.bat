@echo off
REM ============================================
REM Mobile Test Automation - Quick Run Script
REM Author: Ramis Ali (22f-3703)
REM Class: BSSE-8B
REM ============================================

echo ========================================
echo Mobile Test Automation Framework
echo ========================================
echo.

REM Check if Maven is installed
where mvn >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Maven is not installed or not in PATH
    echo Please install Maven and try again
    pause
    exit /b 1
)

echo [INFO] Maven found
echo.

REM Display menu
:menu
echo ========================================
echo Select an option:
echo ========================================
echo 1. Clean and Install Dependencies
echo 2. Run All Tests
echo 3. Run Calculator Tests Only
echo 4. Run Tests and Generate Reports
echo 5. Clean Project
echo 6. Check Appium Server Connection
echo 7. List Connected Devices
echo 8. Exit
echo ========================================
echo.

set /p choice="Enter your choice (1-8): "

if "%choice%"=="1" goto install
if "%choice%"=="2" goto runall
if "%choice%"=="3" goto calculator
if "%choice%"=="4" goto reports
if "%choice%"=="5" goto clean
if "%choice%"=="6" goto appium
if "%choice%"=="7" goto devices
if "%choice%"=="8" goto end
echo Invalid choice, please try again
goto menu

:install
echo.
echo [INFO] Installing dependencies...
mvn clean install
echo.
echo [INFO] Installation complete
pause
goto menu

:runall
echo.
echo [INFO] Running all tests...
mvn clean test
echo.
echo [INFO] Test execution complete
echo [INFO] Check extent-reports folder for detailed reports
pause
goto menu

:calculator
echo.
echo [INFO] Running Calculator tests only...
mvn test -Dtest=CalculatorTest
echo.
echo [INFO] Test execution complete
pause
goto menu

:reports
echo.
echo [INFO] Running tests and generating reports...
mvn clean test
echo.
echo [INFO] Opening report...
start "" "%CD%\extent-reports\"
pause
goto menu

:clean
echo.
echo [INFO] Cleaning project...
mvn clean
echo.
echo [INFO] Project cleaned
pause
goto menu

:appium
echo.
echo [INFO] Checking Appium server connection...
curl -s http://localhost:4723/status
if %ERRORLEVEL% EQU 0 (
    echo.
    echo [SUCCESS] Appium server is running
) else (
    echo.
    echo [ERROR] Appium server is not running
    echo Please start Appium server first
)
echo.
pause
goto menu

:devices
echo.
echo [INFO] Listing connected devices...
adb devices
echo.
pause
goto menu

:end
echo.
echo Thank you for using Mobile Test Automation Framework!
echo.
exit /b 0

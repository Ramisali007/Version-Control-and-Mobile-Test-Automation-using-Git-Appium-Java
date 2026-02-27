#!/bin/bash
# ============================================
# Mobile Test Automation - Quick Run Script
# Author: Ramis Ali (22f-3703)
# Class: BSSE-8B
# ============================================

echo "========================================"
echo "Mobile Test Automation Framework"
echo "========================================"
echo ""

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "[ERROR] Maven is not installed or not in PATH"
    echo "Please install Maven and try again"
    exit 1
fi

echo "[INFO] Maven found"
echo ""

# Function definitions
install_deps() {
    echo ""
    echo "[INFO] Installing dependencies..."
    mvn clean install
    echo ""
    echo "[INFO] Installation complete"
}

run_all_tests() {
    echo ""
    echo "[INFO] Running all tests..."
    mvn clean test
    echo ""
    echo "[INFO] Test execution complete"
    echo "[INFO] Check extent-reports folder for detailed reports"
}

run_calculator_tests() {
    echo ""
    echo "[INFO] Running Calculator tests only..."
    mvn test -Dtest=CalculatorTest
    echo ""
    echo "[INFO] Test execution complete"
}

run_with_reports() {
    echo ""
    echo "[INFO] Running tests and generating reports..."
    mvn clean test
    echo ""
    echo "[INFO] Opening report..."
    if [[ "$OSTYPE" == "darwin"* ]]; then
        open extent-reports/
    elif [[ "$OSTYPE" == "linux-gnu"* ]]; then
        xdg-open extent-reports/
    fi
}

clean_project() {
    echo ""
    echo "[INFO] Cleaning project..."
    mvn clean
    echo ""
    echo "[INFO] Project cleaned"
}

check_appium() {
    echo ""
    echo "[INFO] Checking Appium server connection..."
    if curl -s http://localhost:4723/status > /dev/null; then
        echo ""
        echo "[SUCCESS] Appium server is running"
    else
        echo ""
        echo "[ERROR] Appium server is not running"
        echo "Please start Appium server first"
    fi
    echo ""
}

list_devices() {
    echo ""
    echo "[INFO] Listing connected devices..."
    adb devices
    echo ""
}

# Display menu
while true; do
    echo "========================================"
    echo "Select an option:"
    echo "========================================"
    echo "1. Clean and Install Dependencies"
    echo "2. Run All Tests"
    echo "3. Run Calculator Tests Only"
    echo "4. Run Tests and Generate Reports"
    echo "5. Clean Project"
    echo "6. Check Appium Server Connection"
    echo "7. List Connected Devices"
    echo "8. Exit"
    echo "========================================"
    echo ""
    
    read -p "Enter your choice (1-8): " choice
    
    case $choice in
        1) install_deps ;;
        2) run_all_tests ;;
        3) run_calculator_tests ;;
        4) run_with_reports ;;
        5) clean_project ;;
        6) check_appium ;;
        7) list_devices ;;
        8) 
            echo ""
            echo "Thank you for using Mobile Test Automation Framework!"
            echo ""
            exit 0
            ;;
        *)
            echo "Invalid choice, please try again"
            ;;
    esac
    
    echo ""
    read -p "Press Enter to continue..."
    clear
done

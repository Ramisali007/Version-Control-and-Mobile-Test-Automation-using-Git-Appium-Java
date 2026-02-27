# Contributing to Mobile Test Automation Framework

Thank you for contributing to this project! This document provides guidelines for contributing.

## Getting Started

1. **Fork the repository**
2. **Clone your fork**
   ```bash
   git clone https://github.com/your-username/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
   ```
3. **Add upstream remote**
   ```bash
   git remote add upstream https://github.com/Ramisali007/Version-Control-and-Mobile-Test-Automation-using-Git-Appium-Java.git
   ```

## Development Workflow

### 1. Create a Branch
```bash
git checkout -b feature/your-feature-name
```

### 2. Make Changes
- Write clean, readable code
- Follow Java naming conventions
- Add comments for complex logic
- Follow Page Object Model pattern

### 3. Write Tests
- Add test cases for new features
- Ensure existing tests pass
- Aim for good test coverage

### 4. Commit Your Changes
```bash
git add .
git commit -m "feat: your feature description"
```

### 5. Push to Your Fork
```bash
git push origin feature/your-feature-name
```

### 6. Create Pull Request
- Provide clear description
- Reference related issues
- Add screenshots if applicable
- Request review from team members

## Code Style Guidelines

### Java Code Style
```java
// Class names: PascalCase
public class CalculatorPage extends BasePage {
    
    // Method names: camelCase
    public void clickAddButton() {
        // Implementation
    }
    
    // Constants: UPPER_SNAKE_CASE
    private static final String APP_PACKAGE = "com.example.app";
    
    // Variables: camelCase
    private WebElement submitButton;
}
```

### Test Method Naming
```java
@Test
public void testAdditionOperation() {
    // Test implementation
}
```

### Comments
```java
/**
 * Performs addition operation
 * @param num1 First number
 * @param num2 Second number
 * @return Result as string
 */
public String performAddition(String num1, String num2) {
    // Implementation
}
```

## Testing Guidelines

### Test Structure
```java
@Test
public void testFeature() {
    // Arrange - Setup test data
    
    // Act - Perform action
    
    // Assert - Verify results
}
```

### Assertions
```java
// Use descriptive assertion messages
Assert.assertEquals(actual, expected, "Addition result should be correct");
Assert.assertTrue(condition, "Element should be displayed");
```

## Pull Request Checklist

Before submitting PR, ensure:

- [ ] Code compiles without errors
- [ ] All existing tests pass
- [ ] New tests added for new features
- [ ] Code follows style guidelines
- [ ] Comments added for complex logic
- [ ] README updated if needed
- [ ] No sensitive data committed
- [ ] Branch is up to date with develop

## Commit Message Format

```
<type>: <subject>

<body>

<footer>
```

### Types
- `feat` - New feature
- `fix` - Bug fix
- `docs` - Documentation
- `test` - Testing
- `refactor` - Code refactoring
- `ci` - CI/CD changes

### Examples
```
feat: add logout functionality

Implemented logout feature with proper session cleanup
and navigation to login page.

Closes #45
```

## Reporting Issues

### Bug Reports
Include:
- Description of the bug
- Steps to reproduce
- Expected behavior
- Actual behavior
- Screenshots if applicable
- Environment details

### Feature Requests
Include:
- Description of feature
- Use case
- Proposed solution
- Benefits

## Code Review Process

1. **Automatic Checks**
   - CI pipeline runs
   - Build verification
   - Test execution

2. **Manual Review**
   - Code quality
   - Test coverage
   - Documentation
   - Best practices

3. **Approval**
   - Minimum 1 approval required
   - All comments resolved
   - CI checks passing

4. **Merge**
   - Squash and merge
   - Delete branch

## Questions?

Contact the team members or open an issue for discussion.

---

**Happy Contributing!** 🚀

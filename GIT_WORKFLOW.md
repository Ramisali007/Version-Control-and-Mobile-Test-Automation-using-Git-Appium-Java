# Git Workflow Guide

## Branching Strategy

### Main Branches
- `main` - Production-ready code only
- `develop` - Integration branch for features

### Feature Branches
- Format: `feature/feature-name`
- Examples: `feature/calculator-tests`, `feature/login-page`

### Workflow Steps

#### 1. Starting a New Feature
```bash
# Update your local repository
git checkout develop
git pull origin develop

# Create feature branch
git checkout -b feature/your-feature-name
```

#### 2. Making Changes
```bash
# Make your changes in code

# Check status
git status

# Stage changes
git add .

# Commit with meaningful message
git commit -m "feat: add calculator test cases"
```

#### 3. Pushing to Remote
```bash
# Push feature branch
git push origin feature/your-feature-name
```

#### 4. Creating Pull Request
1. Go to GitHub repository
2. Click "New Pull Request"
3. Select your feature branch
4. Add description and reviewers
5. Link related issues
6. Submit PR

#### 5. Code Review Process
- Wait for team member to review
- Address review comments
- Make requested changes
- Push updates to same branch

#### 6. Merging
```bash
# After PR approval, squash and merge on GitHub
# Delete remote branch after merge

# Update local repository
git checkout develop
git pull origin develop

# Delete local feature branch
git branch -d feature/your-feature-name
```

## Commit Message Convention

### Format
```
<type>: <subject>

[optional body]

[optional footer]
```

### Types
- `feat` - New feature
- `fix` - Bug fix
- `docs` - Documentation changes
- `test` - Adding tests
- `refactor` - Code refactoring
- `style` - Code formatting
- `ci` - CI/CD changes
- `chore` - Build/config changes

### Examples
```bash
feat: add multiplication test case
fix: resolve element locator issue
docs: update setup instructions in README
test: add boundary test cases
ci: configure GitHub Actions workflow
```

## Branch Protection Rules

### For `main` branch:
- ❌ No direct commits
- ✅ Require pull request reviews (minimum 1)
- ✅ Require status checks to pass
- ✅ Require branches to be up to date
- ✅ Include administrators

### For `develop` branch:
- ✅ Require pull request reviews
- ✅ Require status checks to pass

## Best Practices

1. **Small, Focused Commits**
   - One logical change per commit
   - Clear, descriptive messages

2. **Regular Pulls**
   ```bash
   git pull origin develop
   ```

3. **Resolve Conflicts Promptly**
   ```bash
   git merge develop
   # Resolve conflicts
   git add .
   git commit -m "merge: resolve conflicts with develop"
   ```

4. **Keep Branches Short-Lived**
   - Complete features quickly
   - Merge frequently

5. **Clean History**
   ```bash
   # Rebase before PR (optional)
   git rebase develop
   ```

## GitHub Issues Workflow

### Creating Issues
1. Navigate to Issues tab
2. Click "New Issue"
3. Use descriptive title
4. Add detailed description
5. Assign appropriate labels
6. Assign to team member

### Issue Labels
- `bug` - Something isn't working
- `feature` - New feature request
- `documentation` - Documentation improvements
- `test` - Test related tasks
- `enhancement` - Improvement to existing feature

### Linking Issues to PRs
In PR description or commit message:
```
Closes #123
Fixes #456
```

## Team Collaboration

### Daily Workflow
1. Update local repository
2. Check assigned issues
3. Create feature branch
4. Implement changes
5. Write tests
6. Commit and push
7. Create PR
8. Review team member's PRs
9. Merge after approval

### Code Review Guidelines
- Review code thoroughly
- Provide constructive feedback
- Check for:
  - Code quality
  - Test coverage
  - Documentation
  - Naming conventions
  - Best practices

---

**Last Updated:** February 2026

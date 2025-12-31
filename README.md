# Selenium Java Docker GHA Framework

A **production-grade Selenium automation framework** built using **Java, TestNG, Selenium Grid, Docker, and GitHub Actions**, designed for **scalable, cross-browser, CI/CD-ready** test execution.

This framework demonstrates **clean architecture**, **industry-standard design patterns**, and **real-world automation practices** used in modern QA engineering teams.

---

## 📌 Key Features & Highlights

✅ **Page Object Model (POM)** for clean and maintainable test design  
✅ **Strategy Pattern** to remove conditional logic and support extensibility  
✅ **Factory Pattern** for runtime decision-making  
✅ **Selenium Grid (Dockerized)** for parallel & distributed execution  
✅ **Cross-browser testing** using GitHub Actions Matrix  
✅ **Parallel execution** with TestNG  
✅ **Extent Reports** for rich HTML reporting  
✅ **Data-driven testing** (CSV & Excel utilities)  
✅ **Environment-agnostic configuration resolution**  
✅ **Tests fully decoupled from Grid infrastructure**  
✅ **CI-ready & production-like setup**

---

## 🧱 High-Level Architecture

GitHub Actions (Matrix: Chrome / Firefox) -->  Test Docker Image (Selenium + TestNG Tests) --> Selenium Grid (Hub + Scaled Browser Nodes)(Docker Compose)



---

## 🧩 Design Patterns Used

### 1️⃣ Page Object Model (POM)

Each application page is represented by its own class, encapsulating locators and behaviors.

**Examples from this project:**
- `RegistrationPage`
- `FlightSearchPage`
- `FlightConfirmationPage`

**Benefits:**
- Clean separation of concerns
- High readability
- Easy maintenance & scalability

---

### 2️⃣ Strategy Pattern

Used to dynamically switch behavior at runtime **without if/else chains**.

Applied for:
- Browser selection (Chrome / Firefox / Edge)
- Execution mode (Local / Remote)
- Test selection logic

**Core interfaces:**
- `BrowserStrategy`
- `ExecutionStrategy`
- `TestSelectionStrategy`

---

### 3️⃣ Factory Pattern

Factories decide **which implementation to use at runtime** based on configuration.

**Examples:**
- `BrowserStrategyFactory`
- `ExecutionStrategyFactory`
- `TestSelectionStrategyFactory`
- `DriverFactory`

---

## ⚙️ Configuration Management (Production-Grade)

Configuration values are resolved in the following priority order:

1. **CI / Environment Variables**
2. **JVM System Properties (`-D`)**
3. **config.properties**
4. **Default values**

✔ Works seamlessly across **local, Docker, and GitHub Actions**  
✔ No code changes required between environments

---

## 📊 Reporting – Extent Reports

Rich HTML reports with:
- Test status
- Categories
- Authors

Reports are:
- Generated after every test run
- Mounted via Docker volumes
- Uploaded as **GitHub Actions artifacts**

---

## 📂 Data-Driven Testing

Utility support for reading test data from:
- 📄 **CSV files**
- 📊 **Excel (.xlsx)**

**Use cases:**
- Parameterized tests
- Externalized test inputs
- Easy maintenance for large datasets

---

## 🧪 Parallel Execution (TestNG)

- Parallel execution enabled at **method / suite level**
- Thread count configurable via:
    - CI variables
    - JVM arguments
    - Config file

---

## 🌐 Cross-Browser Testing (GitHub Actions Matrix)

Cross-browser execution is achieved using **GitHub Actions matrix strategy**:

```yaml
strategy:
  matrix:
    browser: [chrome, firefox]
```
---

### 🌐 Cross-Browser Execution Behavior

Each browser runs:

- **In isolation**
- **Using the same test Docker image**
- **Against dynamically scaled Selenium Grid nodes**

---

## 🐳 Selenium Grid – Dockerized Infrastructure

### Grid Design

- **Selenium Hub**
- **Chrome & Firefox Nodes**
- **Official Selenium Docker images**

### ⚠️ Important Design Choice

Browser services are defined with **zero replicas by default** and are **scaled dynamically at runtime**.

```yaml
deploy:
  replicas: 0
```

This ensures:

- No unused browser nodes

- Optimal resource utilization

- Full control via CI/CD pipelines


---

## ▶️ Running the Framework

### 🔹 Local / Docker Execution

#### Start Selenium Grid with Dynamic Scaling

**Chrome nodes**
```bash
docker-compose -f grid.yaml up --scale chrome=2 -d
```

**Firefox nodes**
```bash
docker-compose -f grid.yaml up --scale firefox=2 -d
```
---

**Run Tests by Passing Browser Explicitly**

**Chrome**

```
BROWSER=chrome docker-compose -f test-suite.yaml up
```

**Firefox**
```
BROWSER=firefox docker-compose -f test-suite.yaml up
```

## 🔹 GitHub Actions (Automated CI)

#### In GitHub Actions, cross-browser execution is driven using a matrix strategy.

### Matrix-Driven Execution
```
docker-compose -f grid.yaml up --scale ${{ matrix.browser }}=2 -d
BROWSER=${{ matrix.browser }} docker-compose -f test-suite.yaml up
```

### ✅ Key Benefits

- Grid scales dynamically per browser

- Same test Docker image reused

- Fully automated cross-browser execution

---

## ⏰ Scheduled Test Execution

This framework supports **cron-based automation** using **GitHub Actions** for unattended test execution.

### Example: Run Every Monday at **05:00 UTC**

```yaml
schedule:
  - cron: "0 5 * * 1"
```

This ensures the test suite runs once every week, automatically, without any manual trigger.

---

## 🔌 Test & Infrastructure Separation

### Design Principles

- Tests do not manage Selenium Grid lifecycle

- Grid can scale independently

- Same test Docker image works locally and in CI

This separation ensures that:

- Test logic remains clean and focused

- Infrastructure can be reused or scaled without touching tests

- The same setup behaves consistently across local, Docker, and CI/CD environments

This mirrors real-world production test setups used in mature QA platforms.

---

## 🔁 Retry Logic for Failed Tests

The framework includes a retry mechanism to automatically re-run failed test cases.

### Key Highlights

- Retry enabled using TestNG retry analyzer

- Helps mitigate flaky test failures

- Retry count configurable via framework settings

- Only failed tests are retried (not successful ones)

### Benefits:

- Improved test stability

- Reduced false negatives in CI

- More reliable pipeline results

---

## 🧠 Why This Framework Is Production-Ready

- **Clean architecture** with clear responsibility boundaries

- **Loose coupling** via strategy & factory patterns

- **No hard-coded** **environment assumptions**

- **Docker-first** approach for reproducibility

- **CI/CD friendly** with GitHub Actions integration

- **Scalable & maintainable** test execution model

- **Cross-browser & parallel execution** out of the box

This framework is designed not just to run tests, but to **scale with teams and pipelines.**

---

## 👨‍💻 Author

---

### Nitish Kumar Jha
#### Automation | Selenium | Docker | CI/CD | Jav
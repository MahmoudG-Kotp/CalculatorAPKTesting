# Mobile Calculator App Testing

This project automates testing for a calculator app using Appium and the Robot Framework, following the Page Object Model (POM) design pattern for better test organization and maintainability.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Test Cases](#test-cases)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Output](#output)

## Project Overview

The Mobile Calculator App features three activities:

1. **Login Activity**: User authentication.
2. **Calculator Activity**: Performing arithmetic operations.
3. **Calculations History Activity**: Viewing and managing calculation history.

## Technologies Used

- [Appium](http://appium.io/): For automating mobile applications.
- [Robot Framework](https://robotframework.org/): A generic automation framework.
- [Java](https://www.java.com/): The programming language used for test development.
- [Android Studio AVD](https://developer.android.com/studio/run/emulator): For running the Android emulator.

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/mobile-calculator-testing.git
2. Follow the [Robot Framework and Appium setup guide to configure your environment](https://www.pentalog.com/blog/mobile-development/mobile-automation-with-robot-framework-and-appium/).


# Test Cases

### Invalid Login
- **Test Case 1:** Login should fail with:
  - Wrong credentials
  - Empty credentials

### Valid Login
- **Test Case 2:** Successful login with:
  - **Username:** admin
  - **Password:** 1234

### Arithmetic Operations
- **Test Case 3:** Validate addition and multiplication results.

### Clear Functionality
- **Test Case 4:** Ensure the clear button resets the display.

### History Access
- **Test Case 5:** Verify the History button opens the calculations history.

### History Deletion
- **Test Case 6:** Confirm deletion of checked calculations from history.

# Project Structure
mobile-calculator-testing/
│
├── src/
│   ├── main/
│   │   └── ...
│   └── test/
│       ├── resources/
│       ├── tests/
│       └── page_objects/
│           ├── login_page.py
│           ├── calculator_page.py
│           └── history_page.py
└── README.md

# Contributing
Contributions are welcome! Please feel free to submit a pull request.

# License
This project is licensed under the MIT License - see the LICENSE file for details.

# Instructions for Use
- Make sure to replace `https://github.com/yourusername/mobile-calculator-testing.git` with your actual repository URL.
- Modify any sections as needed, especially the project structure, based on your actual implementation.
- Update the contributing guidelines and licensing information if necessary.

Feel free to copy and paste this directly into your README file! Let me know if you need any further modifications.

### Key Points:
- Each test case is separated into its own subsection for clarity.
- The overall structure remains organized and easy to navigate.

If you need additional changes or another format, let me know!

# [Output](https://drive.google.com/file/d/166n6GIjZQDvpF33qN0tKLFlqIOHo5oL7/view?usp=sharing)🔗👆
![RunRecord-ezgif](https://github.com/user-attachments/assets/4229bcb8-d990-46cd-9399-c0b1bbe306a2)


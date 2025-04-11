# JUnit Automation Assignment

## Reports
- **Task 1**: https://drive.google.com/file/d/1RjIdYPTE50OI4ygQuw2VAKQZYm-pcHeZ/view?usp=sharing
- **Task 2**: https://drive.google.com/file/d/1AaFMXAIN_6BbgZWGHxbF8a2OPSFAyPCn/view?usp=sharing

## Overview
This project contains automation scripts to perform the following tasks:

1. Automate a web form submission at [Digital Unite Practice Webform](https://www.digitalunite.com/practice-webform-learners).
2. Automate a guest registration form submission at [WP Everest Guest Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form/).
---

## Automation Details

### Task 1: Automate Digital Unite Practice Webform
- **URL**: https://www.digitalunite.com/practice-webform-learners
- **Steps for Automation**:
  1. Input all fields in the web form.
  2. Upload a file (2MB limit).
  3. Click the submit button.
  4. Assert that the success message is: `Thank you for your submission!`

### Task 2: Automate WP Everest Guest Registration Form
- **URL**: https://demo.wpeverest.com/user-registration/guest-registration-form/
- **Steps for Automation**:
  1. Input the following fields:
      - First Name
      - Last Name
      - User Email
      - Gender
      - Password
      - Date of Birth
      - Nationality
      - Phone
      - Country: `Bangladesh`
      - Agree to Terms & Conditions
  2. Click the submit button.
  3. Assert that the registration is successful.


## Tools & Technologies

- **JUnit**: Framework for writing and executing tests.
- **Selenium WebDriver**: For browser automation.
- **Java**: Programming language.
- **GitHub**: Code hosting platform.

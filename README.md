# Project Overview

The aim of this project is to design and deliver a CI/CD pipeline that automates the build, test and deploying of a Java application.

## Pipeline

The automation tool selected for this project is the open-source and popular automation server, Jenkins. For effective collaboration and access to Jenkins for all team members, Jenkins is setup in an instance of Amazon Web Service (AWS). From the cloud, all members can access Jenkins to make configuration changes, monitor builds and analyse output. This project’s pipeline uses plugins that integrate Git, GitHub and JaCoCo into the system.

## Application Code

The Maven Java application used in this project is one that models an employee payroll system. The code was written using Test Driven Development methodology and designed using SOLID programming principles. The code contains service code to mimic the payroll system and over 90% of the code is covered by unit and integration tests.

The application’s features allow a user to:

- Register an employee

- Delete an employee

- Retrieve an employee’s details

- Update an employee’s details

- Retrieve a list of employees on the payroll system

- Calculate employee bonuses

- Calculate and make tax deductions from employee income payments

The classes included in the project are a controller class, service classes, classes representing various types of employee objects, a mock database class and database service class.

## Project Automation

Within this project, Jenkins is configured to trigger a build of the project source when a change is made to the master code base. This code base is in a public repository on GitHub. This remote GitHub repository is configured to send a request to the Jenkins server using a webhook. Once master is updated, the webhook is sent, the Jenkins build is triggered, and the output of the build is displayed in the Jenkins dashboard. The Maven artefact is stored in a private repo in AWS S3. In this case, the output of this build is the Maven artefact and a JaCoCo code coverage report.

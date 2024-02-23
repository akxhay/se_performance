# SE Performance Dashboard

SE Performance Dashboard is a Spring Boot web application designed to provide a user-friendly interface for monitoring and analyzing the performance of sales engineers (SEs).

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction
This project utilizes the Spring Boot framework to create a dashboard that visualizes the performance metrics of sales engineers. It allows users to log in, view performance details, and analyze data through an intuitive web interface.

## Prerequisites
Before running this application, ensure that you have the following prerequisites installed:
- Java Development Kit (JDK) 17 or higher
- Apache Maven

## Installation
1. Clone this repository to your local machine using `git clone`.
2. Navigate to the project directory.
3. Customize the `application.properties` file with your MySQL database configurations and CSV file path.
4. Run `mvn clean install` to build the project and download dependencies.

## Configuration
The `application.properties` file contains configurations for the application. You can customize the following properties:
- `server.port`: The port on which the application runs (default: 8888).
- `csv.file.path`: The path to the CSV file containing performance data.
- Database configurations for H2 database and mapping column indices.

## Usage
1. Start your MySQL server.
2. Run the application using `mvn spring-boot:run` or by executing the generated JAR file.
3. Open your web browser and go to `http://localhost:8888` (or the configured port) to access the application.
4. Log in with the provided credentials and explore the dashboard to view performance metrics and analyze data.

## Contributing
Contributions are welcome! If you have any suggestions, enhancements, or bug fixes, please feel free to submit a pull request.

## License
This project is licensed under the [MIT License](LICENSE).

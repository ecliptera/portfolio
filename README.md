# Portfolio

<details>
    <summary>
        <strong>Table of contents</strong>
    </summary>
    <ul>
        <li>
            <a href="#description">Description</a>
            <ul>
                <li><a href="#built-with">Built with</a></li>
                <li><a href="#integrated-with">Integrated with</a></li>
            </ul>
        </li>
        <li>
            <a href="#getting-started">Getting started</a>
            <ul>
                <li><a href="#installation">Installation</a></li>
                <li><a href="#set-up">Set up</a></li>
            </ul>
        </li>
        <li><a href="#usage">Usage</a></li>
    </ul>
</details>

## Description

Portfolio is a static site built with the MVC pattern. 
It integrates with GitHub to dynamically display your current public projects and features a caching mechanism to avoid rate-limiting issues.
The result is a streamlined and up-to-date showcase of my work with minimal interruptions.

### Built with

- [Spring](https://spring.io)

### Integrated with

- [Hub4j](https://github-api.kohsuke.org/)
- [Caffeine](https://github.com/ben-manes/caffeine)

## Getting started

### Installation

To install the application

1. Navigate to the root of this project.
2. Run the command:
    ```bash
    ./mvnw clean install
    ```

### Set up

To set up the application locally

- Set the following environment variables:

  | Variable         | Example | Info                               |
  |------------------|---------|------------------------------------|
  | GITHUB_OAUTH     | *****   | A personal access token for GitHub |


## Usage

To run the application

- Run the command:
    ```bash
    ./mvnw clean package
    java -jar target/portfolio-{version}.jar
    ```
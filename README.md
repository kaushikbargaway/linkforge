# LinkForge – URL Shortening & Analytics Platform

LinkForge is a backend URL shortening and analytics platform built using Java, Spring Boot, MySQL, Spring Data JPA, and Hibernate. It provides URL shortening, custom aliases, click analytics, and RESTful APIs designed using a layered architecture.

## Features

* Generate short URLs from long URLs
* Create custom aliases for shortened URLs
* Redirect users using shortened URLs
* Store URLs in a MySQL database
* Track click counts for every shortened URL
* Retrieve analytics for shortened URLs
* Prevent duplicate custom aliases
* RESTful API architecture

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman (API Testing)

## API Endpoints

### Create Short URL

**POST** `/api/shorten`

Request (Random Short Code)

```json
{
  "url": "https://leetcode.com"
}
```

Request (Custom Alias)

```json
{
  "url": "https://leetcode.com",
  "customAlias": "leetcode"
}
```

Response

```json
{
  "shortUrl": "http://localhost:8080/leetcode"
}
```

---

### Redirect URL

**GET** `/{shortCode}`

Example

```text
http://localhost:8080/leetcode
```

---

### URL Analytics

**GET** `/api/stats/{shortCode}`

Example

```text
http://localhost:8080/api/stats/leetcode
```

## Database

Database Name

```sql
url_shortener
```

Table

```sql
urls
```

The table is generated automatically using Spring Data JPA.

## Project Structure

```text
src
└── main
    └── java
        └── com.kaushik.urlshortener
            ├── controller
            ├── dto
            ├── entity
            ├── repository
            └── service
```

## Getting Started

1. Clone the repository.
2. Create the database:

```sql
CREATE DATABASE url_shortener;
```

3. Configure `application.properties` with your MySQL credentials.
4. Run the application:

```bash
./mvnw spring-boot:run
```

5. Test the APIs using Postman.

## Current Features (v1.1.0)

* URL Shortening
* Custom Alias Support
* URL Redirection
* Click Tracking
* Analytics API
* Duplicate Alias Validation
* MySQL Persistence

## Known Limitation

Currently, attempting to create an existing custom alias returns an HTTP **500 Internal Server Error** because global exception handling has not yet been implemented. This will be addressed in **v1.2.0**.

## Planned Enhancements

* Global Exception Handling
* URL Expiration
* Dashboard UI
* User Authentication (Spring Security + JWT)
* Cloud Deployment
* QR Code Generation
* Docker Support

## Author

Kaushik Kumar
B.E. Information Science & Engineering
BNM Institute of Technology

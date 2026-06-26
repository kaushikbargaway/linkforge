# LinkForge – URL Shortening & Analytics Platform

LinkForge is a backend URL shortening and analytics platform built using Java, Spring Boot, MySQL, Spring Data JPA, and Hibernate. It provides URL shortening, custom aliases, URL expiration, click analytics, standardized error handling, and RESTful APIs using a layered architecture.

## Features

* Generate short URLs from long URLs
* Create custom aliases for shortened URLs
* Set optional expiration dates for shortened URLs
* Redirect users using shortened URLs
* Store URLs in a MySQL database
* Track click counts for every shortened URL
* Retrieve analytics for shortened URLs
* Prevent duplicate custom aliases
* Global exception handling with standardized API responses
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

#### Request (Random Short Code)

```json
{
  "url": "https://leetcode.com"
}
```

#### Request (Custom Alias)

```json
{
  "url": "https://leetcode.com",
  "customAlias": "leetcode"
}
```

#### Request (URL Expiration)

```json
{
  "url": "https://leetcode.com",
  "customAlias": "leetcode",
  "expiryDate": "2026-12-31T23:59:59"
}
```

#### Success Response

```json
{
  "shortUrl": "http://localhost:8080/leetcode"
}
```

---

### Redirect URL

**GET** `/{shortCode}`

Example:

```text
http://localhost:8080/leetcode
```

---

### URL Analytics

**GET** `/api/stats/{shortCode}`

Example:

```text
http://localhost:8080/api/stats/leetcode
```

---

### Error Response Examples

#### Duplicate Alias

```http
HTTP/1.1 409 Conflict
```

```json
{
  "timestamp": "2026-06-26T11:15:30",
  "status": 409,
  "error": "Conflict",
  "message": "Alias already exists"
}
```

#### URL Not Found

```http
HTTP/1.1 404 Not Found
```

```json
{
  "timestamp": "2026-06-26T11:20:00",
  "status": 404,
  "error": "Not Found",
  "message": "URL not found"
}
```

#### URL Expired

```http
HTTP/1.1 410 Gone
```

```json
{
  "timestamp": "2026-06-26T11:30:00",
  "status": 410,
  "error": "Gone",
  "message": "URL has expired"
}
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
            ├── exception
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

## Current Features (v1.3.0)

* URL Shortening
* Custom Alias Support
* URL Expiration
* URL Redirection
* Click Tracking
* Analytics API
* Duplicate Alias Validation
* Global Exception Handling
* Custom Exception Classes
* Standardized Error Responses
* MySQL Persistence

## Planned Enhancements

* Dashboard UI
* User Authentication (Spring Security + JWT)
* Cloud Deployment
* QR Code Generation
* Docker Support

## Author

**Kaushik Kumar**<br>
B.E. Information Science & Engineering<br>
BNM Institute of Technology

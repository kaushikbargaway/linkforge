# LinkForge – URL Shortening & Analytics Platform

LinkForge is a backend URL shortening and analytics platform built using Java, Spring Boot, MySQL, and Spring Data JPA.

## Features

* Generate short URLs from long URLs
* Redirect users using short URLs
* Store URLs in MySQL database
* Track click counts
* URL analytics endpoint
* RESTful API architecture

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok

## API Endpoints

### Create Short URL

**POST** `/api/shorten`

Request:

```json
{
  "url": "https://leetcode.com"
}
```

Response:

```json
{
  "shortUrl": "http://localhost:8080/0cd238"
}
```

### Redirect URL

**GET** `/{shortCode}`

Example:

```text
http://localhost:8080/0cd238
```

### Analytics

**GET** `/api/stats/{shortCode}`

Example:

```text
http://localhost:8080/api/stats/0cd238
```

## Database

Database:

```sql
url_shortener
```

Table:

```sql
urls
```

Generated automatically using Spring Data JPA.

## Project Structure

```text
controller/
service/
repository/
entity/
dto/
```

## Current Features (v1.0)

* URL Shortening
* Redirect Service
* Click Tracking
* Analytics API
* MySQL Persistence

## Planned Enhancements

* Custom Aliases
* URL Expiration
* Dashboard UI
* User Authentication (JWT)
* Cloud Deployment

## Author

Kaushik Kumar<br>
B.E. Information Science & Engineering<br>
BNM Institute of Technology

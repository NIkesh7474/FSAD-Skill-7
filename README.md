# Skill-7: REST API - CRUD Operations using ResponseEntity

| Field   | Details                                             |
|---------|-----------------------------------------------------|
| Student | Ch. Venkata Sai Nikesh                              |
| ID      | 2400080138                                          |
| Section | 51                                                  |
| GitHub  | https://github.com/NIkesh7474/FSAD-Skill-7          |

---

## Aim

To implement a complete REST API with full CRUD operations
for a university course management system using Spring Boot,
with ResponseEntity returning proper HTTP status codes.

---

## What is This Project?

This project is a Spring Boot REST API that manages
university courses with fields: courseId, title, duration, fee.

5 courses are pre-loaded in memory using HashMap.
No database needed. Data resets when app restarts.

**3 Layers:**
- `Course.java`          - Data model (POJO)
- `CourseService.java`   - Business logic with HashMap
- `CourseController.java` - REST endpoints with ResponseEntity

---

## Key Annotations

| Annotation      | Purpose                                  |
|-----------------|------------------------------------------|
| @RestController | Marks class as REST API controller       |
| @RequestMapping | Sets base URL for all endpoints          |
| @GetMapping     | Handles HTTP GET requests                |
| @PostMapping    | Handles HTTP POST requests               |
| @PutMapping     | Handles HTTP PUT update requests         |
| @DeleteMapping  | Handles HTTP DELETE requests             |
| @PathVariable   | Reads value from the URL path            |
| @RequestBody    | Reads JSON from request body             |
| ResponseEntity  | Returns data with HTTP status code       |

---

## Project Structure
```
FullStack-Skill-7/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/fsad/restcrud/
│       │       ├── Course.java
│       │       ├── CourseService.java
│       │       ├── CourseController.java
│       │       └── CourseRestApiApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## Tech Stack

| Technology  | Version  | Purpose                   |
|-------------|----------|---------------------------|
| Java        | 17       | Programming language       |
| Spring Boot | 3.2.0    | Auto-configuration         |
| Spring MVC  | 6.x      | REST controller handling   |
| HashMap     | Built-in | In-memory data storage     |
| Maven       | 3.x      | Build and dependency tool  |
| Postman     | -        | API testing tool           |

---

## All Endpoints

| Method | Endpoint                | Success | Error | Description     |
|--------|-------------------------|---------|-------|-----------------|
| GET    | /courses                | 200 OK  | -     | Get all courses |
| GET    | /courses/{id}           | 200 OK  | 404   | Get by ID       |
| POST   | /courses                | 201     | 400   | Add new course  |
| PUT    | /courses/{id}           | 200 OK  | 404   | Update course   |
| DELETE | /courses/{id}           | 200 OK  | 404   | Delete course   |
| GET    | /courses/search/{title} | 200 OK  | 404   | Search by title |

---

## Expected Postman Output

### POST /courses - Add Course (201 Created)
```json
{
  "courseId": 6,
  "title": "Machine Learning",
  "duration": 14,
  "fee": 22000.0
}
```
**Response:** `"Course added: Machine Learning"`

---

### POST /courses - Missing Title (400 Bad Request)
```json
{
  "courseId": 7,
  "title": "",
  "duration": 8,
  "fee": 5000.0
}
```
**Response:** `"Title is required"`

---

### GET /courses - All Courses (200 OK)
```json
[
  {"courseId":1,"title":"Java Full Stack","duration":12,"fee":15000.0},
  {"courseId":2,"title":"Spring Boot REST","duration":8,"fee":12000.0},
  {"courseId":3,"title":"React Frontend","duration":6,"fee":9000.0},
  {"courseId":4,"title":"Cloud Computing","duration":10,"fee":18000.0},
  {"courseId":5,"title":"Data Structures","duration":4,"fee":6000.0}
]
```

---

### GET /courses/3 - Valid ID (200 OK)
```json
{"courseId":3,"title":"React Frontend","duration":6,"fee":9000.0}
```

---

### GET /courses/99 - Invalid ID (404 Not Found)
**Response:** `"Course not found with id: 99"`

---

### PUT /courses/2 - Update Course (200 OK)
```json
{"title":"Advanced Spring Boot","duration":10,"fee":14000.0}
```
**Response:** `"Course updated: Advanced Spring Boot"`

---

### DELETE /courses/5 - Delete (200 OK)
**Response:** `"Course deleted with id: 5"`

---

### DELETE /courses/99 - Invalid Delete (404 Not Found)
**Response:** `"Course not found with id: 99"`

---

### GET /courses/search/Spring - Search (200 OK)
```json
[{"courseId":2,"title":"Advanced Spring Boot","duration":10,"fee":14000.0}]
```

---

## How to Run

**Step 1** - Open Eclipse

**Step 2** - Import project
```
File -> Import -> Maven -> Existing Maven Projects -> Finish
```

**Step 3** - Run the app
```
Right click project -> Run As -> Maven build...
Goal: spring-boot:run -> Click Run
```

**Step 4** - App starts at `http://localhost:8080`

**Step 5** - Test with Postman using endpoints above

---

## Tasks Completed

- [x] Task 1 - Course POJO with courseId, title, duration, fee
- [x] Task 2 - CourseService with HashMap CRUD operations
- [x] Task 3 - CourseController with 6 REST endpoints
- [x] Task 4 - ResponseEntity with 200, 201, 404, 400 codes
- [x] Task 5 - Search endpoint /courses/search/{title}
- [x] Task 6 - All 9 test cases verified in Postman
- [x] Task 7 - Project pushed to GitHub

---

## Git Commands
```cmd
cd C:\Users\HP\Downloads\FullStack-Skill-7\FullStack-Skill-7

git init
git add .
git commit -m "Skill7: REST CRUD with ResponseEntity - CourseAPI"
git remote add origin https://github.com/NIkesh7474/FSAD-Skill-7
git branch -M main
git push -u origin main --force
```

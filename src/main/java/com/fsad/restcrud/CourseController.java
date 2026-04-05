package com.fsad.restcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // GET all courses -- 200 OK
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // GET by ID -- 200 OK or 404 NOT_FOUND
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return service.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    // POST add course -- 201 CREATED or 400 BAD_REQUEST
    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course c) {
        if (c.getTitle() == null || c.getTitle().isEmpty())
            return ResponseEntity.badRequest().body("Title is required");
        service.addCourse(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Course added: " + c.getTitle());
    }

    // PUT update -- 200 OK or 404 NOT_FOUND
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody Course c) {
        return service.updateCourse(id, c)
                .map(updated -> ResponseEntity.ok("Course updated: " + updated.getTitle()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Course not found with id: " + id));
    }

    // DELETE -- 200 OK or 404 NOT_FOUND
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (service.deleteCourse(id))
            return ResponseEntity.ok("Course deleted with id: " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found with id: " + id);
    }

    // Task 5 -- Search by title (case-insensitive)
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        List<Course> result = service.searchByTitle(title);
        if (result.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        return ResponseEntity.ok(result);
    }
}

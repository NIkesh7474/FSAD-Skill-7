package com.fsad.restcrud;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseService {

    private Map<Integer, Course> courseMap = new HashMap<>();

    public CourseService() {
        // Pre-loaded data
        courseMap.put(1, new Course(1, "Java Full Stack",  12, 15000.0));
        courseMap.put(2, new Course(2, "Spring Boot REST",  8, 12000.0));
        courseMap.put(3, new Course(3, "React Frontend",    6,  9000.0));
        courseMap.put(4, new Course(4, "Cloud Computing",  10, 18000.0));
        courseMap.put(5, new Course(5, "Data Structures",   4,  6000.0));
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public Optional<Course> getCourseById(int id) {
        return Optional.ofNullable(courseMap.get(id));
    }

    public Course addCourse(Course c) {
        courseMap.put(c.getCourseId(), c);
        return c;
    }

    public Optional<Course> updateCourse(int id, Course c) {
        if (!courseMap.containsKey(id)) return Optional.empty();
        c.setCourseId(id);
        courseMap.put(id, c);
        return Optional.of(c);
    }

    public boolean deleteCourse(int id) {
        if (!courseMap.containsKey(id)) return false;
        courseMap.remove(id);
        return true;
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseMap.values())
            if (c.getTitle().toLowerCase().contains(title.toLowerCase()))
                result.add(c);
        return result;
    }
}

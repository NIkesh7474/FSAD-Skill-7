package com.fsad.restcrud;

public class Course {

    private int courseId;
    private String title;
    private int duration; // in weeks
    private double fee;

    public Course() {}

    public Course(int courseId, String title, int duration, double fee) {
        this.courseId = courseId;
        this.title    = title;
        this.duration = duration;
        this.fee      = fee;
    }

    // Getters
    public int    getCourseId() { return courseId; }
    public String getTitle()    { return title;    }
    public int    getDuration() { return duration; }
    public double getFee()      { return fee;      }

    // Setters
    public void setCourseId(int id)     { this.courseId = id; }
    public void setTitle(String t)      { this.title    = t;  }
    public void setDuration(int d)      { this.duration = d;  }
    public void setFee(double f)        { this.fee      = f;  }
}

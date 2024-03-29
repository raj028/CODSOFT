package StudentsCource;

import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;
    private List<Student> registeredStudents;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            System.out.println(student.getName() + " has registered for " + title);
        } else {
            System.out.println("Course is full. " + student.getName() + " cannot register for " + title);
        }
    }

    public void removeStudent(Student student) {
        registeredStudents.remove(student);
        System.out.println(student.getName() + " has been removed from " + title);
    }

    public void displayDetails() {
        System.out.println("Course Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: " + schedule);
        System.out.println("Registered Students: " + registeredStudents.size() + "/" + capacity);
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.registerStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }

    public void displayRegisteredCourses() {
        System.out.println("Registered courses for " + name + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create courses
        Course javaCourse = new Course("CS101", "Java Programming", "Introduction to Java programming", 30,
                Arrays.asList("Monday 10:00 AM - 12:00 PM", "Wednesday 10:00 AM - 12:00 PM"));
        Course pythonCourse = new Course("CS102", "Python Programming", "Introduction to Python programming", 25,
                Arrays.asList("Tuesday 1:00 PM - 3:00 PM", "Thursday 1:00 PM - 3:00 PM"));

        // Create students
        Student student1 = new Student(1001, "Alice");
        Student student2 = new Student(1002, "Bob");

        // Register students for courses
        student1.registerCourse(javaCourse);
        student1.registerCourse(pythonCourse);
        student2.registerCourse(javaCourse);

        // Display course details
        javaCourse.displayDetails();
        System.out.println();
        pythonCourse.displayDetails();

        // Display registered courses for each student
        student1.displayRegisteredCourses();
        System.out.println();
        student2.displayRegisteredCourses();

        // Drop a course for a student
        student1.dropCourse(pythonCourse);
        System.out.println();
        student1.displayRegisteredCourses();
    }
}


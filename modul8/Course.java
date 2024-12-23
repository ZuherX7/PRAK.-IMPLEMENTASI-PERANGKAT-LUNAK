import java.util.Enumeration;
import java.util.Vector;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    // Print all students in the course
    public void printCourseStudents() {
        System.out.println("Students enrolled in course: " + title);
        Enumeration<CourseRecord> records = courseRecords.elements();
        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();
            if (student != null) {
                System.out.println("- " + student.getName());
            } else {
                System.out.println("- Unnamed student");
            }
        }
    }

    // Print the student with the best average mark
    public void printBestStudent() {
        double highestAverage = -1;
        Student bestStudent = null;

        Enumeration<CourseRecord> records = courseRecords.elements();
        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Enumeration<Assignment> assignments = cr.getAssignments();
            double totalMarks = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();
                try {
                    totalMarks += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Skip assignments without marks
                }
            }

            if (count > 0) {
                double average = totalMarks / count;
                if (average > highestAverage) {
                    highestAverage = average;
                    bestStudent = cr.getStudent();
                }
            }
        }

        if (bestStudent != null) {
            System.out.println("Best student in course " + title + ": " + bestStudent.getName() + " with an average mark of " + highestAverage);
        } else {
            System.out.println("No marks available to determine the best student.");
        }
    }

    // Print students eligible for the final exam
    public void printFinalExamStudents() {
        System.out.println("Students eligible for the final exam in course: " + title);

        Enumeration<CourseRecord> records = courseRecords.elements();
        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Enumeration<Assignment> assignments = cr.getAssignments();
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();
                try {
                    assignment.getMark(); // Check if the mark is set
                    count++;
                } catch (NotYetSetException e) {
                    // Skip assignments without marks
                }
            }

            if (count > 0) { // At least one assignment has a mark
                Student student = cr.getStudent();
                if (student != null) {
                    System.out.println("- " + student.getName());
                } else {
                    System.out.println("- Unnamed student");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create course
        Course course = new Course();
        course.setTitle("Object-Oriented Programming");

        // Create students
        Student student1 = new Student();
        student1.setName("Alice");

        Student student2 = new Student();
        student2.setName("Bob");

        // Create course records
        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);

        // Create assignments
        Assignment assignment1 = new Assignment();
        assignment1.setMark(85);

        Assignment assignment2 = new Assignment();
        assignment2.setMark(90);

        Assignment assignment3 = new Assignment();
        assignment3.setMark(78);

        Assignment assignment4 = new Assignment();
        assignment4.setMark(88);

        // Add assignments to course records
        record1.addAssignment(assignment1);
        record1.addAssignment(assignment2);

        record2.addAssignment(assignment3);
        record2.addAssignment(assignment4);

        // Add course records to course
        course.addCourseRecord(record1);
        course.addCourseRecord(record2);

        // Print students in the course
        course.printCourseStudents();

        // Print the best student
        course.printBestStudent();

        // Print students eligible for the final exam
        course.printFinalExamStudents();
    }
}

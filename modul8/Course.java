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

    // Cetak semua siswa dalam kursus
    public void printCourseStudents() {
        System.out.println("Siswa yang terdaftar dalam kursus: " + title);
        Enumeration<CourseRecord> records = courseRecords.elements();
        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();
            if (student != null) {
                System.out.println("- " + student.getName());
            } else {
                System.out.println("- Siswa tanpa nama");
            }
        }
    }

    // Cetak siswa dengan nilai rata-rata terbaik
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
                    // Lewati tugas tanpa nilai
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
            System.out.println("Siswa terbaik dalam kursus " + title + ": " + bestStudent.getName() + " dengan nilai rata-rata " + highestAverage);
        } else {
            System.out.println("Tidak ada nilai yang tersedia untuk menentukan siswa terbaik.");
        }
    }

    // Cetak siswa yang memenuhi syarat untuk ujian akhir
    public void printFinalExamStudents() {
        System.out.println("Siswa yang memenuhi syarat untuk ujian akhir dalam kursus: " + title);

        Enumeration<CourseRecord> records = courseRecords.elements();
        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Enumeration<Assignment> assignments = cr.getAssignments();
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();
                try {
                    assignment.getMark(); // Periksa apakah nilai sudah diatur
                    count++;
                } catch (NotYetSetException e) {
                    // Lewati tugas tanpa nilai
                }
            }

            if (count > 0) { // Setidaknya satu tugas memiliki nilai
                Student student = cr.getStudent();
                if (student != null) {
                    System.out.println("- " + student.getName());
                } else {
                    System.out.println("- Siswa tanpa nama");
                }
            }
        }
    }
}

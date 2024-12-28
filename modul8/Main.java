import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course course = new Course();

        System.out.print("Masukkan judul course: ");
        course.setTitle(scanner.nextLine());

        boolean keluar = false;
        while (!keluar) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tambah Tugas untuk Mahasiswa");
            System.out.println("3. Cetak Semua Mahasiswa");
            System.out.println("4. Cetak Mahasiswa Terbaik");
            System.out.println("5. Cetak Mahasiswa yang Berhak Mengikuti Ujian Akhir");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    CourseRecord cr = new CourseRecord();
                    Student student = new Student();

                    System.out.print("Masukkan nama mahasiswa: ");
                    student.setName(scanner.nextLine());
                    cr.setStudent(student);
                    course.addCourseRecord(cr);

                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan nama mahasiswa untuk menambahkan tugas: ");
                    String namaMahasiswa = scanner.nextLine();

                    Enumeration<CourseRecord> records = course.getCourseRecords();
                    boolean ditemukan = false;

                    while (records.hasMoreElements()) {
                        CourseRecord courseRecord = records.nextElement();
                        if (courseRecord.getStudent().getName().equals(namaMahasiswa)) {
                            Assignment assignment = new Assignment();

                            System.out.print("Masukkan nilai tugas (integer): ");
                            int nilai = scanner.nextInt();
                            scanner.nextLine(); // Konsumsi newline

                            assignment.setMark(nilai);
                            courseRecord.addAssignment(assignment);
                            System.out.println("Tugas berhasil ditambahkan.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;

                case 3:
                    course.printCourseStudents();
                    break;

                case 4:
                    course.printBestStudent();
                    break;

                case 5:
                    course.printFinalExamStudents();
                    break;

                case 6:
                    keluar = true;
                    System.out.println("Keluar... Selamat tinggal!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}

// 12S24027_Grasia
package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Kita butuh tiga ArrayList terpisah untuk setiap entitas
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        // Loop untuk membaca input baris per baris
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memisahkan command dari data
            // Split hanya pada '#' pertama, agar data sisa bisa diproses lebih lanjut
            String[] parts = line.split("#", 2); 
            if (parts.length < 2) {
                continue; // Lewati jika format tidak sesuai (tidak ada command dan data)
            }

            String command = parts[0]; // Bagian pertama adalah command (e.g., "course-add")
            String data = parts[1];    // Bagian kedua adalah sisa data (e.g., "12S2203#Object-oriented Programming#3#C")

            switch (command) {
                case "course-add":
                    String[] courseData = data.split("#");
                    if (courseData.length == 4) {
                        String code = courseData[0];
                        String name = courseData[1];
                        int credits = Integer.parseInt(courseData[2]);
                        String grade = courseData[3];
                        courses.add(new Course(code, name, credits, grade));
                    }
                    break;
                case "student-add":
                    String[] studentData = data.split("#");
                    if (studentData.length == 4) {
                        String id = studentData[0];
                        String name = studentData[1];
                        String year = studentData[2];
                        String major = studentData[3];
                        students.add(new Student(id, name, year, major));
                    }
                    break;
                case "enrollment-add":
                    String[] enrollmentData = data.split("#");
                    if (enrollmentData.length == 4) {
                        String courseCode = enrollmentData[0];
                        String studentId = enrollmentData[1];
                        String academicYear = enrollmentData[2];
                        String semester = enrollmentData[3];
                        enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                    }
                    break;
                default:
                    // Jika ada command yang tidak dikenali, bisa diabaikan atau ditangani sesuai kebutuhan
                    break;
            }
        }

        // Setelah semua input diproses, tampilkan semua data sesuai urutan yang diminta:
        // 1. Courses
        for (Course course : courses) {
            System.out.println(course);
        }
        // 2. Students
        for (Student student : students) {
            System.out.println(student);
        }
        // 3. Enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close(); // Tutup scanner
    }
}

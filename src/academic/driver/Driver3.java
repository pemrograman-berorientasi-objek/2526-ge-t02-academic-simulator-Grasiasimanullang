// 12S24027_Grasia
package academic.driver;

import academic.model.Enrollment; // Penting: import kelas Enrollment dari package model
import java.util.Scanner;
import java.util.ArrayList; 

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList untuk menyimpan Enrollment karena jumlahnya dinamis
        ArrayList<Enrollment> enrollments = new ArrayList<>(); 

        // Loop untuk membaca input baris per baris
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Pisahkan string input menggunakan '#'
            String[] enrollmentData = line.split("#");
            if (enrollmentData.length == 4) { // Pastikan ada 4 bagian data
                String courseCode = enrollmentData[0];
                String studentId = enrollmentData[1];
                String academicYear = enrollmentData[2];
                String semester = enrollmentData[3];
                
                // Buat objek Enrollment baru dan tambahkan ke ArrayList
                // Grade akan otomatis "None" karena sudah diatur di konstruktor Enrollment
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            }
        }

        // Setelah semua input diterima, tampilkan semua Enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment); // Otomatis memanggil method toString() dari objek Enrollment
        }

        input.close(); // Tutup scanner
    }
}

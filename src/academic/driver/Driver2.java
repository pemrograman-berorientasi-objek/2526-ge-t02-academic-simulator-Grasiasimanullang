// 12S24027_Grasia
package academic.driver;

import academic.model.Student; // Penting: import kelas Student dari package model
import java.util.Scanner;
import java.util.ArrayList; 

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList untuk menyimpan Student karena jumlahnya dinamis
        ArrayList<Student> students = new ArrayList<>(); 

        // Loop untuk membaca input baris per baris
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Pisahkan string input menggunakan '#'
            String[] studentData = line.split("#");
            if (studentData.length == 4) { // Pastikan ada 4 bagian data
                String id = studentData[0];
                String name = studentData[1];
                String year = studentData[2];
                String major = studentData[3];
                
                // Buat objek Student baru dan tambahkan ke ArrayList
                Student newStudent = new Student(id, name, year, major);
                students.add(newStudent);
            }
        }

        // Setelah semua input diterima, tampilkan semua Student yang tersimpan
        for (Student student : students) {
            System.out.println(student); // Otomatis memanggil method toString() dari objek Student
        }

        input.close(); // Tutup scanner
    }
}

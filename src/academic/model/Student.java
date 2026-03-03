// 12S24027_Grasia
package academic.model;

public class Student {
    private String id;
    private String name;
    private String year; // Tahun masuk
    private String major; // Jurusan

    public Student(String id, String name, String year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Getter methods untuk mengambil data
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        // Ini penting untuk format output yang diminta: id|name|year|major
        return id + "|" + name + "|" + year + "|" + major;
    }
}

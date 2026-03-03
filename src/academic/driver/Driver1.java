// 12S24027_Grasia
package academic.driver;

        import academic.model.Course;
        import java.util.Scanner;
        import java.util.ArrayList;

        public class Driver1 {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                ArrayList<Course> courses = new ArrayList<>();

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    if (line.equals("---")) {
                        break;
                    }

                    String[] courseData = line.split("#");
                    if (courseData.length == 4) {
                        String code = courseData[0];
                        String name = courseData[1];
                        int credits = Integer.parseInt(courseData[2]);
                        String grade = courseData[3];
                        
                        Course newCourse = new Course(code, name, credits, grade);
                        courses.add(newCourse);
                    }
                }

                for (Course course : courses) {
                    System.out.println(course);
                }

                input.close();
            }
        }
        
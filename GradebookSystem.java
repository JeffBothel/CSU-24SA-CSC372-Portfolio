import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GradebookSystem {
    private static Student gatherStudent() {
        Console userLine = System.console();
        Random rand = new Random();
        System.out.print("Enter student ID (0 for random): ");
        int id = Integer.parseInt(userLine.readLine());
        if (id == 0) {
            id = rand.nextInt(64);
        }
        
        System.out.print("Enter student first name: ");
        String firstName = userLine.readLine();

        System.out.print("Enter student last name: ");
        String lastName = userLine.readLine();


        System.out.print("Enter student GPA: ");
        double gpa = Double.parseDouble(userLine.readLine());
        return new Student(id, firstName, lastName, gpa);
    }

    private static void gatherCourse(StudentList students) {
        Console userLine = System.console();
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(userLine.readLine());
        int studentArrayId = students.getStudentIndex(studentId);
        if (studentArrayId == -1) {
            System.out.println("Student not found.");
            return;
        }
        students.getStudent(studentId).addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"A"));
    }

    private static void saveOutFile(StudentList students) {
        // Save the student list to a file
        try(PrintWriter writer = new PrintWriter("students.txt")) {
            writer.print(students.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Console userLine = System.console();
        String[] input;
        StudentList students = new StudentList();
        while(true) {
            System.out.print("Enter a command: ");
            input = userLine.readLine().split(" ");
            switch(input[0]) {
                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "add":
                    switch(input[1]) {
                        case "student":
                            System.out.println("Adding student...");
                            students.addStudent(gatherStudent());
                            students.sortStudentsLastName();
                            System.out.println(students.toString());
                            break;
                        case "course":
                            System.out.println("Adding course...");
                            break;
                        default:
                            System.out.println("Invalid command. Please enter a valid command.");
                    }
                    break;
                case "remove":
                    System.out.println("Removing student...");
                    break;
                case "sort":
                    switch(input[1]) {
                        case "id":
                            System.out.println("Sorting students by ID...");
                            students.sortStudentsID();
                            break;
                        case "last":
                        default:
                            System.out.println("Sorting students by last name...");
                            students.sortStudentsLastName();
                            break;
                    }
                    students.sortStudentsLastName();
                    break;
                case "show":
                    System.out.println("Showing students...");
                    System.out.println(students.toString());
                    break;
                case "testload":
                    System.out.println("Loading test students and courses...");
                    Random rand = new Random();
                    Student student1 = new Student(rand.nextInt(64),"Jason","Dibbert");
                        student1.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"A"));
                        student1.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"B"));
                        student1.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"C"));
                        student1.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"D"));
                    Student student2 = new Student(rand.nextInt(64),"Augusta","Greenholt");
                        student2.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"A"));
                        student2.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"A"));
                        student2.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"A"));
                        student2.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"A"));
                    Student student3 = new Student(rand.nextInt(64),"Ivah","Prohaska");
                        student3.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"B"));
                        student3.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"B"));
                        student3.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"B"));
                        student3.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"B"));
                    Student student4 = new Student(rand.nextInt(64),"Cameron","O'Conner");
                        student4.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"C"));
                        student4.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"C"));
                        student4.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"C"));
                        student4.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"C"));
                    Student student5 = new Student(rand.nextInt(64),"Allie","Goldner");
                        student5.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"D"));
                        student5.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"F"));
                        student5.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"A"));
                        student5.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"B"));
                    Student student6 = new Student(rand.nextInt(64),"General","Rippin");
                        student6.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"A"));
                        student6.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"A"));
                        student6.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"A"));
                        student6.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"A"));
                    Student student7 = new Student(rand.nextInt(64),"Haylie","Ledner");
                        student7.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"B"));
                        student7.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"B"));
                        student7.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"B"));
                        student7.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"B"));
                    Student student8 = new Student(rand.nextInt(64),"Dedrick","Rutherford");
                        student8.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"C"));
                        student8.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"C"));
                        student8.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"C"));
                        student8.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"C"));
                    Student student9 = new Student(rand.nextInt(64),"Brendan","Ledner");
                        student9.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"D"));
                        student9.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"F"));
                        student9.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"A"));
                        student9.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"B"));
                    Student student10 = new Student(rand.nextInt(64),"Kirstin","Ebert");
                        student10.addCourse(new Course("CS101","Intro to Computer Science","Fall",2019,3,"A"));
                        student10.addCourse(new Course("CS102","Data Structures","Spring",2020,3,"B"));
                        student10.addCourse(new Course("CS103","Algorithms","Fall",2020,3,"C"));
                        student10.addCourse(new Course("CS104","Operating Systems","Spring",2021,3,"D"));
                    students.addStudent(student1);
                    students.addStudent(student2);
                    students.addStudent(student3);
                    students.addStudent(student4);
                    students.addStudent(student5);
                    students.addStudent(student6);
                    students.addStudent(student7);
                    students.addStudent(student8);
                    students.addStudent(student9);
                    students.addStudent(student10);
                    break;
                case "save":
                    System.out.println("Saving students...");
                    saveOutFile(students);
                    break;
                default:
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        }
    }
}
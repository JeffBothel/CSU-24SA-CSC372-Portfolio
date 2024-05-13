import java.util.ArrayList;

public class StudentList {
    public ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<Student>();
    }

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentList(Student[] students) {
        this.students = new ArrayList<Student>();
        for (Student student : students) {
            this.students.add(student);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudent(int rollnum) {
        for (Student student : students) {
            if (student.getID() == rollnum) {
                return student;
            }
        }
        return null;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void sortStudentsLastName() {
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getLastName().compareTo(students.get(j).getLastName()) > 0) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }

    public void sortStudentsID() {
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getID() > students.get(j).getID()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }

    public String toString() {
        String result = "";
        for (Student student : students) {
            result += student.toString() + "\n";
        }
        return result;
    }

    public int getStudentIndex(int rollnum) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == rollnum) {
                return i;
            }
        }
        return -1;
    }
}